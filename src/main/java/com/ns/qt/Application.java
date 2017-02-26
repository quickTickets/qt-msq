package com.ns.qt;

import org.flywaydb.core.Flyway;

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
    	Flyway f = new Flyway();
    	f.setDataSource("jdbc:postgresql://localhost:5432/qtdb", "root", "root", "");
    	f.repair();
        SpringApplication.run(Application.class, args);
    }

}