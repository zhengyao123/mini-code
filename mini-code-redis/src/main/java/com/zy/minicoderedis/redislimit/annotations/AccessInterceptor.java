package com.zy.minicoderedis.redislimit.annotations;

import com.alibaba.fastjson.JSON;
import com.zy.minicoderedis.common.AccessKey;
import com.zy.minicoderedis.common.RedisService;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.OutputStream;

/**
 * date:  2020-07-02 15:13
 *
 * @author zhengyao
 *
 * 基于拦截器的实现，后面实现基于aop 的锁
 */
public class AccessInterceptor extends HandlerInterceptorAdapter {

    @Autowired
    RedisService redisService;

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {

        //获取方法上的注解
        HandlerMethod hm = (HandlerMethod) handler;
        AccessLimit accessLimit = hm.getMethodAnnotation(AccessLimit.class);

        //获取配置参数
        int seconds = accessLimit.seconds();
        int maxCount = accessLimit.maxCount();
        boolean needLogin = accessLimit.needLogin();

        String key = request.getRequestURI();

        //判断用户是否登录
        //todo cookie / token 两种实现
        //getUser(request, response);

        AccessKey ak = AccessKey.withExpire(seconds);
        Integer count = redisService.get(ak, key, Integer.class);

        if (count == null) {
            redisService.set(ak, key, 1);
        } else if (count < maxCount) {
            redisService.incr(ak, key);
        } else {
            render(response, "休息下吧老哥");
            System.out.println("休息下吧老哥");
            return false;
        }

        return super.preHandle(request, response, handler);
    }

    private void render(HttpServletResponse response, String cm) throws Exception {
        response.setContentType("application/json;charset=UTF-8");
        OutputStream out = response.getOutputStream();
        String str = JSON.toJSONString(cm);
        out.write(str.getBytes("UTF-8"));
        out.flush();
        out.close();

    }
}
