package com.example.springfeignservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@EnableFeignClients
@SpringBootApplication
public class SpringFeignServiceApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringFeignServiceApplication.class, args);
    }

}