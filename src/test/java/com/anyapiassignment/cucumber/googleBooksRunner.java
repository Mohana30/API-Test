package com.anyapiassignment.cucumber;

import org.junit.runner.RunWith;

import com.anyapiassignment.testbase.TestBase;

import io.cucumber.junit.CucumberOptions;
import net.serenitybdd.cucumber.CucumberWithSerenity;

@RunWith(CucumberWithSerenity.class)

@CucumberOptions(
        plugin = {"pretty"},
        features = "classpath:feature",
        glue = {"com.anyapiassignment.cucumber.stepdefinition"}
)
public class googleBooksRunner extends TestBase{
	
	
}
