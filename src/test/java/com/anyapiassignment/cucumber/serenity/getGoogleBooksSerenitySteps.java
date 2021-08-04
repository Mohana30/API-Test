package com.anyapiassignment.cucumber.serenity;


import io.restassured.response.ValidatableResponse;
import net.serenitybdd.rest.SerenityRest;
import net.thucydides.core.annotations.Step;

public class getGoogleBooksSerenitySteps {

	@Step("Get all bookshelf list")
	public ValidatableResponse getBookShelfList() {
		return SerenityRest.given().when().get("users/101349823125559959898/bookshelves").then();
	}
	
	@Step("Get particular bookshelf volumes")
	public ValidatableResponse getBookShelfVolumes(Integer bookshelf_id) {
		return SerenityRest.given().when().get("users/101349823125559959898/bookshelves/"+bookshelf_id+"/volumes").then();
	}
}
