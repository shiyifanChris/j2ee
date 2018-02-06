package com.syf.demo;

import java.time.LocalDate;

/**
 * Created by dell
 * at 2018/1/17
 */
public class Parent {

    static class Sup{
        public static int A = 1;
        static {
            A = 2;
        }
    }

    static class Sub extends Sup{
        public static int B = A;
    }

    public static void main(String[] args) {
        System.out.println(Sub.B);
        System.out.println(ConstClass.HELLO);

        LocalDate date = LocalDate.now();
        System.out.println(date);
    }
}



