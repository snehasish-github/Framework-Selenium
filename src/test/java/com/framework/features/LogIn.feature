Feature: LogIn

  @Test1
  Scenario Outline: Test LogIn Feature
    Given User Login to application with "<UserName>","<Password>"

    Examples:
    | UserName               | Password |
    | test.test123@gmail.com | Test@123 |

  Scenario Outline: Test LogIn Feature1
    Given User Login to application with "<UserName>","<Password>"
#   Given User serach for dress

    Examples:
      | UserName               | Password |
      | test.test@gmail.com    | Test@123 |