package org.share.java.jdk.collection.functional.background;

/**
 * Created by DawnSailing on 2020/10/8 17:07
 * 筛选红色的车
 *
 */
public class CarPredicateByColor implements CarPredicate {

    @Override
    public boolean test(Car car) {
        return "red".equals(car.getColor());
    }

}
