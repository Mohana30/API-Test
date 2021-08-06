package com.anyapiassignment.cucumber.stepdefinition;

import com.anyapiassignment.cucumber.serenity.getGoogleBooksSerenitySteps;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.response.Response;

import static org.hamcrest.CoreMatchers.*;

import org.junit.runner.RunWith;

import com.anyapiassignment.utils.ReuseableSpecifications;

import net.serenitybdd.junit.runners.SerenityRunner;
import net.thucydides.core.annotations.Steps;

import org.junit.Assert;

public class googleBooksSteps {

	@Steps
	getGoogleBooksSerenitySteps steps;

	@When("User request google books shelf lists with {int} response")
	public void user_request_google_books_shelf_lists(Integer expStatusCode) {
	    steps.getBookShelfList().statusCode(expStatusCode).spec(ReuseableSpecifications.getGenericResponseSpec()).log().all();	    		
	}
	
	@Then("Validate the book shelf {int} and title {string}")
	public void validate_the_book_shelf_and_title(Integer bookshelf_id, String bookshelf_title) {
		steps.getBookShelfList().body("items.title", hasItem(bookshelf_title))
		.body("items.id", hasItem(bookshelf_id));
	}
	
	@Then("User request the {int} volumes and validate {string} with {int} response")
	public void user_request_the_volumes_and_validate(Integer bookshelf_id, String volume_title, Integer expStatusCode) {
	    steps.getBookShelfVolumes(bookshelf_id).statusCode(expStatusCode).body("items.volumeInfo.title", hasItem(volume_title));
	}
	
	@Then("Validate the invalid book shelf {int} with {int} response and {string} error message")
	public void validate_the_invalid_book_shelf_and_error_message(Integer bookshelf_id, Integer expStatusCode, String error_res_message) {
		steps.getBookShelfVolumes(bookshelf_id).statusCode(expStatusCode).body("error.message",equalTo(error_res_message));
	}
}
