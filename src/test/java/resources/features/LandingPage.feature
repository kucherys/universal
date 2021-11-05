Feature: Verify landing page functionality

  @ios
  Scenario: Verify elements on landing page
    Given Appium server and simulator with application started
    When I verify landing page is loaded
    Then I verify elements on landing page
      | logInButton | logoLabel                | signUpButton               |
      | Log In      | Welcome to ARBM Digibank | I'm new to [ARBM Digibank] |

