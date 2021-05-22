package ru.geekbrains.erpsystem;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import ru.geekbrains.erpsystem.entities.Role;
import ru.geekbrains.erpsystem.entities.User;
import ru.geekbrains.erpsystem.repositories.RoleRepository;

import javax.annotation.PostConstruct;

@SpringBootApplication
@EnableAutoConfiguration
@ComponentScan("ru.geekbrains.erpsystem")
@EntityScan("ru.geekbrains.erpsystem.entities")
public class ErpAdminUiApplication {

    public static void main(String[] args) {
        SpringApplication.run(ErpAdminUiApplication.class, args);
    }

}
