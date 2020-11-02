package org.share.java.jdk;

import com.sun.org.apache.xpath.internal.operations.String;
import org.springframework.beans.BeanUtils;

import java.lang.reflect.InvocationTargetException;

/**
 * ** created by xbm1990 at 2019/8/27
 *
 * @author xbm1990
 */
public class BeanUtilDemo {

    public static void main(String[] array) {
        // Spring BeanUtils
        BeanUtils.copyProperties(new String(), new String());
        // Apache common BeanUtils
        try {
            org.apache.commons.beanutils.BeanUtils.copyProperties(new String(), new String());
        } catch (IllegalAccessException iae) {

        } catch (InvocationTargetException ite) {

        }

    }

}
