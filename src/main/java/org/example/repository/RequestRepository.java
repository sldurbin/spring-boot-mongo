package org.example.repository;

import org.example.model.Request;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

public interface RequestRepository extends MongoRepository<Request, String>, CustomRequestRepository {

    @Query("{requester:'?0'}")
    Request findItemByRequester(String requester);

//    @Query(fields="{'requester' : 1, 'createDate' : 1}")
//    List<Request> findAll();

    public long count();

}
