package com.yoffey.concurrency.chapter4;

/**
 * Description: .
 * All Rights Reserved.
 *
 * 守护线程示例：心跳监测
 * @version 1.0 2019/3/12 上午10:26 by 宗永飞（yongfei.zong@ucarinc.com）创建
 */
public class DaemonThread2 {
    public static void main(String[] args) {
        Thread t = new Thread() {
            @Override
            public void run() {
                Thread innerThread = new Thread() {
                    @Override
                    public void run() {
                        while (true) {
                            System.out.println("health check~");
                            try {
                                sleep(1_000);
                            } catch (InterruptedException e) {
                                e.printStackTrace();
                            }
                        }
                    }
                };
                innerThread.setDaemon(true);
                innerThread.start();

                try {
                    System.out.println("begin do somthing~");
                    Thread.sleep(5_000);
                    System.out.println("end do something!");
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        };
        t.setDaemon(true);
        t.start();
        try {
            Thread.sleep(1_000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
