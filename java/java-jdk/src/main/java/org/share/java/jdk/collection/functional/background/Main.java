package org.share.java.jdk.collection.functional.background;

import java.util.List;

/**
 * Created by DawnSailing on 2020/10/8 16:26
 */
public class Main {

    public static void main(String[] args) {
        // 获取 车价格 20 W以上的车
        // getCarByLowPriceTest();
        // 获取价格30W以上的车
        // getCarByHighPriceTest();

        // getCarByPriceTest(10.0);

        // getCarByColarAndPrceTest("yellow", 10.0);

        getCarByPredicatePriceTest();

        getCarByPredicateColorTest();

    }

    /**
     * 获取 车价格 20 W以上的车
     */
    public static void getCarByLowPriceTest() {
        // 初始化车信息
        List<Car> cars = Car.InitCar();
        // 获取价格20W以上的车
        List<Car> carByPrice = Car.getCarByLowPrice(cars);
        System.out.println(carByPrice);
    }

    /**
     * 获取 车价格 30 W以上的车
     */
    public static void getCarByHighPriceTest() {
        // 初始化车信息
        List<Car> cars = Car.InitCar();
        // 获取价格30W以上的车
        List<Car> carByPrice = Car.getCarByHighPrice(cars);
        System.out.println(carByPrice);
    }

    /**
     * 根据价格获取Car
     */
    public static void getCarByPriceTest(double price) {
        // 初始化车信息
        List<Car> cars = Car.InitCar();
        // 获取价格price以上的车
        List<Car> carByPrice = Car.getCarByPrice(cars, price);
        System.out.println(carByPrice);
    }

    /**
     * 根据颜色和价格获取Car
     * @param color
     * @param price
     */
    private static void getCarByColarAndPrceTest(String color,double price) {
        // 初始化车信息
        List<Car> cars = Car.InitCar();
        // 获取价格price以上的车
        List<Car> carByPrice = Car.getCarByColarAndPrce(cars, color, price);
        System.out.println(carByPrice);
    }

    public static void getCarByPredicatePriceTest() {
        // 初始化车信息
        List<Car> cars = Car.InitCar();
        // 获取价格大于30的车
        // 实现将条件代码封装进对象传递入参
        List<Car> carByPredicate = Car.getCarByPredicate(cars, new CarPredicateByPrice());
        System.out.println(carByPredicate);
    }

    public static void getCarByPredicateColorTest() {
        // 初始化车信息
        List<Car> cars = Car.InitCar();
        // 获取颜色为红色的车
        // 实现将条件代码封装进对象传递入参
        List<Car> carByPredicate = Car.getCarByPredicate(cars,new CarPredicateByColor());
        System.out.println(carByPredicate);
    }

}
