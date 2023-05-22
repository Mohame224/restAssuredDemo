package tests;

import java.io.IOException;

import org.testng.Assert;
import org.testng.ITestContext;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import constants.FakerData;
import constants.Loggers;
import helpers.PersonServiceHelper;
import io.restassured.response.Response;
import model.Person;

public class CreatePersonTest {

	Person person;
	public PersonServiceHelper presonservicehelper;
	
	@BeforeClass
	public void init() throws IOException {
		presonservicehelper = new PersonServiceHelper();
	}

	@Test
	public void create_person(ITestContext con) {
		Loggers.logger.info("create fake data");
		Person person = new Person();
		FakerData faker = new FakerData();
		person.setFname(faker.fname);
		person.setAge(faker.age);
		person.setLname(faker.lname);
		person.setAddress(faker.address);
		Loggers.logger.info("sending post request");
		Response reponse = presonservicehelper.createPerson(person);
		int id = reponse.jsonPath().get("id");
		Loggers.logger.info("check status code");
		Assert.assertTrue(reponse.statusCode() == 201);
		Loggers.logger.info("create global variable from id ");
		con.setAttribute("userId", id);

	}

}
