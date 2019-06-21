package org.springframework.cloud.contract.verifier.tests.com.glb.bootcamp;

import com.glb.bootcamp.BaseClass;
import com.jayway.jsonpath.DocumentContext;
import com.jayway.jsonpath.JsonPath;
import io.restassured.module.mockmvc.specification.MockMvcRequestSpecification;
import io.restassured.response.ResponseOptions;
import java.io.StringReader;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import org.junit.Test;
import org.w3c.dom.Document;
import org.xml.sax.InputSource;

import static com.toomuchcoding.jsonassert.JsonAssertion.assertThatJson;
import static io.restassured.module.mockmvc.RestAssuredMockMvc.*;
import static org.springframework.cloud.contract.verifier.assertion.SpringCloudContractAssertions.assertThat;
import static org.springframework.cloud.contract.verifier.util.ContractVerifierUtil.*;

public class POSTTest extends BaseClass {

	@Test
	public void validate_add_customer_by_id() throws Exception {
		// given:
			MockMvcRequestSpecification request = given()
					.header("Content-Type", "application/json")
					.body("{\"id\":4,\"name\":\"Felipe\",\"surname\":\"Martinez\"}");

		// when:
			ResponseOptions response = given().spec(request)
					.post("/customer/id");

		// then:
			assertThat(response.statusCode()).isEqualTo(200);
			assertThat(response.header("Content-Type")).matches("application/json.*");
		// and:
			DocumentContext parsedJson = JsonPath.parse(response.getBody().asString());
			assertThatJson(parsedJson).field("['name']").isEqualTo("Felipe");
			assertThatJson(parsedJson).field("['surname']").isEqualTo("Martinez");
			assertThatJson(parsedJson).field("['id']").isEqualTo(4);
	}

}
