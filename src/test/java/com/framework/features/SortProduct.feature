Feature: SortProduct functionality

  @sortTest1
  Scenario Outline: Test LogIn Feature
    #Given User Login to application with "<UserName>","<Password>"
    Given user nevigates to app url "<Url>"
    When  user apply sort on page with "<SortBy>"
    Then  user verify the product in sorted order



    Examples:
      | UserName               | Password | Url                                                               | SortBy |
      | test.test123@gmail.com | Test@123 | https://www.symphonylimited.com/products/commercial-cooler.html   | Product Name |