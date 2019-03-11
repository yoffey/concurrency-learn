package com.yoffey.concurrency.chapter1;

/**
 * Description: .
 * All Rights Reserved.
 *  简单测试并发
 * @version 1.0 2019/3/11 下午2:06 by 宗永飞（yongfei.zong@ucarinc.com）创建
 */
public class TryConcurrency {
    public static void main(String[] args) {
        Thread t = new Thread("Read-Thread") {
            @Override
            public void run() {
                printCurrentThreadName();
                readFromDB();
            }
        };
        t.start();

        Thread t2 = new Thread("Write-Thread") {
            @Override
            public void run() {
                printCurrentThreadName();
                writeDataToFile();
            }
        };
        t2.start();
    }

    private static void printCurrentThreadName() {
        System.out.println("当前线程名称==>" + Thread.currentThread().getName());
    }

    private static void readFromDB() {
        System.out.println("begin read data from db...");
        try {
            Thread.sleep(1000 * 10);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("end read data from db...");
    }

    private static void writeDataToFile() {
        System.out.println("begin write data to file...");
        try {
            Thread.sleep(1000 * 15);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("end write data to file...");
    }

}
