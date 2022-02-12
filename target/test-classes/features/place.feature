@APIs @PLACE
Feature: Validate Place APIs response verification
  AS A USER I WANT TO ADD A PLACE
  THEN UPDATE THE ADDRESS OF THE PLACE
  AND CHECK IF THE ADDRESS IS UPDATED

  Scenario: Verify if place is successfully added using Add Place API request
    Given I provide the Place details
    When I post the "AddPlace" Response
    Then I get a API response with a status code 200
    And the "status" in response body is "OK"


