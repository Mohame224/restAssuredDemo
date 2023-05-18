package tests;

import java.io.IOException;

import org.testng.Assert;
import org.testng.ITestContext;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.github.javafaker.Faker;

import helpers.PersonServiceHelper;
import io.restassured.response.Response;
import model.Person;

public class PatchPerson {

	public PersonServiceHelper presonservicehelper;

	@BeforeClass
	public void init() throws IOException {

		presonservicehelper = new PersonServiceHelper();
	}

	@Test
	public void updatePersonTest(ITestContext con) {
		Person person = new Person();
		Faker faker = new Faker();
		person.setFname(faker.name().firstName());
		person.setAge(faker.number().randomDigit());
		person.setLname(faker.name().lastName());
		person.setAddress(faker.address().fullAddress());
		int id = (Integer) con.getAttribute("userId");
		Response response = presonservicehelper.updatePerson(id, person);

		Assert.assertTrue(response.statusCode() == 200);

	}
}
