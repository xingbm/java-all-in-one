package org.share.java.frame.design.reflect.scenario;

/**
 * Created by xingbm on 2020/11/2 21:56
 */
public class User {

    private String name;
    private  String address;
    private  String sex;
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public String getAddress() {
        return address;
    }
    public void setAddress(String address) {
        this.address = address;
    }
    public String getSex() {
        return sex;
    }
    public void setSex(String sex) {
        this.sex = sex;
    }

    @Override
    public String toString() {
        return "User对象:\n" +
                "名字='" + name + "\'\n" +
                "地址='" + address + "\'\n" +
                "性别='" + sex + "\'\n" ;
    }

}
