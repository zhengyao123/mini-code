package com.luban.transaction;

import com.luban.tack.Task;

/**
 * 需要咨询java高级VIP课程的同学可以加安其拉老师的QQ：3164703201
 * 需要视频资料的可以添加白浅老师的QQ：2207192173
 * author：鲁班学院-商鞅老师
 */

public class Transaction {
    // 事务id
    private  String transactionId;
    // 事务组id
    private  String groupId;

    //事物状态  commit  还是 rollback
    private TransactionType transactionType;

    private Task task;

    public Transaction(String transactionId, String groupId) {
        this.transactionId = transactionId;
        this.groupId = groupId;
        task = new Task();
    }

    public String getTransactionId() {
        return transactionId;
    }

    public void setTransactionId(String transactionId) {
        this.transactionId = transactionId;
    }

    public String getGroupId() {
        return groupId;
    }

    public void setGroupId(String groupId) {
        this.groupId = groupId;
    }

    public TransactionType getTransactionType() {
        return transactionType;
    }

    public void setTransactionType(TransactionType transactionType) {
        this.transactionType = transactionType;
    }

    public Task getTask() {
        return task;
    }

    public void setTask(Task task) {
        this.task = task;
    }
}
