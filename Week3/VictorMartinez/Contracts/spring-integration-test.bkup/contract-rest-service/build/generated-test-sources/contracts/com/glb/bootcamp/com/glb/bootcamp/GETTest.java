package com.glb.bootcamp.com.glb.bootcamp;

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

public class GETTest extends BaseClass {

	@Test
	public void validate_find_customer_by_id() throws Exception {
		// given:
			MockMvcRequestSpecification request = given();

		// when:
			ResponseOptions response = given().spec(request)
					.get("/customer/1");

		// then:
			assertThat(response.statusCode()).isEqualTo(200);
			assertThat(response.header("Content-Type")).matches("application/json.*");
		// and:
			DocumentContext parsedJson = JsonPath.parse(response.getBody().asString());
			assertThatJson(parsedJson).field("['name']").isEqualTo("Mike");
			assertThatJson(parsedJson).field("['surname']").isEqualTo("Castro");
			assertThatJson(parsedJson).field("['id']").isEqualTo(1);
	}

	@Test
	public void validate_find_customer_by_id_secondary() throws Exception {
		// given:
			MockMvcRequestSpecification request = given();

		// when:
			ResponseOptions response = given().spec(request)
					.get("/customer/2");

		// then:
			assertThat(response.statusCode()).isEqualTo(200);
			assertThat(response.header("Content-Type")).matches("application/json.*");
		// and:
			DocumentContext parsedJson = JsonPath.parse(response.getBody().asString());
			assertThatJson(parsedJson).field("['surname']").isEqualTo("Perez");
			assertThatJson(parsedJson).field("['name']").isEqualTo("Mauro");
			assertThatJson(parsedJson).field("['id']").isEqualTo(2);
	}

	@Test
	public void validate_find_customer_by_id_terciary() throws Exception {
		// given:
			MockMvcRequestSpecification request = given();

		// when:
			ResponseOptions response = given().spec(request)
					.get("/customer/3");

		// then:
			assertThat(response.statusCode()).isEqualTo(200);
			assertThat(response.header("Content-Type")).matches("application/json.*");
		// and:
			DocumentContext parsedJson = JsonPath.parse(response.getBody().asString());
			assertThatJson(parsedJson).field("['surname']").isEqualTo("Pelaez");
			assertThatJson(parsedJson).field("['name']").isEqualTo("Daniel");
			assertThatJson(parsedJson).field("['id']").isEqualTo(3);
	}

}
