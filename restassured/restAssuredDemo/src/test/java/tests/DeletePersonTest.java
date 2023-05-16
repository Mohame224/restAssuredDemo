package tests;

import java.io.IOException;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import helpers.PersonServiceHelper;

public class DeletePersonTest {
	public PersonServiceHelper presonservicehelper;

	@BeforeClass
	public void init() throws IOException {

		presonservicehelper = new PersonServiceHelper();
	}

	@Test
	public void deletePersonTest() {
		presonservicehelper.deletePerson(4);
	}
	
	
}
