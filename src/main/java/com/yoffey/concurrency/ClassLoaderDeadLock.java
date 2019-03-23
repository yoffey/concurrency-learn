package com.yoffey.concurrency;

import sun.misc.Service;

import java.util.Iterator;

/**
 * jdk1.6下死锁
 *
 * Created by Yoffey on 2019-03-23.
 */

public class ClassLoaderDeadLock {
    public static void main(String[] args) throws ClassNotFoundException {
        Thread1 thread1 = new Thread1();
        Thread2 thread2 = new Thread2();
        thread1.start();
        thread2.start();
    }
}

class Thread1 extends Thread {
    public void run() {
        try {
            Class clazz = Class.forName("com.mysql.jdbc.Driver", true, Thread.currentThread()
                    .getContextClassLoader());
            System.out.println(clazz);
        } catch (ClassNotFoundException e) {
        }
    }
}

class Thread2 extends Thread {
    public void run() {
        Iterator ps = Service.providers(java.sql.Driver.class);
        try {
            while (ps.hasNext()) {
                System.out.println(ps.next());
            }
        } catch (Throwable t) {

        }
    }
}
