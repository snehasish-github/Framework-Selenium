Feature: As User I want to Register to the application so that I can shop

  @Register-PositiveFlow
  Scenario Outline: Register with valid credintials
    Given User has valid emailId to create an account "<EmailId>"
#    When user provide vaild data in create an acccount page with "<FirstName>","<LastName>","<Password>","<Address>","<City>",

    Examples:
   | EmailId                | UserName               | Password |
   | test.test123@gmail.com | test.test123@gmail.com | Test@123 |

