package com.yoffey.concurrency.chapter2.ticket;

/**
 * Description: .
 * All Rights Reserved.
 *
 * 模拟银行取号--2， 通过runnable实现
 * @version 1.0 2019/3/11 下午2:36 by 宗永飞（yongfei.zong@ucarinc.com）创建
 */
public class Bank2 {
    public static void main(String[] args) {
        TicketWindowRunnable twr = new TicketWindowRunnable();
        Thread t1 = new Thread(twr, "一号");
        t1.start();
        Thread t2 = new Thread(twr, "二号");
        t2.start();
        Thread t3 = new Thread(twr, "三号");
        t3.start();
    }
}
