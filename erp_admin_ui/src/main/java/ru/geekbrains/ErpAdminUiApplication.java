package ru.geekbrains;

import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Controller;

import javax.sql.DataSource;
import java.sql.SQLException;

@SpringBootApplication
@EnableAutoConfiguration
@ComponentScan("ru.geekbrains")
public class ErpAdminUiApplication {

    public static void main(String[] args) {
        SpringApplication.run(ErpAdminUiApplication.class, args);
    }

}
