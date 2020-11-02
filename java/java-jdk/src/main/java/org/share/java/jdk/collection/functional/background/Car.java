package org.share.java.jdk.collection.functional.background;

import java.util.ArrayList;
import java.util.List;
import java.util.StringJoiner;

/**
 * Created by DawnSailing on 2020/10/8 16:20
 */
public class Car {

    /**
     * 车牌号
     */
    private String code;
    /**
     * 颜色
     */
    private String color;
    /**
     * 生产商
     */
    private String factory;
    /**
     * 价格
     */
    private double price;

    public Car() {
    }

    public Car(String code, String color, String factory, double price) {
        this.code = code;
        this.color = color;
        this.factory = factory;
        this.price = price;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public String getFactory() {
        return factory;
    }

    public void setFactory(String factory) {
        this.factory = factory;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return new StringJoiner(", ", Car.class.getSimpleName() + "[", "]")
                .add("code='" + code + "'")
                .add("color='" + color + "'")
                .add("factory='" + factory + "'")
                .add("price=" + price)
                .toString();
    }

    public static List<Car> InitCar(){
        ArrayList<Car> carList = new ArrayList<>();
        Car car1 = new Car("100", "black", "中国", 20);
        Car car2 = new Car("101", "gray", "中国", 30);
        Car car3 = new Car("102", "yellow", "中国", 50);
        Car car4 = new Car("103", "silvery", "英国", 20);
        Car car5 = new Car("104", "red", "英国", 30);
        Car car6 = new Car("104", "red", "英国", 10);
        carList.add(car1);
        carList.add(car2);
        carList.add(car3);
        carList.add(car4);
        carList.add(car5);
        carList.add(car6);
        return carList;
    }

    /**
     * 通过价格获取车
     * @param carList
     * @return
     */
    public static List<Car> getCarByLowPrice(List<Car> carList) {
        ArrayList<Car> resultList = new ArrayList<>();
        for (Car car : carList) {
            if (car.getPrice()>20) {
                resultList.add(car);
            }
        }
        return resultList;
    }

    /**
     * 通过价格获取车
     * @param carList
     * @return
     */
    public static List<Car> getCarByHighPrice(List<Car> carList){
        ArrayList<Car> resultList = new ArrayList<>();
        for (Car car : carList){
            if (car.getPrice()>30){
                resultList.add(car);
            }
        }
        return resultList;
    }

    /**
     * 通过价格获取车
     * @param carList
     * @param price
     * @return
     */
    public static List<Car> getCarByPrice(List<Car> carList,double price){
        ArrayList<Car> resultList = new ArrayList<>();
        for (Car car : carList){
            if (car.getPrice()>price){
                resultList.add(car);
            }
        }
        return resultList;
    }

    /**
     * 通过颜色和价格获取车
     * @param carList
     * @param color
     * @param price
     * @return
     */
    public static List<Car> getCarByColarAndPrce(List<Car> carList,String color,double price) {
        ArrayList<Car> resultList = new ArrayList<>();
        for (Car car : carList){
            if (color.equals(car.getColor())) {
                if (car.getPrice()>30) {
                    resultList.add(car);
                }
            }
        }
        return resultList;
    }

    public static List<Car> getCarByPredicate(List<Car> carList, CarPredicate carPredicate) {
        ArrayList<Car> resultList = new ArrayList<>();
        for (Car car : carList){
            if (carPredicate.test(car)) {
                resultList.add(car);
            }
        }
        return resultList;
    }

}
