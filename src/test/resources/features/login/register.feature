Feature: The purpose of this feature is to support user login to parabank.parasoft.com.

  #Scenario: Successful login
  #As a customer, I should be able to login with valid credentials
  #  Given the parabank homepage and the following credentials
  #    | First Name | Last Name      |
  #    | valid.user | valid password |
  #  When Click Log In button
  #  Then User should login successfully

  #Scenario: Login with invalid username
  #As a customer, I should be able to login with valid credentials
  #  Given the parabank homepage and the following credentials
  #    | First Name   | Last Name      |
  #    | invalid.user | valid password |
  #  When Click Log In button
  #  Then The page should display an invalid credential error and sign in
  #    | Error Message                                    |
  #    | The username and password could not be verified. |

  #Scenario: Login with invalid password
  #As a customer, I should be able to login with valid credentials
  #  Given the parabank homepage and the following credentials
  #    | First Name | Last Name        |
  #    | valid.user | invalid password |
  #  When Click Log In button
  #  Then The page should display an invalid credential error and sign in
  #    | Error Message                                    |
  #    | The username and password could not be verified. |

  #Scenario: Login with invalid password and invalid user name
  #As a customer, I should be able to login with valid credentials
  #  Given the parabank homepage and the following credentials
  #    | First Name   | Last Name        |
  #    | invalid.user | invalid password |
  #  When Click Log In button
  #  Then The page should display an invalid credential error and sign in
  #    | Error Message                                    |
  #    | The username and password could not be verified. |


    #Also, if there is a format or length restriction for both username and password,
    # it should be tested and ensured.
    # If the username or password does not match the format and is longer than it should be (it is already invalid),
    # an error message should be given in the front end and the data should not be sent to the back end.
    # it should be confirmed that the formation of an unnecessary network load in this number is prevented.
