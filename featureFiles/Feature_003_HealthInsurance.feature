Feature: Health Insurance
	Scenario: Retrieve all Health Insurance Menu Items 
    Given The user click on Insurance products menu
  #  When The user click on Insurance products menu
    When Navigate the health insurance page
    Then verify the health insurance page is displayed 
    And Hover the health insurance menu
    And Retrieve all the sub menus as list and print them
    

  