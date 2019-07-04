package com.globant.bootcamp.LoginService.repository;


import java.util.List;
import java.util.Optional;
import com.globant.bootcamp.LoginService.domain.Customer;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CustomerRepository extends MongoRepository<Customer,String>, CustomerRepositoryCustom{
    public Customer findByLastname(String lastname);
    public Customer findByUsername(String username);
    public Customer findByFirstname(String firstname);
    public Customer findByEmail(String email);

}
