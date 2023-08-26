package com.example.mongotestcontainer;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.test.context.TestConfiguration;

@TestConfiguration(proxyBeanMethods = false)
public class TestMongoTestcontainerApplication {

    public static void main(String[] args) {
        SpringApplication.from(MongoTestcontainerApplication::main).with(TestMongoTestcontainerApplication.class).run(args);
    }

}
