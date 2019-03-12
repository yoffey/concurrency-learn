package com.yoffey.concurrency.chapter5;

import java.util.stream.IntStream;

/**
 * Description: 了解线程join的用法.
 * All Rights Reserved.
 *
 * @version 1.0 2019/3/12 by 宗永飞（yongfei.zong@ucarinc.com）创建
 */
public class ThreadJoin {
    public static void main(String[] args) {
        Thread t = new Thread(() -> {
            IntStream.range(1, 1000).forEach(i -> System.out.println(Thread.currentThread().getName() + "=> " + i));
            System.out.println(Thread.currentThread().getName() + "=> task finish!");
        });

        Thread t2 = new Thread(() -> {
            IntStream.range(1, 1000).forEach(i -> System.out.println(Thread.currentThread().getName() + "=> " + i));
            System.out.println(Thread.currentThread().getName() + "=> task finish!");
        });
        t.start();
        t2.start();
        try {
            t.join();
            t2.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(Thread.currentThread().getName() + "=> task finish!");
    }
}
