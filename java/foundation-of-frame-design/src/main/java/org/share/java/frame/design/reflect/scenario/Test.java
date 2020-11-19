package org.share.java.frame.design.reflect.scenario;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import org.apache.commons.lang3.StringUtils;

import java.lang.reflect.Method;
import java.util.Set;

/**
 * Created by xingbm on 2020/11/2 21:56
 */
public class Test {

    public static void main(String[] args) throws Exception {
        progress();
    }

    /**
     * 简化读取配置
     */
    public static String getProfileData() {
        return "org.share.java.jdk.reflect.scenario.User";
    }

    /**
     * 简化数据库查询（用JSON代替了，JDBC其实也可以）
     */
    public static String getDataFromDatabase() {
        return "{\"address\":\"小米街道\",\"name\":\"雷军\",\"sex\":\"unknown\"}\n";
    }

    public static void progress() throws Exception {
        //读取配置得到对象配置
        Class useClass = Class.forName(getProfileData());
        //实例化对象
        Object needObj = useClass.newInstance();
        //读取数据库，获得数据
        JSONObject datas = JSON.parseObject(getDataFromDatabase());
        //获取参数名称集合
        Set<String> keys = datas.keySet();
        for (String key : keys) {
            //调用set方法
            Method md = useClass.getMethod("set" + StringUtils.capitalize(key), String.class);
            md.invoke(needObj, datas.get(key));
        }
        // 这就得到了需要的对象
        System.out.println(needObj);
    }

}
