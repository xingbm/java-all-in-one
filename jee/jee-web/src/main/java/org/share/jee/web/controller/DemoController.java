package org.share.jee.web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * ** created by DawnSailing at 2019/10/11
 *
 * @author DawnSailing
 */
@Controller
@RequestMapping("/")
public class DemoController {

    AtomicInteger atomicInteger = new AtomicInteger();

    @GetMapping("/test")
    @ResponseBody
    public String statusTest() throws Exception {
        return Thread.currentThread().getId() + "-" + Thread.currentThread().getName() + ",请求序号：" + atomicInteger.getAndIncrement();
    }

}
