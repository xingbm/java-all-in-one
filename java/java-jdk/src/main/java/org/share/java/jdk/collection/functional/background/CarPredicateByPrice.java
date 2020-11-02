package org.share.java.jdk.collection.functional.background;

/**
 * Created by DawnSailing on 2020/10/8 17:07
 * 获取车价格大于30W的车
 *
 */
public class CarPredicateByPrice implements CarPredicate {

    @Override
    public boolean test(Car car) {
        return car.getPrice()>30;
    }

}
