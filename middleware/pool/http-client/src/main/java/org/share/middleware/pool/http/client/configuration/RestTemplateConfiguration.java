package org.share.middleware.pool.http.client.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.client.HttpComponentsClientHttpRequestFactory;
import org.springframework.http.client.OkHttp3ClientHttpRequestFactory;
import org.springframework.http.client.SimpleClientHttpRequestFactory;
import org.springframework.web.client.RestTemplate;

/**
 * Created by xingbm on 2020/11/17 7:03
 */
@Configuration
public class RestTemplateConfiguration {

    @Bean
    public RestTemplate restTemplate(){
        RestTemplate restTemplate = new RestTemplate();
        return restTemplate;
    }

    @Bean("urlConnection")
    public RestTemplate urlConnectionRestTemplate(){
        RestTemplate restTemplate = new RestTemplate(new SimpleClientHttpRequestFactory());
        return restTemplate;
    }

    @Bean("httpClient")
    public RestTemplate httpClientRestTemplate(){
        RestTemplate restTemplate = new RestTemplate(new HttpComponentsClientHttpRequestFactory());
        return restTemplate;
    }

    @Bean("okHttp3")
    public RestTemplate okHttp3RestTemplate(){
        RestTemplate restTemplate = new RestTemplate(new OkHttp3ClientHttpRequestFactory());
        return restTemplate;
    }

}
