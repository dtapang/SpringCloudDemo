package com.itlize.order.utils;

import java.util.Random;

/**
 * Created by Yang Shu
 * 2017-12-10 16:57
 */
public class KeyUtil {

    /**
     * Generate a unique primary key
     * Format: time + random number
     */
    public static synchronized String genUniqueKey() {
        Random random = new Random();
        Integer number = random.nextInt(900000) + 100000;

        return System.currentTimeMillis() + String.valueOf(number);
    }
}
