Feature: Verify name and phone capturing pages functionality


  @name
  Scenario: Verify name and phone capturing pages
    Given Appium server and simulator with application started
    And I verify landing page is loaded
    When I log in to product carousel page
    And I verify product carousel page is loaded
    Then I am openning bank account
    And I verify application flow page is loaded
    When I'm processing to terms and conditions page
    Then I verify terms and conditions page is loaded
    When I confirm all terms and conditions
    Then I verify eligibility page is loaded

    When I confirm all eligibility conditions
    And I verify name capture page is loaded
    When I enter "name" in name capture screen
    When I'm processing to phone capture page
    And I verify phone capture page is loaded
    And I enter "telephone number" in malasian phone capture screen


