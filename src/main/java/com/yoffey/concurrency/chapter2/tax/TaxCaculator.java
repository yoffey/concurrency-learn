package com.yoffey.concurrency.chapter2.tax;

/**
 * Description: .
 * All Rights Reserved.
 *
 * @version 1.0 2019/3/11 下午4:22 by 宗永飞（yongfei.zong@ucarinc.com）创建
 */
public class TaxCaculator {
    private double salary; // 工资
    private double bonus; // 奖金
    private CaculateStrategy caculateStrategy; // 税金计算策略

    public TaxCaculator(double salary, double bonus) {
        this.salary = salary;
        this.bonus = bonus;
    }

    public TaxCaculator(double salary, double bonus, CaculateStrategy caculateStrategy) {
        this.salary = salary;
        this.bonus = bonus;
        this.caculateStrategy = caculateStrategy;
    }

    public double caculateTax() {
        return this.caculateWay();
    }

    protected double caculateWay() {
        // 子类重写，税金的计算方式
        return this.caculateStrategy.caculate(salary, bonus);
    }

    public double getSalary() {
        return salary;
    }

    public double getBonus() {
        return bonus;
    }
}
