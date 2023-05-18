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

public class CreatePersonTest {

	Person person;
	public PersonServiceHelper presonservicehelper;

	@BeforeClass
	public void init() throws IOException {
		presonservicehelper = new PersonServiceHelper();
	}

	@Test
	public void create_person(ITestContext con) {
		Person person = new Person();
		Faker faker = new Faker();
		person.setFname(faker.name().firstName());
		person.setAge(faker.number().randomDigit());
		person.setLname(faker.name().lastName());
		person.setAddress(faker.address().fullAddress());

		Response reponse = presonservicehelper.createPerson(person);
		int id = reponse.jsonPath().get("id");
		Assert.assertTrue(reponse.statusCode() == 201);
		con.setAttribute("userId", id);

	}

}
