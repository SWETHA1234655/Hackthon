Feature: Car Insurance
  Scenario: Capturing Error Message By Invalid Login Credentials
    Given Navigate to Car insurance page
    When Proceed without providing car number
    And Select city and RTO
    And Select car brand
    And Select car model
    And Select car variant
    Then Verify the user details page is displayed
    And Fill details with invalid phone number or e-mail
    And Print the error message displayed
   
