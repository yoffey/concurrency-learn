package com.yoffey.concurrency.chapter3;

import java.util.Arrays;

/**
 * Description: .
 * All Rights Reserved.
 *
 * 了解ThreadGroup
 * @version 1.0 2019/3/11 下午5:29 by 宗永飞（yongfei.zong@ucarinc.com）创建
 */
public class Thread2 {
    public static void main(String[] args) {
        Thread t = new Thread() {
            @Override
            public void run() {
                try {
                    sleep(100);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        };
        t.start();
        System.out.println("线程t的ThreadGroup：" + t.getThreadGroup());
        System.out.println("当前线程名称：" + Thread.currentThread().getName());
        // 当前线程新建的时候没有指定ThreadGroup的时候，默认使用父类的
        System.out.println("当前线程的ThreadGroup：" + Thread.currentThread().getThreadGroup());

        ThreadGroup threadGroup = t.getThreadGroup();
        int activeCount = threadGroup.activeCount();
        System.out.println(activeCount);
        Thread[] threads = new Thread[activeCount];
        threadGroup.enumerate(threads);
//        for (Thread thread : threads) {
//            System.out.println(thread);
//        }
        Arrays.asList(threads).forEach(System.out::println);
    }
}
