package org.example.resolver;

import com.coxautodev.graphql.tools.GraphQLQueryResolver;
import org.example.model.Request;
import org.example.repository.RequestRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class Query implements GraphQLQueryResolver {
    private RequestRepository requestRepository;

    @Autowired
    public Query(RequestRepository requestRepository) {
        this.requestRepository = requestRepository;
    }

    public Iterable<Request> findAllRequests() {
        return requestRepository.findAll();
    }

    public long countRequests() {
        return requestRepository.count();
    }

}
