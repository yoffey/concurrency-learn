package com.yoffey.concurrency.chapter2.tax;

/**
 * Description: .
 * All Rights Reserved.
 *
 * 个人所得税计算
 * @version 1.0 2019/3/11 下午2:47 by 宗永飞（yongfei.zong@ucarinc.com）创建
 */
public class TaxCaculateMain {
    public static void main(String[] args) {
        TaxCaculator tc = new TaxCaculator(10000, 2000) {
            @Override
            protected double caculateWay() {
                return getSalary() * 0.1 + getBonus() * 0.15;
            }
        };
        double tax = tc.caculateTax();
        System.out.println("通过重写方法计算的税金为：" + tax);

        System.out.println("-------------------------");
        TaxCaculator tc2 = new TaxCaculator(10000, 2000, new SimpleCaculaterStrategy());
        double tax2 = tc2.caculateTax();
        System.out.println("通过策略计算的税金为：" + tax2);
    }
}
