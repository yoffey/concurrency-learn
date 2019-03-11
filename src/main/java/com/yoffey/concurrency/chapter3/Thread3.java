package com.yoffey.concurrency.chapter3;

/**
 * Description: .
 * All Rights Reserved.
 *
 * 了解StackSize
 * @version 1.0 2019/3/11 下午6:20 by 宗永飞（yongfei.zong@ucarinc.com）创建
 */
public class Thread3 {
    private static int counter;

    public static void main(String[] args) {
        try {
            add(0);
        } catch (Error e) {
            e.printStackTrace();
            // 会报：java.lang.StackOverflowError  counter: 21715
            System.out.println("counter: " + counter);
        }

    }

    private static void add(int temp) {
        ++counter;
        add(temp + 1);
    }
}
