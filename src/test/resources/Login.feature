Feature: Login scenarios

  Scenario Outline: Login without credential
    When I login
    Then Login should fail with error message as "<err>"
    Examples:
      | err                   |
      | user name is required |

  Scenario Outline: Login with invalid user
    When I enter username as "<username>"
    And I enter password as "<password>"
    And I login
    Then Login should fail with error message as "<err>"
    Examples:
      | username        | password | err                                                                                  |
      | abc@yopmail.com | Test@123 | This is our error messageProvided credentials do not match any user in this service. |

  Scenario Outline: Login with locked user
    When I enter username as "<username>"
    And I enter password as "<password>"
    And I login
    Then Login should fail with error message as "<err>"
    Examples:
      | username          | password | err                                   |
      | alice@example.com | 10203040 | Sorry, This user has been locked out. |

  Scenario Outline: Login with valid user
    When I enter username as "<username>"
    And I enter password as "<password>"
    And I login
    Then Login successful and redirect to product page with "<title>"
    Examples:
      | username        | password | title    |
      | Bob@example.com | 10203040 | Products |