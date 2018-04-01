package org.ubsfree.bookingapp;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.liquibase.LiquibaseAutoConfiguration;

@SpringBootApplication(exclude = LiquibaseAutoConfiguration.class)
public class BookingAppStarter {

    public static void main(String[] args) {
        SpringApplication.run(BookingAppStarter.class, args);
    }
}
