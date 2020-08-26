package com.zy.minicodeluban.jvm.oom;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * date:  2020-08-26 11:20
 *
 * @author zhengyao
 */
public class ThreadDeadLock {

    private static Lock lock1 = new ReentrantLock();
    private static Lock lock2 = new ReentrantLock();

    public static void main(String[] args) {

        new Thread(()->{
            try {
                lock1.lock();
                TimeUnit.SECONDS.sleep(1);
                lock2.lock();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        },"thread-one").start();

        new Thread(()->{
            try {
                lock2.lock();
                TimeUnit.SECONDS.sleep(1);
                lock1.lock();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        },"thread-two").start();
    }
}
