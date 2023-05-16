package tests;

import static org.testng.Assert.assertNotNull;

import java.io.IOException;
import java.util.List;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import helpers.PersonServiceHelper;

public class GetAllPersons {
	public PersonServiceHelper  presonservicehelper;
	
	@BeforeClass
	public void init() throws IOException {

		presonservicehelper=new PersonServiceHelper();
	}
	@Test
	public void testgetall() {
		List<model.Person> personlist=presonservicehelper.getAllPerson();
		assertNotNull(personlist);
	}
}
