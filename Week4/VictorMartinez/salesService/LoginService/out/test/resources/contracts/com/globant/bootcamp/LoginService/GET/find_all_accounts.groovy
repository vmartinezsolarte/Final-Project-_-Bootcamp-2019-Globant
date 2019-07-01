package com.globant.bootcamp.LoginService.GET

import org.springframework.cloud.contract.spec.Contract


Contract.make {
    description "should return all accounts available"

    ///authenticate/{username}/{password}

    request {
        url "/authenticate/allUsers"
        method GET()
        headers {
            contentType(applicationJson())
            header 'rol': 'admin'
            header 'name': 'Andres'
            header 'password': '1234'
            header 'email': 'an@un.edu.co'

        }
    }

    response {
        status 202
        headers {
            contentType applicationJson()
        }
    }
}
