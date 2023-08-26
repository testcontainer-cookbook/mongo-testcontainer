package com.example.mongotestcontainer;

import org.springframework.boot.test.context.TestConfiguration;
import org.springframework.context.annotation.Bean;

import static com.example.mongotestcontainer.MongoTest.mongoDBContainer;

@TestConfiguration
public class TestComponent {

    @Bean
    public String mongodbUri() {
        return mongoDBContainer.getConnectionString();
    }
}
