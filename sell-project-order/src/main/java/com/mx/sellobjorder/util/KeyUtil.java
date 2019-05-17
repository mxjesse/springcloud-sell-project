package com.mx.sellobjorder.util;

import java.util.Random;

/**
 * @author mx
 * @date 2019/5/10 10:42 AM
 */
public class KeyUtil {

    /**
     * 生成20位随机数字符串
     * @return
     */
    public static synchronized String genericKey() {

        Random random = new Random();
        int i = random.nextInt(10000000);
        return String.valueOf(System.currentTimeMillis()) + i;
    }
}
