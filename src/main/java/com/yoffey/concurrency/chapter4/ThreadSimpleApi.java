package com.yoffey.concurrency.chapter4;

import java.util.Optional;

/**
 * Description: 了解Thread的api.
 * All Rights Reserved.
 *
 * @version 1.0 2019/3/12 by 宗永飞（yongfei.zong@ucarinc.com）创建
 */
public class ThreadSimpleApi {
    public static void main(String[] args) {
        Thread t = new Thread() {
            @Override
            public void run() {
                System.out.println("doing something~~~~");
                try {
                    sleep(10_000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        };

        t.start();
        Optional.of(t.getName()).ifPresent(System.out::println);
        Optional.of(t.getId()).ifPresent(System.out::println);
        Optional.of(t.isDaemon()).ifPresent(System.out::println);
        Optional.of(t.getPriority()).ifPresent(System.out::println);
        Optional.of(t.getState()).ifPresent(System.out::println);
    }
}
