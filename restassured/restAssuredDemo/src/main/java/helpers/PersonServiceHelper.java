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

	public PersonServiceHelper() throws IOException {
		baseurl=ConfigManager.configManager().getProperty("baseurl");
		port=ConfigManager.configManager().getProperty("port");
		RestAssured.baseURI=baseurl;
		RestAssured.port=Integer.parseInt(port);
		RestAssured.useRelaxedHTTPSValidation();
	}
	
	public Response getAllPerson(){
		Response response=RestAssured
				.given()
				.contentType(ContentType.JSON)
				.get(EndPoint.GET_ALL_PERSONS)
				.andReturn();
		return response  ;
		
	}
	
	public Response createPerson(Person person) {
		Response response=RestAssured.given().contentType(ContentType.JSON).when()
				.body(person).post(EndPoint.CREATE_PERSON).andReturn();

		return response;
	}
	
	public Response updatePerson(int id,Person person) {		

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
