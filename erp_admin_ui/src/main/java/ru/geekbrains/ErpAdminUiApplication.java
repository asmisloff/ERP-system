package ru.geekbrains;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Controller;

@SpringBootApplication
@EnableAutoConfiguration
@ComponentScan("ru.geekbrains")
public class ErpAdminUiApplication {

    public static void main(String[] args) {
        SpringApplication.run(ErpAdminUiApplication.class, args);
    }

}
