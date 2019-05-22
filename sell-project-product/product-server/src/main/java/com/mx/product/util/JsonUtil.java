package com.mx.product.util;

import com.alibaba.fastjson.JSON;

/**
 * @author mx
 * @date 2019/5/21 12:37 AM
 */
public class JsonUtil {

    public static String toJson(Object object) {
        return JSON.toJSONString(object);
    }
}
