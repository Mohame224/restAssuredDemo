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

public class E2E {
	public PersonServiceHelper presonservicehelper;

	public String id;
	public Person personpatch;

	@BeforeClass
	public void init() throws IOException {

		presonservicehelper = new PersonServiceHelper();
	}

	@Test(priority = 1)
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

	@Test(priority = 2)
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

	@Test(priority = 3)
	public void deletePersonTest(ITestContext con) {
		System.out.println((Integer) con.getAttribute("userId"));
		Response response = presonservicehelper.deletePerson((Integer) con.getAttribute("userId"));
		Assert.assertTrue(response.statusCode() == 200);

	}

}
