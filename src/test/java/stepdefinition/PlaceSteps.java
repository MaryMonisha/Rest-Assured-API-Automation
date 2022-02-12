package stepdefinition;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;
import utils.BaseURI;
import static org.junit.Assert.*;

import java.io.FileNotFoundException;

import static io.restassured.RestAssured.*;
import body.PlaceApi;

public class PlaceSteps extends BaseURI{
    //GLOBAL VARIABLE
    RequestSpecification Request;
    ResponseSpecification commonresponse;
    Response response;
    

    @Given("^I provide the Place details$")
    public void AddPlacePayload() throws FileNotFoundException
    {
        
        //GIVEN- Given I provide the Place details
        PlaceApi addplacebody=new PlaceApi();
        System.out.println("before  request");
        Request=given().spec(RequestSpecification())
                .body(addplacebody.AddPlaceBody());
         System.out.println("after  request");
         
         
    }
    @When("^I post the \"([^\"]*)\" Response$")
    public void PostResponse(String AddPlace)
    {	
    System.out.println("before response");
   commonresponse=new ResponseSpecBuilder().expectStatusCode(200).expectContentType(ContentType.JSON).build();
    response =Request.when().post("maps/api/place/add/json")
                .then().spec(commonresponse).extract().response();
        System.out.println("after  response");
        System.out.println("added to git");

    }
    @Then("^I get a API response with a status code (\\d+)$")
    public void ResponseStatusCode (Integer arg0)
    {
        assertEquals(response.getStatusCode(),200);
    }
    @And("^the \"([^\"]*)\" in response body is \"([^\"]*)\"$")
    public void ResponseStatus(String key,String Expectedvalue)
    {
     String StrResponse=response.asString();
     System.out.println(StrResponse);
     JsonPath js=new JsonPath(StrResponse);
     assertEquals(js.get(key),Expectedvalue);
    }



}


