package org.example.model;

import lombok.Builder;
import lombok.Value;
import lombok.extern.jackson.Jacksonized;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Jacksonized
@Builder
@Value
@Document("requests")
public class Request {

    @Id
    String id;

    String requester;
    String createDate;
    String productName;
    Integer priority;
    Item item;
}
