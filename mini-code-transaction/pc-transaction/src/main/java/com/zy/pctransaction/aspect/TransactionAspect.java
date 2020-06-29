package com.zy.pctransaction.aspect;

import com.zy.pctransaction.annotation.PcTransaction;
import com.zy.pctransaction.transaction.Transaction;
import com.zy.pctransaction.transaction.TransactionMangage;
import com.zy.pctransaction.transaction.TransactionType;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.core.annotation.Order;
import org.aspectj.lang.annotation.Aspect;

/**
 * date:  2020-06-29 14:28
 *
 * @author zhengyao
 */
//order的值越小，优先级越高
//order如果不标注数字，默认最低优先级，因为其默认值是int最大值

@Aspect
@Order(1000)
public class TransactionAspect {

    @Around("@annotation(com.zy.pctransaction.annotation.PcTransaction)")
    public void incoke(ProceedingJoinPoint proceedingJoinPoint) {
        MethodSignature signature = (MethodSignature) proceedingJoinPoint.getSignature();
        PcTransaction annotation = signature.getMethod().getAnnotation(PcTransaction.class);

        String group = "";
        if (annotation.isStart()) {
            //创建事务组
            group = TransactionMangage.createGroup();
        } else {
            //拿到当前事务组的ID
            //null
            group = TransactionMangage.getCurrent();
        }
        //创建事物对象
        Transaction transaction = TransactionMangage.createTransaction(group);

        //执行本地逻辑
        try {
            //Spring 会帮我们执行mysql的事物  一直等待
            proceedingJoinPoint.proceed();
            //提交本地事物状态  ---commit
            TransactionMangage.commitTransaction(transaction, annotation.isEnd(), TransactionType.COMMIT);
        }catch (Exception e) {
            TransactionMangage.commitTransaction(transaction, annotation.isEnd(), TransactionType.ROLLBACK);
            e.printStackTrace();
        } catch (Throwable throwable) {
            // 回滚
            TransactionMangage.commitTransaction(transaction, annotation.isEnd(), TransactionType.ROLLBACK);
            throwable.printStackTrace();
        }
    }
}
