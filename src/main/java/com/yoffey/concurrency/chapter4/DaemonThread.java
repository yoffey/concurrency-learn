package com.yoffey.concurrency.chapter4;

/**
 * Description: .
 * All Rights Reserved.
 *
 * 了解守护线程
 * 守护线程的意义就是当前线程结束，当前线程创建的守护线程一起结束
 * @version 1.0 2019/3/12 上午10:18 by 宗永飞（yongfei.zong@ucarinc.com）创建
 */
public class DaemonThread {
    public static void main(String[] args) {
        Thread thread = new Thread() {
            @Override
            public void run() {
                System.out.println("begin do something!");
                try {
                    sleep(20_000L);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println("end do something!");
            }
        };
        thread.setDaemon(true); // 设置在start前面就是守护线程
        thread.start();
//        thread.setDaemon(true); // 设置在start后面的话，不是守护线程   并且会报异常IllegalThreadStateException

        try {
            Thread.sleep(5_000L);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("main thread finish!");
    }
}
