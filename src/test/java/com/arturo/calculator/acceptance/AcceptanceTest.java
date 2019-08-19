package com.arturo.calculator.acceptance;

import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

/** Acceptance Test */
@RunWith(Cucumber.class)
@CucumberOptions(features = "src/test/resources", plugin = {"io.cucumber.pro.JsonReporter:default"})
public class AcceptanceTest {
    
}