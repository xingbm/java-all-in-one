package org.share.jee.web.configuration;

import org.springframework.boot.web.client.RestTemplateCustomizer;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.client.OkHttp3ClientHttpRequestFactory;
import org.springframework.web.client.RestTemplate;

/**
 * Created by xingbm on 2021/2/15 15:23
 */
@Configuration
public class RestTemplateConfiguration implements RestTemplateCustomizer {

    @Override
    public void customize(RestTemplate restTemplate) {
        OkHttp3ClientHttpRequestFactory okHttp = (OkHttp3ClientHttpRequestFactory) restTemplate.getRequestFactory();
        okHttp.setConnectTimeout(60000);
        okHttp.setReadTimeout(30000);
        okHttp.setWriteTimeout(30000);
    }

}
