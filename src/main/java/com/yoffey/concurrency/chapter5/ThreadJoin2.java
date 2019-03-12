package com.yoffey.concurrency.chapter5;

/**
 * Description: 线程的join的复杂用法.
 * All Rights Reserved.
 *
 * @version 1.0 2019/3/12 by 宗永飞（yongfei.zong@ucarinc.com）创建
 */
public class ThreadJoin2 {
    public static void main(String[] args) throws InterruptedException {
//        Thread t = new Thread(() -> {
//            try {
//                Thread.sleep(10_000);
//            } catch (InterruptedException e) {
//                e.printStackTrace();
//            }
//            System.out.println(Thread.currentThread().getName() + "=> task finish!");
//        });
//        t.start();
//        t.join(2_000, 100);
//        System.out.println("2秒100纳秒之后，结束join，main线程继续执行操作");
//
//        System.out.println(Thread.currentThread().getName() + "=> task finish!");
////        Thread.currentThread().join(); // main线程在等待main线程结束，才可以结束main线程，无限等待！
//        Thread.currentThread().join(5_000);
//        System.out.println("main线程join5秒之后结束");

        Thread t1 = new Thread(()->{
            while (true) {
                System.out.println(Thread.currentThread().getName() + "=> 是否被打断：" + Thread.currentThread().isInterrupted());
            }
        }, "t1");
        t1.start();
        Thread t2 = new Thread(()->{
            try {
                Thread.sleep(4_000);
                t1.interrupt();
                System.out.println("interrupt t1 thread");
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }, "t2");
        t2.start();

        t1.join(2_000);
        System.out.println(Thread.currentThread().getName() + "=> task finish!");
    }
}
