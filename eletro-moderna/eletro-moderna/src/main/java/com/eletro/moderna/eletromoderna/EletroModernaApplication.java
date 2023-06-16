package com.eletro.moderna.eletromoderna;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@EnableFeignClients
@SpringBootApplication
public class EletroModernaApplication {

    public static void main(String[] args) {
        SpringApplication.run(EletroModernaApplication.class, args);
    }

}
