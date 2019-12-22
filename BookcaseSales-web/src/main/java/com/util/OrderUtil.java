package com.util;

import java.util.UUID;

public class OrderUtil {
    public static String getOrderSnid(){
        return UUID.randomUUID().toString();
    }
}
