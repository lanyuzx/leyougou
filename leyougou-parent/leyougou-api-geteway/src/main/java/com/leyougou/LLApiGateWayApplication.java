package com.leyougou;

import org.springframework.boot.SpringApplication;
import org.springframework.cloud.client.SpringCloudApplication;
import org.springframework.cloud.netflix.zuul.EnableZuulProxy;

@EnableZuulProxy
@SpringCloudApplication
public class LLApiGateWayApplication {
    public static void main(String[] args) {
        SpringApplication.run(LLApiGateWayApplication.class, args);
    }
}

