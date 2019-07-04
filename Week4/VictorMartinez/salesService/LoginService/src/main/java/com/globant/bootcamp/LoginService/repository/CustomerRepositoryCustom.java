package com.globant.bootcamp.LoginService.repository;

import com.globant.bootcamp.LoginService.domain.Customer;
import org.springframework.stereotype.Repository;


public interface CustomerRepositoryCustom {

    Customer updateLastname(String lastname, String newLastName);
}
