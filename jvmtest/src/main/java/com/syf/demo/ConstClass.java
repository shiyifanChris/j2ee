package com.syf.demo;

import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

/**
 * Created by dell
 * at 2018/1/16
 */
public class ConstClass {
    static {
        System.out.println("ConstClass init");
    }

    public static final String HELLO = "Hello";

    public static void main(String[] args) {
//        LocalDateTime dateTime = LocalDateTime.now();
//        String format = dateTime.format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"));
//        System.out.println(format);
    }
}
