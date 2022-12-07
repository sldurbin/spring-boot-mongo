package org.example.resolver;

import com.coxautodev.graphql.tools.GraphQLMutationResolver;
import org.example.model.Request;
import org.example.repository.RequestRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class Mutation implements GraphQLMutationResolver {
    private RequestRepository requestRepository;

    @Autowired
    public Mutation(RequestRepository requestRepository) {
        this.requestRepository = requestRepository;
    }

    public Request createRequest(String requester, String productName, Integer priority) {
        Request request = Request.builder()
                .requester(requester)
                .productName(productName)
                .priority(priority)
                .build();

        requestRepository.save(request);

        return request;
    }

    public boolean deleteRequest(String id) {
        requestRepository.deleteById(id);
        return true;
    }

//    public Request updateRequest(String id, String requester, Integer priority) throws Exception {
//        Optional<Request> optRequest = requestRepository.findById(id);
//
//        if (optRequest.isPresent()) {
//            Request request = optRequest.get();
//
//            if (requester != null)
//                request.setRequester(requester)
//            if (description != null)
//                tutorial.setDescription(description);
//
//            tutorialRepository.save(tutorial);
//            return tutorial;
//        }
//
//        throw new Exception("Not found Tutorial to update!");
//    }

}
