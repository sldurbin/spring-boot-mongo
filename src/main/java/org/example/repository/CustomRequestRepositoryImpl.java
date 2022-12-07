package org.example.repository;

import com.mongodb.client.result.UpdateResult;
import org.example.model.Request;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;
import org.springframework.stereotype.Repository;

@Repository
public class CustomRequestRepositoryImpl implements CustomRequestRepository {

    @Autowired
    private MongoTemplate mongoTemplate;

    @Override
    public void updateRequestPriority(String id, int newPriority) {
        Query query = new Query(Criteria.where("id").is(id));
        Update update = new Update();
        update.set("priority", newPriority);

        UpdateResult result = mongoTemplate.updateFirst(query, update, Request.class);

        if(result == null)
            System.out.println("No documents updated");
        else
            System.out.println(result.getModifiedCount() + " document(s) updated..");
    }
}
