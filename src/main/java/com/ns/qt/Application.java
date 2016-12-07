package com.ns.qt;

/**
 * Created by Sergey_Samarkin on 12/6/2016.
 */


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@RestController
public class Application {

    @RequestMapping("/")
    public String home() {
        return "WELCOME";
    }

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }

}

/*
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@ComponentScan
@EnableJpaRepositories(basePackages = {"com.ns.qt"})
public class Application {
    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }
}*/
