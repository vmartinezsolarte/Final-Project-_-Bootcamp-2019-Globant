package com.globant.bootcamp.spring.springcore.data;

import org.springframework.stereotype.Repository;

import com.globant.bootcamp.spring.springcore.domain.Account;

import javax.annotation.Resource;

@Repository
public class CustomAccountRepository implements AccountRepository {
    @Resource
    DataSource dataSource;

    public Account getAccount(String username) {
        return dataSource.retrieveAccountInformation(username);
    }
}