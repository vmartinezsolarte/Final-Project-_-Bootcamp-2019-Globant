package com.globant.bootcamp.LoginServiceRoot.GET;

import com.globant.bootcamp.LoginServiceRoot.data.LoginServiceDAO;
import org.assertj.core.api.BDDAssertions;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.cloud.contract.stubrunner.spring.AutoConfigureStubRunner;
import org.springframework.cloud.contract.stubrunner.spring.StubRunnerPort;
import org.springframework.cloud.contract.stubrunner.spring.StubRunnerProperties;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.web.client.RestTemplate;

import static com.globant.bootcamp.LoginServiceRoot.util.auxFunctions.createRequestEmptyUser;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment= SpringBootTest.WebEnvironment.RANDOM_PORT)
@AutoConfigureStubRunner(stubsMode = StubRunnerProperties.StubsMode.LOCAL, ids = {"com.globant.bootcamp:LoginService:0.0.1-SNAPSHOT:stubs"})
public class get_user_By_email_Simple_test {

    @StubRunnerPort("LoginService")
    private int port;

    @Test
    public void get_user_by_email_Simple_test_contract() {
        // given:
        HttpEntity<LoginServiceDAO> request = createRequestEmptyUser();

        RestTemplate restTemplate = new RestTemplate();
        ResponseEntity<LoginServiceDAO> entity = restTemplate.exchange("http://localhost:"+port+"/authenticate/email/Sailor76@exu.com/SailorMoon", HttpMethod.GET, request, LoginServiceDAO.class);

        BDDAssertions.then(entity.getStatusCodeValue()).isIn(202);
        BDDAssertions.then(entity.getBody().getMessage()).isEqualTo("User Found");
        BDDAssertions.then(entity.getBody().getLastResult()).isEqualTo("User found Succesfully");
        BDDAssertions.then(entity.getBody().getUserAccount().getUsername()).contains("Natalia");
        BDDAssertions.then(entity.getBody().getUserAccount().getPassword()).contains("SailorMoon");
        BDDAssertions.then(entity.getBody().getUserAccount().getEmail()).contains("Sailor76@exu.com");


    }

}
