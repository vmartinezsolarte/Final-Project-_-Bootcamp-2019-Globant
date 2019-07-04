package com.globant.bootcamp.LoginService.GET

import org.springframework.cloud.contract.spec.Contract


Contract.make {
    description "should return customer by name= Andres and password  = 1234"

    //"Natalia","", ""
    //"/authenticate/email/{userEmail}/{password}"
    request {
        url "/authenticate/email/Sailor76@exu.com/SailorMoon"
        method GET()
        headers{
            contentType( applicationJson())
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
                userAccount: ["username":"Natalia",
                              "password":"SailorMoon",
                              "email":"Sailor76@exu.com"
                ]
        )
    }
}


