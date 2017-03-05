package com.teamtreehouse.giflib;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.annotation.ComponentScan;

/**
 * Created by kpfromer on 2/28/17.
 */
@EnableAutoConfiguration
@ComponentScan
public class AppConfig {
    public static void main(String[] args) {
        SpringApplication.run(AppConfig.class, args);
    }
}
