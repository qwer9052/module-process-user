package com.module.process;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EnableJpaAuditing
@EntityScan(basePackages = {"com.module.domain"})
@EnableJpaRepositories(basePackages = {"com.module.domain.*.entityrepo"})
public class ModuleProcessUserApplication {

    public static void main(String[] args) {
        SpringApplication.run(ModuleProcessUserApplication.class, args);
    }

}
