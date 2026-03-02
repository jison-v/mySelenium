@GetAllProductList
Feature: Get all product list

  Scenario Outline: Get all product list
    Given url '<URL>'
    When method get
    Then status 200
    And match responseStatus == 200
    * print 'Response status:', response
    * match response.products[0].id == 1

    Examples:
      | URL                                             |
      | https://automationexercise.com/api/productsList |