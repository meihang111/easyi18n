package dev.easyi18n;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

/**
 * @author meihang
 * @date 2023/5/29 9:50
 * @email 1769881764@qq.com
 * @project https://github.com/meihang111/easyi18n
 */
@SpringBootApplication
public class TeamServiceApplication {
    public static void main(String[] args) {
        SpringApplication.run(TeamServiceApplication.class,args);
    }

    /*
    * 用于发送http请求
    */
    @Bean
    @LoadBalanced
    public RestTemplate restTemplate(){
        return new RestTemplate();
    }
}