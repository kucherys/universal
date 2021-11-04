Feature: Verify product carousel page functionality

  @ios
  Scenario: Verify elements on product carousel page
    Given Appium server and simulator with application started
    And I verify landing page is loaded
    When I log in to product carousel page
    Then I verify elements on product carousel page