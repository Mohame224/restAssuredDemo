package tests;

import static org.testng.Assert.assertNotNull;

import java.io.IOException;
import java.util.List;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import helpers.PersonServiceHelper;

public class E2E {
	public PersonServiceHelper presonservicehelper;

	public String id;

	@BeforeClass
	public void init() throws IOException {

		presonservicehelper = new PersonServiceHelper();
	}

	@Test(dataProvider="creationData")
	public void E2ETest(String fname,String lname, String address,int age) {
		List<model.Person> personlist = presonservicehelper.getAllPerson();
		assertNotNull(personlist);
		
		String id = presonservicehelper.createPerson(fname,lname,address,age).jsonPath().getString("id");
		int id2 = Integer.parseInt(id);
		presonservicehelper.updatePerson(id2,"salha","salha","huheau",234324);
		presonservicehelper.deletePerson(id2);
	}
	@DataProvider
	public Object[][] creationData(){
		return new Object[][] {
			{ "slah", "hamed", "why",6565 },
			{ "yosra", "samitra", "myplace",24 },
			{ "angelina", "jolie", "mydick",22 } }; 
	}
	
	@DataProvider
	public Object[][] patchData(){
		return new Object[][] {
			{ "hass", "ewrew", "fvsd",2322 }}; 
	}


}
