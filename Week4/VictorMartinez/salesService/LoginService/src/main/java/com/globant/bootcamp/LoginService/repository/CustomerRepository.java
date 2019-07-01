package com.globant.bootcamp.LoginService.repository;

import com.globant.bootcamp.LoginService.domain.Customer;
import org.springframework.data.repository.CrudRepository;

import java.util.List;
import java.util.Optional;


public interface CustomerRepository extends CrudRepository<Customer,Long> {

    List<Customer> findByLastName(String LastName);
    Optional<Customer> findById(Long aLong);
    Customer findByUsername(String username);

}
