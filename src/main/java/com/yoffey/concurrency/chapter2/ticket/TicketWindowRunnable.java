package com.yoffey.concurrency.chapter2.ticket;

/**
 * Description: .
 * All Rights Reserved.
 *
 * @version 1.0 2019/3/11 下午2:36 by 宗永飞（yongfei.zong@ucarinc.com）创建
 */
public class TicketWindowRunnable implements Runnable{
    private int index = 1;
    private static final int MAX = 50;

    public void run() {
        while (index <= 50) {
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("当前柜台是" + Thread.currentThread().getName() + "，当前号码是：" + index++);
        }
    }
}
