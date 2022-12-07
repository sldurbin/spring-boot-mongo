package org.example.controller;

import org.example.model.Item;
import org.example.model.Request;
import org.example.repository.RequestRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;

@RestController
public class SpringBootMongoController {

    @Autowired
    RequestRepository requestRepository;

    @GetMapping("/createRequest")
    public void createRequest() {

        requestRepository.save(
                Request.builder()
                        .requester("savannah")
                        .createDate(DateTimeFormatter.ISO_DATE.format(LocalDate.now()))
                        .priority(2)
                        .item(Item.builder().name("item1").build())
                        .build()
        );
    }

    @GetMapping("/getRequests")
    public List<Request> getRequests() {

        return requestRepository.findAll();
    }

}
