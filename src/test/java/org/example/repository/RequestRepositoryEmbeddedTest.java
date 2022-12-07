//package org.example.repository;
//
//import org.example.model.Request;
//import org.hamcrest.Matchers;
//import org.junit.jupiter.api.AfterEach;
//import org.junit.jupiter.api.Test;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.test.autoconfigure.data.mongo.DataMongoTest;
//
//import java.util.Optional;
//
//import static org.hamcrest.MatcherAssert.assertThat;
//import static org.junit.jupiter.api.Assertions.assertTrue;
//
//@DataMongoTest
//public class RequestRepositoryEmbeddedTest {
//
//    @Autowired
//    RequestRepository requestRepository;
//
//    @AfterEach
//    void cleanUp() {
//        this.requestRepository.deleteAll();
//    }
//
//    @Test
//    void testFindItemByRequester() {
//        requestRepository.save(Request.builder().requester("rando").build());
//
//        Request request = requestRepository.findItemByRequester("rando");
//
//        assertThat(request.getRequester(), Matchers.is("rando"));
//    }
//
//    @Test
//    void testUpdateRequestPriority() {
//        Request rando = requestRepository.save(Request.builder().requester("rando").priority(1).build());
//
//        requestRepository.updateRequestPriority(rando.getId(), 2);
//
//        Optional<Request> request = requestRepository.findById(rando.getId());
//
//        assertTrue(request.isPresent());
//        assertThat(request.get().getPriority(), Matchers.is(2));
//    }
//
//}
