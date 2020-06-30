package com.luban.tack;

import com.luban.transaction.TransactionMangage;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.stereotype.Component;
import org.springframework.util.MultiValueMap;
import org.springframework.web.client.RestTemplate;

/**
 * 需要咨询java高级VIP课程的同学可以加安其拉老师的QQ：3164703201
 * 需要视频资料的可以添加白浅老师的QQ：2207192173
 * author：鲁班学院-商鞅老师
 */
@Component
public class HttpUtil {

    private static RestTemplate restTemplate = new RestTemplate();


    public  static Object post(String url){
        HttpHeaders header = new HttpHeaders();
        header.set("groupId", TransactionMangage.getCurrent());
        HttpEntity<MultiValueMap<String, String>> httpEntity = new HttpEntity<>(null, header);
        return  restTemplate.postForObject(url,httpEntity,Object.class);

    }
}
