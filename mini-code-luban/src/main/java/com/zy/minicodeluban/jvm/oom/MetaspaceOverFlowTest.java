package com.zy.minicodeluban.jvm.oom;

import org.springframework.cglib.proxy.Enhancer;
import org.springframework.cglib.proxy.MethodInterceptor;
import org.springframework.cglib.proxy.MethodProxy;

import java.lang.reflect.Method;
/**
 * date:  2020-08-25 08:34
 *
 * @author zhengyao
 */
public class MetaspaceOverFlowTest {
    /**
     * 通过CGLIB模拟向元空间写入数据
     */
    public static void main(String[] args) {
        while (true) {
            try {
                Thread.sleep(10);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            Enhancer enhancer = new Enhancer();

            enhancer.setSuperclass(MetaspaceOverFlowTest.class);
           // enhancer.setUseCache(true);
            enhancer.setCallback(new MethodInterceptor() {
                public Object intercept(Object obj, Method method, Object[] args, MethodProxy proxy) throws Throwable {
                    return proxy.invokeSuper(obj, args);
                }
            });

            System.out.println("running...");

            enhancer.create();
        }
    }
}
