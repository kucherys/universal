Feature: Verify landing page functionality

  @land
  Scenario Outline: Verify elements on landing page
    Given Appium server and simulator with application started
    When I verify landing page is loaded
    Then I verify elements <logInButton> and <logoLabel> and <signUpButton> on landing page

    Examples:
      | logInButton | logoLabel                | signUpButton               |
      | Log In      | Welcome to ARBM Digibank | I'm new to [ARBM Digibank] |

#    Then I verify word "Hello"
