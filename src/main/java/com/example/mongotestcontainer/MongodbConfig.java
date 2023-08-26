package com.example.mongotestcontainer;

import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClientFactory;
import com.mongodb.client.MongoClients;
import com.mongodb.client.MongoDatabase;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class MongodbConfig {


    @Bean
    public MongoClient mongoClient(@Qualifier("mongodbUri") String uri) {
        return MongoClients.create(uri);
    }

}
