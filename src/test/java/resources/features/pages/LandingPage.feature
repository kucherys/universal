Feature: Verify landing page functionality

  @land
  Scenario: Verify elements on landing page
    Given Appium server and simulator with application started
    When I verify landing page is loaded
    Then I verify elements on landing page
      | logInButton | logoLabel  | signUpButton        |
      | Log in      | Welcome to | I'm new to Digibank |

