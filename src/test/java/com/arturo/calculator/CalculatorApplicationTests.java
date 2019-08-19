package com.arturo.calculator;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.web.client.RestTemplate;

@RunWith(SpringRunner.class)
@SpringBootTest
public class CalculatorApplicationTests {

	protected RestTemplate restTemplate = new RestTemplate();
 
    protected final String DEFAULT_URL = "http://localhost:8081";

    @Test
    public void initializationTest(){

    }

}
