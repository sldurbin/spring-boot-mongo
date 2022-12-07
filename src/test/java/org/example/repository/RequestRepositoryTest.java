package org.example.repository;

import org.example.model.Item;
import org.example.model.Request;
import org.hamcrest.Matchers;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.mongo.embedded.EmbeddedMongoAutoConfiguration;
import org.springframework.boot.test.autoconfigure.data.mongo.DataMongoTest;
import org.springframework.test.context.DynamicPropertyRegistry;
import org.springframework.test.context.DynamicPropertySource;
import org.testcontainers.containers.MongoDBContainer;
import org.testcontainers.junit.jupiter.Container;
import org.testcontainers.junit.jupiter.Testcontainers;

import java.util.Optional;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.notNullValue;
import static org.junit.jupiter.api.Assertions.assertTrue;

@Testcontainers
@DataMongoTest(excludeAutoConfiguration = EmbeddedMongoAutoConfiguration.class)
class RequestRepositoryTest {

    @Container
    static MongoDBContainer mongoDBContainer = new MongoDBContainer("mongo:4.4.2");

    @DynamicPropertySource
    static void setProperties(DynamicPropertyRegistry registry) {
        registry.add("spring.data.mongodb.uri", mongoDBContainer::getReplicaSetUrl);
    }

    @Autowired
    RequestRepository requestRepository;

    @AfterEach
    void cleanUp() {
        this.requestRepository.deleteAll();
    }

    @Test
    void testFindItemByRequester() {
        requestRepository.save(Request.builder().requester("rando").build());

        Request request = requestRepository.findItemByRequester("rando");

        assertThat(request.getRequester(), Matchers.is("rando"));
    }

    @Test
    void testUpdateRequestPriority() {
        Request rando = requestRepository.save(Request.builder().requester("rando").priority(1).build());

        requestRepository.updateRequestPriority(rando.getId(), 2);

        Optional<Request> request = requestRepository.findById(rando.getId());

        assertTrue(request.isPresent());
        assertThat(request.get().getPriority(), Matchers.is(2));
    }

    @Test
    void testItem() {
        Request rando = requestRepository.save(
                Request.builder()
                        .requester("rando")
                        .priority(1)
                        .item(Item.builder().name("itemName").build())
                        .build());

        Optional<Request> request = requestRepository.findById(rando.getId());

        assertTrue(request.isPresent());
        assertThat(request.get().getItem(), Matchers.is(notNullValue()));
        assertThat(request.get().getItem().getName(), Matchers.is("itemName"));
    }
}