package com.example.mongotestcontainer;

import com.mongodb.client.FindIterable;
import com.mongodb.client.MongoClient;
import org.bson.Document;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.Import;

@SpringBootTest
@Import(TestComponent.class)
public class UserTest extends MongoTest {

    @Autowired
    private MongoClient mongoClient;


    @BeforeEach
    void before() {
        Document document = new Document("name", "foo");
        document.put("age", 20);
        mongoClient.getDatabase("test").getCollection("test").insertOne(document);
    }


    @Test
    void test() {
        FindIterable<Document> documents = mongoClient.getDatabase("test").getCollection("test").find();
        documents.forEach(System.out::println);
    }

    @AfterEach
    void after() {
        Document document = new Document("name", "foo");
        mongoClient.getDatabase("test").getCollection("test").deleteOne(document);

        System.out.println("after delete");
        FindIterable<Document> documents = mongoClient.getDatabase("test").getCollection("test").find();
        documents.forEach(System.out::println);
    }


}
