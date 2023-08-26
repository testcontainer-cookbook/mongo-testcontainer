package com.example.mongotestcontainer;

import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.test.context.DynamicPropertyRegistry;
import org.springframework.test.context.DynamicPropertySource;
import org.testcontainers.containers.MongoDBContainer;
import org.testcontainers.junit.jupiter.Testcontainers;
import org.testcontainers.utility.DockerImageName;

@Testcontainers
public class MongoTest {

    static final MongoDBContainer mongoDBContainer = new MongoDBContainer(DockerImageName.parse("mongo:6.0.9"));

    static {
        mongoDBContainer.start();
    }

    @DynamicPropertySource
    static void mongoDBProperties(DynamicPropertyRegistry registry) {
        registry.add("mongodbUri", mongoDBContainer::getConnectionString);
    }



    @Test
    void test() {
        System.out.println("mongodbUri: " + mongoDBContainer.getConnectionString());

    }



}
