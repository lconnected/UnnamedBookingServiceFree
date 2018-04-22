package org.ubsfree.bookingapp;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.liquibase.LiquibaseAutoConfiguration;
import org.springframework.boot.autoconfigure.security.SecurityAutoConfiguration;

@SpringBootApplication(exclude = {LiquibaseAutoConfiguration.class, SecurityAutoConfiguration.class})
public class BookingAppStarter {

    public static void main(String[] args) {
        SpringApplication.run(BookingAppStarter.class, args);
    }
}
