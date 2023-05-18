package tests;

import java.io.IOException;

import org.testng.Assert;
import org.testng.ITestContext;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import helpers.PersonServiceHelper;
import io.restassured.response.Response;

public class DeletePersonTest {
	public PersonServiceHelper presonservicehelper;

	@BeforeClass
	public void init() throws IOException {

		presonservicehelper = new PersonServiceHelper();
		
	}

	@Test
	public void deletePersonTest(ITestContext con) {
		System.out.println((Integer) con.getAttribute("userId"));
		Response response=presonservicehelper.deletePerson((Integer) con.getAttribute("userId"));
		Assert.assertTrue(response.statusCode()==200);
		
	}
	
	
}
