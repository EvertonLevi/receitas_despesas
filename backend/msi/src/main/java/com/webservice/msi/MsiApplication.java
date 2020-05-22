package com.webservice.msi;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@SpringBootApplication
public class MsiApplication {

    public static void main(final String[] args) {
        SpringApplication.run(MsiApplication.class, args);
        System.out.println(new BCryptPasswordEncoder().encode("123"));
    }

}
