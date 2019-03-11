package com.yoffey.concurrency.chapter2.ticket;

/**
 * Description: .
 * All Rights Reserved.
 *
 * 模拟银行柜台取号
 * @version 1.0 2019/3/11 下午2:25 by 宗永飞（yongfei.zong@ucarinc.com）创建
 */
public class TicketWindow extends Thread {
    private static int index = 1;
    private static final int MAX = 50;

    public TicketWindow(String name) {
        super(name);
    }

    @Override
    public void run() {
        while (index <= MAX) {
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("当前柜台是" + Thread.currentThread().getName() + ", 当前号码是：" + index++);
        }
    }
}
