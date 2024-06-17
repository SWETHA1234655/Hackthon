Feature: Travel Insurance
	Scenario: Get the three lowest international  travel insurance plan with amount and insurance provider company
    Given Navigate to travel insurance page
    When Click on any european country as destination
    And Click on next to navigate date page
    And Select the date and click on Next
    And Select the number of travellers and enter the age and click on next
    And Verify your Medical History and click on next
    Then Verify the sort by dropdown is visible
    And Verify the premium low to high and click
    And Verify the insurance plans are visible
    And Display three lowest international  travel insurance plan
    
