Feature: Calculator

    Scenario: client wants to add two numbers
        When the client calls /sum with values 1 and 2
        Then the client receives answer as 5