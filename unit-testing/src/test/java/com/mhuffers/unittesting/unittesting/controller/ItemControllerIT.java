package com.mhuffers.unittesting.unittesting.controller;

import org.json.JSONException;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.skyscreamer.jsonassert.JSONAssert;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.test.context.junit4.SpringRunner;

/*
 * In the below test class name ItemControllerIT, IT stands for Integration test, because in this particular test, we 
 * are loading the entire context up and then also make a call to the 1 of the controller methods. Thus, the in-memory db is loaded,
 * with the data.sql and all the spring components are loaded, once that happens then the test cases begins to run.
 * 
 * @SpringBootTest does this job of loading the entire context. Even if this class would have been inside any of the sub-package then 
 * still it would start searching for all the packages till parent package to find the @SpringBootApplication. Once, it finds it,
 * it loads the entire context. The webEnvironment setting is used here to set the port on which this web application would run during
 * test phase. Since we have configured it to run on random port, it will first check the list of available ports then pick one randomly
 * 
 * It also creates an instance of TestRestTemplate, automatically configured for the randomly chosen port and ready to be used
 * 
 * Since currently we are using an in-memory db it is fine to test it like this but in a real world applications
 * we would not want to depend on the external data or any other external service. Let's say 
 * that our app is dependent on a file system for some data or any other interface of that sort.
 * 
 * Now while writing integration tests for such application, the best approach is to use the @MockBean annotation
 * and mock that layer. Also, we need to understand that this Integration test is only testing all the components of 
 * this app, and it does not eliminates the need of System Integration test performed by testing team. 
 * This integration test is part of our unit testing suite
 */

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT)
public class ItemControllerIT {

	@Autowired
	private TestRestTemplate restTemplate;
	
	@Test
	public void contextLoads() throws JSONException {
		String response = restTemplate.getForObject("/all-items", String.class);
		
		//setting strict to false to only allow the present entries in the expected response to be compared
		JSONAssert.assertEquals("[{\"id\": 1001},{id: 1002},{id: 1003},{id: 1004},{id: 1005}]", response, false);
		
	}

}
