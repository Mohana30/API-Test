package com.anyapiassignment.testbase;

import org.junit.BeforeClass;

import io.restassured.RestAssured;

public class TestBase {
	
	@BeforeClass
	public static void init() {
		RestAssured.baseURI="https://www.googleapis.com/books/v1/";
	}

}
