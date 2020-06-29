package com.zy.pctransaction.aspect;

import com.zy.pctransaction.connection.PcConnection;
import com.zy.pctransaction.transaction.TransactionMangage;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;

import java.sql.Connection;

/**
 * date:  2020-06-29 15:09
 *
 * @author zhengyao
 */
@Aspect
public class ConnectionAspect {
    @Around("execution(* javax.sql.DataSource.getConnection(..))")
    public Connection around(ProceedingJoinPoint proceedingJoinPoint){
        try {
            return new PcConnection((Connection) proceedingJoinPoint.proceed(), TransactionMangage.getCurrentTransaction());
        } catch (Throwable throwable) {
            throwable.printStackTrace();
        }
        return  null;
    }
}
