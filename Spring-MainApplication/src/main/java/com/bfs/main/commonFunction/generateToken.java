package com.bfs.main.commonFunction;

import java.util.Random;

public class generateToken {

    private static String str =
            "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789";
    private static Random random = new Random();
    private static StringBuffer sb = new StringBuffer();

    public static String getRandomString(int length){
        sb.delete(0, sb.length());
        for (int i = 0; i < length; i++){
            int number = random.nextInt(62);
            sb.append(str.charAt(number));
        }
        return sb.toString();
    }
}
