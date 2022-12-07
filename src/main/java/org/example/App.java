package org.example;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

/**
 * Hello world!
 *
 */
@SpringBootApplication
@EnableMongoRepositories
public class App {

    public static void main( String[] args )
    {
        SpringApplication.run(App.class, args);
    }
}
