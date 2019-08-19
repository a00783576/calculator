package com.arturo.calculator.acceptance.controller;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import static org.junit.Assert.assertEquals;

import com.arturo.calculator.CalculatorApplicationTests;

public class StepDefinitions extends CalculatorApplicationTests {
    
    int response = 0;    
    private String server = System.getProperty("calculator.url"); 
 
    @When("the client calls \\/sum with values {int} and {int}")
    public void the_client_calls_arithmetic_add_with_values_and(int int1, int int2) {
        response = restTemplate.getForObject(server + "sum?a=" +
                int1 + "&b=" + int2, Integer.class);
    }
 
    @Then("the client receives answer as {int}")
    public void the_client_receives_answer_as(int result) {
        assertEquals(result, response);
    }
}