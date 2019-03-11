package com.yoffey.concurrency.chapter3;

/**
 * Description: .
 * All Rights Reserved.
 *
 * @version 1.0 2019/3/11 下午6:37 by 宗永飞（yongfei.zong@ucarinc.com）创建
 */
public class Thread5 {
    private static int counter = 1;
    public static void main(String[] args) {
        try {
            for (int i = 0; i < Integer.MAX_VALUE; i++) {
                counter++;
                Thread t = new Thread(new Runnable() {
                    @Override
                    public void run() {
                        try {
                            add(0);
                        } catch (Error error) {
                            error.printStackTrace();
                            System.out.println("counter: " + counter);
                        }
                    }

                    private void add(int temp) {
                        add(temp + 1);
                    }
                }, "TestMaxStackSize");
                t.start();
            }
        } catch (Error error) {
            error.printStackTrace();
            System.out.println(counter);
        }
    }
}
