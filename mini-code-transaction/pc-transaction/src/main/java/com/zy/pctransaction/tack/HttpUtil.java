package com.zy.pctransaction.tack;

import com.zy.pctransaction.transaction.TransactionMangage;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.stereotype.Component;
import org.springframework.util.MultiValueMap;
import org.springframework.web.client.RestTemplate;

/**
 * date:  2020-06-29 15:26
 *
 * @author zhengyao
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
