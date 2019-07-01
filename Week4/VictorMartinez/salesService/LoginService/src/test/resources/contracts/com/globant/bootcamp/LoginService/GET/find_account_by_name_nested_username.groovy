package com.globant.bootcamp.LoginService.GET

import org.springframework.cloud.contract.spec.Contract


Contract.make {
    description "should return customer by name= Andres and password  = 1234"

    ///authenticate/{username}/{password}

    request {
        url "/authenticate/username/Andres/1234"
        method GET()
        headers{
            contentType applicationJson()
        }
    }

    response {
        status 202
        headers {
            contentType applicationJson()
        }
        body (
                message: "User Found",
                lastResult: "User found Succesfully",
                userAccount: ["username":"Andres",
                              "password":"1234",
                              "email":"an@un.edu.co"
                ]
        )
    }
}
