package org.share.jee.web.controller;

import org.springframework.aop.framework.AopContext;
import org.springframework.aop.support.AopUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.Async;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.request.async.DeferredResult;
import org.springframework.web.context.request.async.TimeoutCallableProcessingInterceptor;
import org.springframework.web.context.request.async.WebAsyncTask;
import org.springframework.web.servlet.config.annotation.AsyncSupportConfigurer;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

import javax.annotation.Resource;
import javax.servlet.AsyncContext;
import javax.servlet.AsyncEvent;
import javax.servlet.AsyncListener;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.Callable;
import java.util.concurrent.Executor;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

/**
 * ** created by DawnSailing at 2019/9/9
 *
 * @author DawnSailing
 */
@RestController
@RequestMapping("/async")
public class AsyncTestController {

    /**
     * 获取ApplicationContext对象
     */
    @Autowired
    private ApplicationContext applicationContext;

    /**
     * Servlet方式实现异步请求
     * @param request
     * @param response
     */
    @GetMapping("/test1")
    public void test1(HttpServletRequest request, HttpServletResponse response) {
        AsyncContext asyncContext = request.startAsync();
        // 设置监听器:可设置其开始、完成、异常、超时等事件的回调处理
        asyncContext.addListener(new AsyncListener() {
            @Override
            public void onComplete(AsyncEvent asyncEvent) throws IOException {
                System.out.println("执行完成");
                //这里可以做一些清理资源的操作...
            }

            @Override
            public void onTimeout(AsyncEvent asyncEvent) throws IOException {
                System.out.println("超时了...");
                //做一些超时后的相关操作...
            }

            @Override
            public void onError(AsyncEvent asyncEvent) throws IOException {
                System.out.println("发生错误：" + asyncEvent.getThrowable());
            }

            @Override
            public void onStartAsync(AsyncEvent asyncEvent) throws IOException {
                System.out.println("线程开始");
            }
        });
        //设置超时时间
        asyncContext.setTimeout(20000);
        asyncContext.start(new Runnable() {
            @Override
            public void run() {
                try {
                    Thread.sleep(10000);
                    System.out.println("内部线程：" + Thread.currentThread().getName());
                    asyncContext.getResponse().setCharacterEncoding("utf-8");
                    asyncContext.getResponse().setContentType("text/html;charset=UTF-8");
                    asyncContext.getResponse().getWriter().println("这是异步的请求返回");
                } catch (Exception e) {
                    System.out.println("异常："+e);
                }
                //异步请求完成通知
                //此时整个请求才完成
                asyncContext.complete();
            }
        });
        //此时之类 request的线程连接已经释放了
        System.out.println("主线程：" + Thread.currentThread().getName());
    }

    /**
     * 直接返回的参数包裹一层callable即可，可以继承WebMvcConfigurerAdapter类来设置默认线程池和超时处理
     * @return
     */
    @GetMapping("/test2")
    public Callable<String> test2() {
        System.out.println("外部线程：" + Thread.currentThread().getName());
        return new Callable<String>() {
            @Override
            public String call() throws Exception {
                Thread.sleep(10000);
                System.out.println("内部线程：" + Thread.currentThread().getName());
                return "callable!";
            }
        };
    }

    @Configuration
    public class RequestAsyncPoolConfig extends WebMvcConfigurerAdapter {

        @Resource
        private ThreadPoolTaskExecutor myThreadPoolTaskExecutor;

        @Override
        public void configureAsyncSupport(final AsyncSupportConfigurer configurer) {
            //处理 callable超时
            configurer.setDefaultTimeout(60 * 1000);
            configurer.setTaskExecutor(myThreadPoolTaskExecutor);
            configurer.registerCallableInterceptors(timeoutCallableProcessingInterceptor());
        }

        @Bean
        public TimeoutCallableProcessingInterceptor timeoutCallableProcessingInterceptor() {
            return new TimeoutCallableProcessingInterceptor();
        }
    }

    /**
     * 在Callable外包一层，给WebAsyncTask设置一个超时回调，即可实现超时处理
     */
    @GetMapping("/test3")
    public WebAsyncTask<String> test3() {
        System.out.println("外部线程：" + Thread.currentThread().getName());
        Callable<String> result = () -> {
            System.out.println("内部线程开始：" + Thread.currentThread().getName());
            try {
                TimeUnit.SECONDS.sleep(4);
            } catch (Exception e) {
                // TODO: handle exception
            }
            System.out.println("内部线程返回：" + Thread.currentThread().getName());
            return "success";
        };

        WebAsyncTask<String> wat = new WebAsyncTask<String>(3000L, result);
        wat.onTimeout(new Callable<String>() {

            @Override
            public String call() throws Exception {
                // TODO Auto-generated method stub
                return "超时";
            }
        });
        return wat;
    }

    /**
     * DeferredResult可以处理一些相对复杂一些的业务逻辑，最主要还是可以在另一个线程里面进行业务处理及返回，即可在两个完全不相干的线程间的通信。
     */
    @GetMapping("/test4")
    public DeferredResult<String> test4() {
        System.out.println("外部线程：" + Thread.currentThread().getName());
        //设置超时时间
        DeferredResult<String> result = new DeferredResult<String>(60*1000L);
        //处理超时事件 采用委托机制
        result.onTimeout(new Runnable() {

            @Override
            public void run() {
                System.out.println("DeferredResult超时");
                result.setResult("超时了!");
            }
        });
        result.onCompletion(new Runnable() {

            @Override
            public void run() {
                //完成后
                System.out.println("调用完成");
            }
        });

        new ThreadPoolTaskExecutor().execute(new Runnable() {

            @Override
            public void run() {
                //处理业务逻辑
                System.out.println("内部线程：" + Thread.currentThread().getName());
                //返回结果
                result.setResult("DeferredResult!!");
            }
        });
        return result;
    }

    @GetMapping("/test5")
    public Map<String, Object> test5() {
        Map<String, Object> resMap = new HashMap<String, Object>();
        try{
            //这样调用同类下的异步方法是不起作用的
            //this.testAsyncTask();
            //通过上下文获取自己的代理对象调用异步方法
            AsyncTestController emailController = (AsyncTestController)applicationContext.getBean(AsyncTestController.class);
            emailController.testAsyncTask();
            resMap.put("code",200);
        }catch (Exception e) {
            resMap.put("code",400);
        }
        return resMap;
    }

    @Async
    public void testAsyncTask() throws InterruptedException {
        Thread.sleep(10000);
        System.out.println("异步任务执行完成！");
    }

    @GetMapping("/test6")
    public void test6() throws InterruptedException {
        //是否是代理对象
        boolean isAop = AopUtils.isAopProxy(AsyncTestController.class);
        //是否是CGLIB方式的代理对象
        boolean isCglib = AopUtils.isCglibProxy(AsyncTestController.class);
        //是否是JDK动态代理方式的代理对象
        boolean isJdk = AopUtils.isJdkDynamicProxy(AsyncTestController.class);
        //以下才是重点!!!
        AsyncTestController asyncTestController = (AsyncTestController)applicationContext.getBean(AsyncTestController.class);
        AsyncTestController proxy = (AsyncTestController) AopContext.currentProxy();
        System.out.println(asyncTestController == proxy ? true : false);
        proxy.testAsyncTask();
        System.out.println("end!!!");
    }

}
