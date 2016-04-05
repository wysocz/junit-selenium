@smokeTest
Feature: To test my cucumber test is running
  I want to run a sample feature file.

    Scenario: Booking invalid card
      Given I make a booking from "DUB" to "SXF" on 11/05/2016 for 2 adults and 1 child
      When I pay for booking with card details “5555 5555 5555 5557”, “10/18” and “265”
      Then I should get payment declined message