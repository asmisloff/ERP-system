package ru.geekbrains.erpsystem;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.PropertySource;


@SpringBootApplication
@EnableAutoConfiguration
@ComponentScan("ru.geekbrains.erpsystem")
@EntityScan("ru.geekbrains.erpsystem.entities")
@PropertySource("classpath:credentials.properties")
public class ErpAdminUiApplication {

    public static void main(String[] args) {
        SpringApplication.run(ErpAdminUiApplication.class, args);
    }

}
