package com.zy.pctransaction.tack;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * date:  2020-06-29 13:58
 *
 * @author zhengyao
 */
public class Task {

    private Lock lock = new ReentrantLock();

    private Condition condition = lock.newCondition();

    //等待
    public void waitTask() {
        try {
            lock.lock();
            condition.await();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
        }
    }

    //唤醒
    public void signalTask() {
        lock.lock();
        condition.signal();
        lock.unlock();
    }
}
