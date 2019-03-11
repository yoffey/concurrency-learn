package com.yoffey.concurrency.chapter2.ticket;

/**
 * Description: .
 * All Rights Reserved.
 *
 * @version 1.0 2019/3/11 下午2:25 by 宗永飞（yongfei.zong@ucarinc.com）创建
 */
public class Bank1 {
    public static void main(String[] args) {
        TicketWindow tw1 = new TicketWindow("一号");
        tw1.start();
        TicketWindow tw2 = new TicketWindow("二号");
        tw2.start();
        TicketWindow tw3 = new TicketWindow("三号");
        tw3.start();
    }
}
