package com.globant.bootcamp.LoginServiceRoot.GET;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ObjectNode;
import com.globant.bootcamp.LoginServiceRoot.data.LoginServiceDAO;
import com.globant.bootcamp.LoginServiceRoot.data.LoginServiceMultipleDAO;
import org.assertj.core.api.BDDAssertions;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.cloud.contract.stubrunner.spring.AutoConfigureStubRunner;
import org.springframework.cloud.contract.stubrunner.spring.StubRunnerPort;
import org.springframework.cloud.contract.stubrunner.spring.StubRunnerProperties;
import org.springframework.http.*;
import org.springframework.http.client.ClientHttpRequestInterceptor;
import org.springframework.http.client.HttpComponentsClientHttpRequestFactory;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import static com.globant.bootcamp.LoginServiceRoot.util.auxFunctions.createRequestBurnedUserHeader;
import static com.globant.bootcamp.LoginServiceRoot.util.auxFunctions.createRequestEmptyUser;


@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment= SpringBootTest.WebEnvironment.MOCK)
@AutoConfigureStubRunner(stubsMode = StubRunnerProperties.StubsMode.LOCAL, ids = {"com.globant.bootcamp:LoginService:0.0.1-SNAPSHOT:stubs"})
@DirtiesContext
public class get_all_users_Simple_test {

    @StubRunnerPort("LoginService")
    private int port;

    @Test
    public void get_all_users() {
        // given:


        RestTemplate restTemplate = new RestTemplate(new HttpComponentsClientHttpRequestFactory());
        HttpHeaders headers = new HttpHeaders();
        headers.set("rol", "admin");
        headers.set("name", "Andres");
        headers.set("password","1234");
        headers.set("email", "an@un.edu.co");
        headers.setContentType(MediaType.APPLICATION_JSON);
        headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
        HttpEntity<LoginServiceMultipleDAO> request = new HttpEntity<LoginServiceMultipleDAO>(null,headers);

        ResponseEntity<LoginServiceMultipleDAO> entity = restTemplate.exchange("http://localhost:"+port+"/authenticate/allUsers", HttpMethod.GET, request, LoginServiceMultipleDAO.class);

        BDDAssertions.then(entity.getStatusCodeValue()).isIn(202);
        BDDAssertions.then(entity.getBody().getMessage()).isEqualTo("Users Found");
        BDDAssertions.then(entity.getBody().getLastResult()).isEqualTo("Users found Succesfully");
        BDDAssertions.then(entity.getBody().getUserAccount());
        BDDAssertions.then(entity.getBody().getUserAccount().keySet().contains("Andres"));
        BDDAssertions.then(entity.getBody().getUserAccount().values().contains("1234"));
        BDDAssertions.then(entity.getBody().getUserAccount().values().contains("an@un.edu.co"));
        BDDAssertions.then(entity.getBody().getUserAccount().keySet().contains("Natalia"));
        BDDAssertions.then(entity.getBody().getUserAccount().values().contains("SailorMoon"));
        BDDAssertions.then(entity.getBody().getUserAccount().values().contains("Sailor76@exu.com"));


        //BDDAssertions.then(entity.getBody().getUserAccount().getPassword()).contains("SailorMoon");
        //BDDAssertions.then(entity.getBody().getUserAccount().getEmail()).contains("Sailor76@exu.com");

    }
}
