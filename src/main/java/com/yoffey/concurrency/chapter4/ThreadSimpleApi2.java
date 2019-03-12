package com.yoffey.concurrency.chapter4;

/**
 * Description: 线程的优先级.
 * All Rights Reserved.
 *
 * @version 1.0 2019/3/12 by 宗永飞（yongfei.zong@ucarinc.com）创建
 */
public class ThreadSimpleApi2 {
    public static void main(String[] args) {

        Thread t2 = new Thread(()->{
            for (int i = 0; i < 1000; i++) {
                System.out.println(Thread.currentThread().getName() + "=>" + i);
            }
        }, "线程优先级中等");
        t2.setPriority(Thread.NORM_PRIORITY);
        t2.start();

        Thread t1 = new Thread(()->{
            for (int i = 0; i < 1000; i++) {
                System.out.println(Thread.currentThread().getName() + "=>" + i);
            }
        }, "线程优先级最低");
        t1.setPriority(Thread.MIN_PRIORITY);
        t1.start();

        Thread t3 = new Thread(()->{
            for (int i = 0; i < 1000; i++) {
                System.out.println(Thread.currentThread().getName() + "=>" + i);
            }
        }, "线程优先级最高");
        t3.setPriority(Thread.MIN_PRIORITY);
        t3.start();

        // 线程的优先级并不能保证线程一定是优先级高的先执行，只是一种偏向
    }
}
