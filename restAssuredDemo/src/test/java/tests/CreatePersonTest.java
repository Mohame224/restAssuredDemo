package tests;

import java.io.IOException;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import helpers.PersonServiceHelper;

public class CreatePersonTest {
	public PersonServiceHelper  presonservicehelper;

	@BeforeClass
	public void init() throws IOException {
	presonservicehelper=new PersonServiceHelper();
	}
	
	@Test(dataProvider = "creationData")
	public void create_person(String fname,String lname, String address,int age) {
		
		
		presonservicehelper.createPerson(fname,lname,address,age);

	}
	@DataProvider
	public Object[][] creationData(){
		return new Object[][] {
			{ "slah", "hamed", "why",6565 },
			{ "yosra", "samitra", "myplace",24 },
			{ "angelina", "jolie", "mydick",22 } }; 
	}

}
