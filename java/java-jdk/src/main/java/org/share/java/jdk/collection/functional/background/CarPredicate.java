package org.share.java.jdk.collection.functional.background;

/**
 * Created by DawnSailing on 2020/10/8 17:06
 * 车条件判断接口
 *
 */
@FunctionalInterface
public interface CarPredicate {

    boolean test(Car car);

}
