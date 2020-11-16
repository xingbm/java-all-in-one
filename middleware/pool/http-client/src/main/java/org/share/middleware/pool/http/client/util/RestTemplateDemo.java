package org.share.middleware.pool.http.client.util;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

/**
 * Created by xingbm on 2020/11/17 7:16
 */
@Component
public class RestTemplateDemo {

    @Autowired
    private RestTemplate restTemplate;

    public void post(Object object) {
        // 定义HttpHeaders
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        // 定义body
        ObjectMapper objectMapper = new ObjectMapper();
        String value = "";
        try {
            value = objectMapper.writeValueAsString(object);
        } catch (JsonProcessingException e) {

        }
        // 组装HttpEntity
        HttpEntity<String> httpEntity = new HttpEntity<>(value, headers);
        // 调用RestTemplate，执行HTTP请求，并返回ResponseEntity
        ResponseEntity<String> responseEntity = restTemplate.postForEntity("", httpEntity, String.class);

    }

}
