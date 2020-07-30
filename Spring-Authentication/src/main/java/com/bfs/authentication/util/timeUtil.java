package com.bfs.authentication.util;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.TimeUnit;

public class timeUtil {

    private static DateFormat df = new SimpleDateFormat("MM/dd/yyyy HH:mm:ss");

    public static String getExpirationTime(Integer minutes){
        Date now = new Date(System.currentTimeMillis());
        Date expire = new Date(System.currentTimeMillis() + TimeUnit.MINUTES.toMillis(minutes));
        String expirationTime = df.format(expire);
        return expirationTime;
    }

    public static String getCurrentTime(){
        Date now = new Date(System.currentTimeMillis());
        String currentTime = df.format(now);
        return currentTime;
    }

    public static Date getDate(String dateFormat){
        try{
            Date date = df.parse(dateFormat);
            return date;
        }catch (ParseException e){
            System.out.println(e);
        }
        return null;
    }

    public static boolean compareDate(String d1, String d2){
        Date date1 = getDate(d1);
        Date date2 = getDate(d2);
        if (date1.compareTo(date2) >= 0){
            return true;
        }
        return false;
    }


}
