package helpers;

import java.io.IOException;
import java.util.List;

import com.fasterxml.jackson.core.type.TypeReference;

import constants.EndPoint;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import model.Person;
import util.ConfigManager;

public class PersonServiceHelper {


	private    String baseurl= "";
	private   static String port="";

	public PersonServiceHelper() throws IOException {
		baseurl=ConfigManager.configManager().getProperty("baseurl");
		port=ConfigManager.configManager().getProperty("port");
		RestAssured.baseURI=baseurl;
		RestAssured.port=Integer.parseInt(port);
		RestAssured.useRelaxedHTTPSValidation();
	}
	
	public List<model.Person> getAllPerson(){
		Response response=RestAssured
				.given()
				.contentType(ContentType.JSON)
				.get(EndPoint.GET_ALL_PERSONS)
				.andReturn();
		
		java.lang.reflect.Type type=new TypeReference<List<Person>>() {}.getType();
		List<model.Person> personlist=response.as(type);
		return personlist;
		
	}
	
	public Response createPerson(String fname,String lname, String address,int age) {
		Person person=new Person();
		person.setFname(fname);
		person.setAge(age);
		person.setLname(lname);
		person.setAddress(address);
	
		
		Response response=RestAssured.given().contentType(ContentType.JSON).when()
				.body(person).post(EndPoint.CREATE_PERSON).andReturn();
		return response;
	}
	
	public Response updatePerson(int id,String fname,String lname, String address,int age) {		
		Person person=new Person();
		person.setFname(fname);
		person.setAge(age);
		person.setLname(lname);
		person.setAddress(address);
		Response response=RestAssured
				.given()
				.contentType(ContentType.JSON)
				.pathParam("id",id).when().body(person)
				.patch(EndPoint.UPDATE_PERSON)
				.andReturn();
		return response;
	}
	public Response deletePerson(int id) {


		Response response=RestAssured
				.given()
				.contentType(ContentType.JSON)
				.pathParam("id",id).when()
				.delete(EndPoint.DELETE_PERSON)
				.andReturn();
		return response;
	}
	

	
}
