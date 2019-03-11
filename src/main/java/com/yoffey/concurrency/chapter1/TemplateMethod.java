package com.yoffey.concurrency.chapter1;

import java.sql.SQLOutput;

/**
 * Description: .
 * All Rights Reserved.
 *
 * 模板方法
 * @version 1.0 2019/3/11 下午2:15 by 宗永飞（yongfei.zong@ucarinc.com）创建
 */
public class TemplateMethod {
    public static void main(String[] args) {
        TemplateMethod tm = new TemplateMethod(){
            @Override
            protected void selfPrint() {
                System.out.println("AAAAAAA");
            }
        };
        tm.wrapPrint();

        TemplateMethod tm2 = new TemplateMethod(){
            @Override
            protected void selfPrint() {
                System.out.println("BBBBBBB");
            }
        };
        tm2.wrapPrint();
    }

    public final void wrapPrint() {
        System.out.println("++++++++++++");
        selfPrint();
        System.out.println("++++++++++++");
    }

    protected void selfPrint() {
        // 子类重写
    }
}
