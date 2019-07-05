package com.globant.bootcamp.LoginService.repository;

import com.globant.bootcamp.LoginService.domain.Customer;

import com.mongodb.WriteResult;
import com.mongodb.client.result.UpdateResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

@Repository
public class CustomerRepositoryImpl implements CustomerRepositoryCustom {

    @Autowired
    MongoTemplate mongoTemplate;

    @Override
    public Customer updateLastname(String lastname, String newLastName) {

        Query query = new Query(Criteria.where("customer").is(lastname));
        Update update = new Update();
        update.set("lastname", newLastName);
        UpdateResult result = mongoTemplate.updateFirst(query, update, Customer.class);

        if(!result.wasAcknowledged())return null;

        Query getCustomer = new Query();
        query.addCriteria(Criteria.where("id").is(result.getModifiedCount()));
        return mongoTemplate.find(getCustomer, Customer.class).get(0);
    }
}
