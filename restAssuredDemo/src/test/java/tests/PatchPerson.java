package tests;

import java.io.IOException;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import helpers.PersonServiceHelper;

public class PatchPerson {

	public PersonServiceHelper presonservicehelper;

	@BeforeClass
	public void init() throws IOException {

		presonservicehelper = new PersonServiceHelper();
	}
	@Test(dataProvider="patchData")
	public void updatePersonTest(String fname,String lname, String address,int age) {
		presonservicehelper.updatePerson(18,fname,lname,address,age);

	
	}
	
	@DataProvider
	public Object[][] patchData(){
		return new Object[][] {
			{ "hass", "ewrew", "fvsd",2322 }}; 
	}

}
