package com.yoffey.concurrency.chapter3;

/**
 * Description: .
 * All Rights Reserved.
 *
 * 线程类的名字
 * @version 1.0 2019/3/11 下午5:13 by 宗永飞（yongfei.zong@ucarinc.com）创建
 */
public class Thread1 {
    public static void main(String[] args) {
        Thread t1 = new Thread();
        Thread t2 = new Thread(){
            @Override
            public void run() {
                System.out.println("==========>");
            }
        };
        t1.start();
        t2.start();
        System.out.println(t1.getName());
        System.out.println(t2.getName());

        Thread t3 = new Thread("MyThread");
        Thread t4 = new Thread(() -> {
            System.out.println("Runnable...");
        });
        t3.start();
        t4.start();
        System.out.println(t3.getName());
        System.out.println(t4.getName());

        Thread t5 = new Thread(() -> {
            System.out.println("Runnable...." + Thread.currentThread().getName());
        }, "RunnableThread");
        t5.start();
    }
}
