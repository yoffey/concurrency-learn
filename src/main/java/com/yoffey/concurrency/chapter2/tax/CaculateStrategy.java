package com.yoffey.concurrency.chapter2.tax;

/**
 * Description: .
 * All Rights Reserved.
 *
 * 税金计算策略
 * @version 1.0 2019/3/11 下午4:38 by 宗永飞（yongfei.zong@ucarinc.com）创建
 */
public interface CaculateStrategy {
    double caculate(double salary, double bonus);
}
