package com.yoffey.concurrency.chapter2.tax;

/**
 * Description: .
 * All Rights Reserved.
 *
 * 简单策略实现
 * @version 1.0 2019/3/11 下午4:50 by 宗永飞（yongfei.zong@ucarinc.com）创建
 */
public class SimpleCaculaterStrategy implements CaculateStrategy{

    public double caculate(double salary, double bonus) {
        return salary * 0.1 + bonus * 0.15;
    }
}
