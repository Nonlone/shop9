/*
 * This Java source file was generated by the Gradle 'init' task.
 */
package com.shop9.app;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("com.shop9.app")
public class Application {
    public static void main(String[] args) {
        SpringApplication.run(Application.class,args);
    }
}
