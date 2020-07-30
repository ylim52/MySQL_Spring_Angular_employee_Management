package com.bfs.main.commonFunction;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.TimeUnit;

public class getTime {

    public static String getExpirationTime(Integer minutes){
        Date now = new Date(System.currentTimeMillis());
        Date expire = new Date(System.currentTimeMillis() + TimeUnit.MINUTES.toMillis(minutes));
        String pattern = "MM/dd/yyyy HH:mm:ss";
        DateFormat df = new SimpleDateFormat(pattern);
        String expirationTime = df.format(expire);
        return expirationTime;
    }
}
