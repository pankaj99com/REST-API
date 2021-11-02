package TestCase;
import org.json.simple.JSONObject;
import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.Method;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;


public class SimplePostTest {
 
 @Test
 void Registration()
 {
  
  //Specify base URI
  RestAssured.baseURI="https://reqres.in/api/users";
  
  //Request object
  RequestSpecification httpRequest=RestAssured.given();
  
   
  //Request paylaod sending along with post request
  JSONObject requestParams=new JSONObject();
  
  requestParams.put("name","Pank");
  requestParams.put("job","manager");
  
  httpRequest.header("Content-Type","application/json");
  
  httpRequest.body(requestParams.toJSONString()); // attach above data to the request
  
  //Response object
  Response response=httpRequest.request(Method.POST,"/register");
    
  
  //print response in console window
  
  String responseBody=response.getBody().asString();
  System.out.println("Response Body is:" +responseBody);
  
  //status code validation
  int statusCode=response.getStatusCode();
  System.out.println("Status code is: "+statusCode);
  Assert.assertEquals(statusCode, 201);
  
  //success code validation
  String successCode=response.getStatusLine();
  System.out.println(successCode);
Assert.assertEquals(successCode, "HTTP/1.1 201 Created");
  
 }
 

}