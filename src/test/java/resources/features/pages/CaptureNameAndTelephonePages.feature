Feature: Verify name and phone capturing pages functionality

  @name
  Scenario Outline: Verify name and phone capturing pages

    Given Appium server and simulator with application started
    And I verify landing page is loaded
    When I log in to product carousel page
    And I verify product carousel page is loaded
    Then I am openning bank account
    And I verify application flow page is loaded
    When I'm processing to terms and conditions page
    Then I verify terms and conditions page is loaded
    When I confirm all terms and conditions are met
    Then I verify eligibility page is loaded
    When I select all eligibility criteria on eligibility page
    Then I confirm I am eligible and progress to name capture page
    And I verify name capture page is loaded

    When I enter <nameValue> value in name capture screen
    And I am processing to phone capture page
    And I verify phone capture page is loaded

    And I enter <invalidPhoneValue> phone value in phone capture screen
    Then I verify status of Confirm button is disabled

    And I enter <validPhoneValue> phone value in phone capture screen
    Then I verify status of Confirm button is enabled

    Examples:
      | nameValue | validPhoneValue | invalidPhoneValue |
      | Test name | 1122223333      | 11222233335       |
