Feature: Login scenarios

  Background:
    When I tap on menu button
    And I tap on login button

  Scenario Outline: Login without credential
    When I login
    Then Login not completed with error message as "<err>"
    Examples:
      | err                   |
      | Username is required |

  Scenario Outline: Login with invalid user
    When I enter username as "<username>"
    And I enter password as "<password>"
    And I login
    Then Login should fail with error message as "<err>"
    Examples:
      | username        | password | err                                                                                  |
      | abc@yopmail.com | Test@123 | Provided credentials do not match any user in this service. |

  Scenario Outline: Login with locked user
    When I enter username as "<username>"
    And I enter password as "<password>"
    And I login
    Then Login should fail with error message as "<err>"
    Examples:
      | username          | password | err                                   |
      | alice@example.com | 10203040 | Sorry, this user has been locked out. |

  Scenario Outline: Login with valid user
    When I enter username as "<username>"
    And I enter password as "<password>"
    And I login
    Then Login successful and redirect to product page with "<title>"
    Examples:
      | username        | password | title    |
      | bob@example.com | 10203040 | Products |