package com.globalhunt.apitest;

import java.util.List;
import java.util.Set;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.globalhunt.base.BaseSetUp;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.http.Method;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class DemoPetStore extends BaseSetUp {

	@Test
	public void testPetsByStatus() {
		RestAssured.baseURI = config.prop.getProperty("GetPetsByStatus").toString();
		RequestSpecification request = RestAssured.given();
		request.contentType(ContentType.JSON);
		Response response = request.queryParam("status", "available").get("/findByStatus");
		List<String> jsonResponse = response.jsonPath().getList("status");
		for (int i = 0; i < jsonResponse.size(); i++) {
			Assert.assertEquals("available", jsonResponse.get(i));
		}
		Assert.assertEquals(200, response.getStatusCode());

	}

	@Test
	public void testPostNewPet() {
		RestAssured.baseURI = config.prop.getProperty("GetPetsByStatus").toString();
		RequestSpecification request = RestAssured.given();
		JSONObject requestPetObject = new JSONObject();
		requestPetObject.put("id", "0101");
		JSONObject category = new JSONObject();
		category.put("id", "001");
		category.put("name", "Huskie");
		requestPetObject.put("category", category);
		requestPetObject.put("name", "MyDogie");
		JSONArray photourls = new JSONArray();
		photourls.add("www.getphoto.com");
		requestPetObject.put("photoUrls", photourls);
		JSONArray tags = new JSONArray();
		JSONObject tagsData = new JSONObject();
		tagsData.put("id", "001");
		tagsData.put("name", "string");
		tags.add(tagsData);
		requestPetObject.put("tags", tags);
		requestPetObject.put("status", "available");
		request.header("Content-Type", "application/json");
		request.body(requestPetObject.toJSONString());
		Response response = request.post();
		String responseId = response.jsonPath().getString("id");
		String responseStatus = response.jsonPath().getString("status");
		Assert.assertEquals("available", responseStatus);
		Assert.assertEquals("101", responseId);
		Assert.assertEquals(200, response.getStatusCode());
	}

	@Test
	public void updatePet() {
		RestAssured.baseURI = config.prop.getProperty("GetPetsByStatus").toString();
		RequestSpecification request = RestAssured.given();
		String id = "101";
		JSONObject obj = new JSONObject();
		obj.put("status", "sold");
		request.header("Content-Type", "application/json");
		request.body(obj.toJSONString());
		Response response = request.put("/update/" + id);
		Assert.assertEquals(200, response.getStatusCode());
	}

	@Test
	public void deletePet() {
		String id = "101";
		RestAssured.baseURI = config.prop.getProperty("GetPetsByStatus").toString();
		RequestSpecification request = RestAssured.given();
		request.header("Content-Type", "application/json");
		Response response = request.delete("/delete/" + id);
		Assert.assertEquals(200, response.getStatusCode());

	}

}
