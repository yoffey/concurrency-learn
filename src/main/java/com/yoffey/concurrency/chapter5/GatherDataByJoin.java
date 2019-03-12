package com.yoffey.concurrency.chapter5;

/**
 * Description: 模拟多个线程采集多台服务器的情景.
 * All Rights Reserved.
 *
 * @version 1.0 2019/3/12 by 宗永飞（yongfei.zong@ucarinc.com）创建
 */
public class GatherDataByJoin {
    public static void main(String[] args) throws InterruptedException {
        long startTime = System.currentTimeMillis();
        Thread t1 = new Thread(new GatherDataRunnable("M1", 10_000L));
        Thread t2 = new Thread(new GatherDataRunnable("M2", 5_000L));
        Thread t3 = new Thread(new GatherDataRunnable("M3", 7_000L));
        t1.start();
        t2.start();
        t3.start();
        t1.join();
        t2.join();
        t3.join();
        long endTime = System.currentTimeMillis();
        System.out.println("gather data cost time: " + (endTime - startTime));
    }

    static class GatherDataRunnable implements Runnable {
        private String machineName; // 被采集数据的服务器名称
        private Long spendTime; // 采集该服务器数据的耗时

        public GatherDataRunnable(String machineName, Long spendTime) {
            this.machineName = machineName;
            this.spendTime = spendTime;
        }

        @Override
        public void run() {
            try {
                Thread.currentThread().sleep(spendTime);
                System.out.println(Thread.currentThread().getName() + "=> gather data finish!");
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
