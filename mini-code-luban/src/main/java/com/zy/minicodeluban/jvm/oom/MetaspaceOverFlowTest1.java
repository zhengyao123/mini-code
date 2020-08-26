package com.zy.minicodeluban.jvm.oom;

import net.sf.cglib.proxy.Enhancer;
import net.sf.cglib.proxy.MethodInterceptor;
import net.sf.cglib.proxy.MethodProxy;

import java.lang.reflect.Method;

public class MetaspaceOverFlowTest1 {

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

            enhancer.setSuperclass(MetaspaceOverFlowTest1.class);
            enhancer.setUseCache(false);
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
