Feature: Verify landing page functionality

  @baseIOS
  Scenario: Verify basic test without checking UI iOS
    Given Appium server and simulator with application type iOS started
    When I confirm simple cucumber tests in status IN PROGRESS
    Then I confirm simple cucumber tests in status COMPLETED

  @landIOS
  Scenario: Verify elements on landing page for iOS
    Given Appium server and simulator with application type iOS started
    When I verify landing page is loaded
    Then I verify elements on landing page
      | logInButton | logoLabel  | signUpButton    |
      | Log in      | Welcome to | I'm new to Ryse |
    And I print login button name
    And I confirm tests completed with result IOS TEST PASSED

  @landAndroid
  Scenario: Verify elements on landing page for Android
    Given Appium server and simulator with application type Android started
    When I verify landing page is loaded
    Then I verify elements on landing page
      | logInButton | logoLabel  | signUpButton        |
      | Log In      | Welcome to | I'm new to Digibank |
    And I print login button name
    And I confirm tests completed with result ANDROID TEST PASSED


  @landAndroid
  Scenario: Verify elements on landing page for Android negative
    Given Appium server and simulator with application type Android started
    When I verify landing page is loaded
    Then I verify elements on landing page
      | logInButton | logoLabel  | signUpButton        |
      | Log In      | Welcome to | I'm old to Digibank |
    And I print login button name
    And I confirm tests completed with result TEST FAILED
