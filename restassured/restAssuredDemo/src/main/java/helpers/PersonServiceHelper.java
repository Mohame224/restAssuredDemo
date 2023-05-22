package helpers;

import java.io.IOException;

import constants.EndPoint;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import model.Person;
import util.ConfigManager;

public class PersonServiceHelper {


	private    String baseurl= "";
	private    String port="";
//creating the main url and port  by using constructor
	public PersonServiceHelper() throws IOException {
		baseurl=ConfigManager.configManager().getProperty("baseurl");
		port=ConfigManager.configManager().getProperty("port");
		RestAssured.baseURI=baseurl;
		RestAssured.port=Integer.parseInt(port);
		RestAssured.useRelaxedHTTPSValidation();
	}
	//Method to get all persons from the json file
	public Response getAllPerson(){
		Response response=RestAssured
				.given()
				.contentType(ContentType.JSON)
				.get(EndPoint.GET_ALL_PERSONS)
				.andReturn();
		return response  ;
		
	}
	//Method to create a new person in the dummi api using the fake data generator
	public Response createPerson(Person person) {
		Response response=RestAssured.given().contentType(ContentType.JSON).when()
				.body(person).post(EndPoint.CREATE_PERSON).andReturn();

		return response;
	}
	//trying the patch request
	public Response updatePerson(int id,Person person) {		

		Response response=RestAssured
				.given()
				.contentType(ContentType.JSON)
				.pathParam("id",id).when().body(person)
				.patch(EndPoint.UPDATE_PERSON)
				.andReturn();
		return response;
	}
	
	//delete the person from the json file
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
