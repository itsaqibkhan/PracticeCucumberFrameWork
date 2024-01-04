Feature: Products scenarios

  Background:
    When I tap on menu button
    And I tap on login button

  Scenario Outline: Validate products on product details page
    Given I'm logged in
    Then The product is listed with title "<title>"
    Examples: | title                   | price  |
    | title                   | price  |
    | Sauce Labs Backpack | $15.99 |
#      | Sauce Labs Onesie       | $7.99  |
#      | Test.allTheThings() T-Shirt (Red) | $15.99 |
#      | Sauce Labs Backpack     | $29.99 |

  Scenario Outline: Validate product info on Product Details page
    Given I'm logged in
    When I click product title "<title>"
    Then I should be on product details page with title "<title>", price "<price>" and description "<description>"
    Examples:
      | title               | price  | description                                                                                                                            |
      | Sauce Labs Backpack | $29.99 | carry.allTheThings() with the sleek, streamlined Sly Pack that melds uncompromising style with unequaled laptop and tablet protection. |
 #     | Sauce Labs Bolt T-Shirt | $15.99 | Get your testing superhero on with the Sauce Labs bolt T-shirt. From American Apparel, 100% ringspun combed cotton, heather gray with red bolt. |