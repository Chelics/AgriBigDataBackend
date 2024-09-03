package com.agri.agribigdata.utils;

import java.util.Random;

public class VCodeUtils {
    public static Integer VCodeGenerator(){
        Random random = new Random();
        return random.nextInt(89999) + 10000;
    }
}
