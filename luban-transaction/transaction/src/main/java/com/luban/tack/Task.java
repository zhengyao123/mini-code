package com.luban.tack;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * 需要咨询java高级VIP课程的同学可以加安其拉老师的QQ：3164703201
 * 需要视频资料的可以添加白浅老师的QQ：2207192173
 * author：鲁班学院-商鞅老师
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
