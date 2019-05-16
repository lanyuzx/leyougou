package com.leyougou;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import tk.mybatis.spring.annotation.MapperScan;

@SpringBootApplication
@EnableDiscoveryClient
@MapperScan("com.leyougou.item.mapper")
public class LLItemApplication {
    public static void main(String[] args) {
        SpringApplication.run(LLItemApplication.class, args);
    }

}
