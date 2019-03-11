package com.yoffey.concurrency.chapter3;

/**
 * Description: .
 * All Rights Reserved.
 *
 * 测试StackSize的最大值
 * @version 1.0 2019/3/11 下午6:29 by 宗永飞（yongfei.zong@ucarinc.com）创建
 */
public class Thread4 {
    private static int counter = 1;
    public static void main(String[] args) {
        Thread t = new Thread(null, new Runnable() {
            @Override
            public void run() {
                try {
                    add(0);
                } catch (Error error) {
                    error.printStackTrace();
                    System.out.println("counter: " + counter);
                }
            }

//            private void add(int temp) {
//                counter++;
//                add(temp + 1);
//            }
        }, "TestMaxStackSize", 1 << 24);
        t.start();
    }

    private static void add(int temp) {
        counter++;
        add(temp + 1);
    }
}
