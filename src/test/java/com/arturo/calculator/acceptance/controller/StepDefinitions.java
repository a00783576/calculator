package com.arturo.calculator.acceptance.controller;

import org.springframework.web.client.RestTemplate;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import static org.junit.Assert.assertEquals;

import com.arturo.calculator.CalculatorApplicationTests;

public class StepDefinitions extends CalculatorApplicationTests {

    // private String server = System.getProperty("calculator.url");    
    // private RestTemplate restTemplate = new RestTemplate();

    // private String a;
    // private String b;
    // private String result;

    // @Given("^I have tw numbers: (.*) and (.*)$")
    // public void i_have_two_numbers(String a, String b) throws Throwable {
    //     this.a = a;
    //     this.b = b;
    // }

    // @When("^the calculator sums them$")
    // public void the_calculator_sums_them() throws Throwable {
    //     String url = String.format("%s/sum?a=%s&b=%s", DEFAULT_URL, a, b);
    //     result = restTemplate.getForObject(url, String.class);
    // }

    // @Then("^I receive (.*) as a result$")
    // public void i_receive_as_a_result(String expectedResult) throws Throwable {
    //     assertEquals(expectedResult, result);
    // }
    
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