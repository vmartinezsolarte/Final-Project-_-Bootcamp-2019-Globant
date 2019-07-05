package com.globant.bootcamp.LoginService.repository;


import java.util.List;
import java.util.Optional;
import com.globant.bootcamp.LoginService.domain.Customer;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;


public interface CustomerRepository extends MongoRepository<Customer,String>, CustomerRepositoryCustom{
    Customer findByLastname(String lastname);
    Customer findByUsername(String username);
    Customer findByFirstname(String firstname);
    Customer findByEmail(String email);

}
