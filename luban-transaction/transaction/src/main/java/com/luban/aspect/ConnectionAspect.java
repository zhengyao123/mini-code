package com.luban.aspect;

import com.luban.connection.LbConnection;
import com.luban.transaction.TransactionMangage;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.sql.Connection;

/**
 * 需要咨询java高级VIP课程的同学可以加安其拉老师的QQ：3164703201
 * 需要视频资料的可以添加白浅老师的QQ：2207192173
 * author：鲁班学院-商鞅老师
 */
@Aspect
@Component
public class ConnectionAspect {

    @Around("execution(* javax.sql.DataSource.getConnection(..))")
    public Connection around(ProceedingJoinPoint proceedingJoinPoint){
        try {
//            return (Connection) proceedingJoinPoint.proceed();
            return new LbConnection((Connection) proceedingJoinPoint.proceed(), TransactionMangage.getCurrentTransaction());
        } catch (Throwable throwable) {
            throwable.printStackTrace();
        }
        return  null;
    }

}
