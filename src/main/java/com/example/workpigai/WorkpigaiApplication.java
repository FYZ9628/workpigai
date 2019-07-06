package com.example.workpigai;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@SpringBootApplication
@EnableSwagger2
@ComponentScan(basePackages = {"com.example.workpigai.controller","com.example.workpigai.service"})
public class WorkpigaiApplication {

    public static void main(String[] args) {
        SpringApplication.run(WorkpigaiApplication.class, args);
    }

}
