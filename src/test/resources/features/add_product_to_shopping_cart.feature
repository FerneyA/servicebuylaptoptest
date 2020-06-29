Feature: Buy Product
  As a web user
  I want to find a product
  to add to shopping cart

  Scenario: Add a product to the shopping cart
    Given I want to find a product category Laptops and reference Dell i7 8gb
    When he adds the product to the shopping cart with the order information
    | name | country | city   | credit card | month | year |
    | Andy | Mexico  | Cancún | 45875452235 | April | 2019 |
    Then the purchase is made and the message displayed is Thank you for your purchase!
