package com.syf.demo;

public class Daemon {
    public static void main(String[] args) {
        Thread thread = new Thread(new DaemonRunner(), "DaemonRunner");
        thread.setDaemon(true);
        thread.start();
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    static class DaemonRunner implements Runnable {
        @Override
        public void run() {
            try {
                Thread.sleep(1000);
            }catch (Exception e){

            }finally {
                System.out.println("DaemonThread finally run.");
            }
        }
    }
}