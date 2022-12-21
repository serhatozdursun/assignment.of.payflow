Feature: The aim of this feature is to support user register to the parabank.parasoft.com

  Rule: User should have an account on para bank
    Scenario:As a parabank user, Should be able to register on parabank.parasoft.com
    Any user who already has a bank account Should be able to get registered
    if they fill out the registration form with valid data
      Given The user that already has a bank account on register page
        | First Name | Last Name | Address | City     | State | Zip Code | Phone        | SSN    |
        | Serhat     | Ozdursun  | Turkey  | Istanbul | Rize  | 53700    | 905368361407 | 123123 |
      And With valid user name and "1Q2w3e4r5t" as password
      When Fill out the register form and click register button.
      Then Should be register successful


    Scenario: Password mismatch
    The page shouldn't allow different passwords to be passed to Confirm password.
      Given The user that already has a bank account on register page
        | First Name | Last Name | Address | City     | State | Zip Code | Phone        | SSN    |
        | Serhat     | Ozdursun  | Turkey  | Istanbul | Rize  | 53700    | 905368361407 | 123123 |
      And Type a "1Q2w3e4r5t" as password
      And Type a "123123123" as Confirm password
      And Type a "asdasdasd asd" as username
      When Fill out the register form and click register button.
      Then The repeat password error should be display on the page as "Passwords did not match."

    Scenario: Register with the already exist user name
    The page shouldn't allow using the username that already exists to register a new user
      Given The user that already has a bank account on register page
        | First Name | Last Name | Address | City     | State | Zip Code | Phone        | SSN    |
        | Serhat     | Ozdursun  | Turkey  | Istanbul | Rize  | 53700    | 905368361407 | 123123 |
      And Type a "1Q2w3e4r5t" as password
      And Type a "1Q2w3e4r5t" as Confirm password
      And Type a "already.exists" as username
      When Fill out the register form and click register button.
      #Then The repeat password error should be display on the page as "This username already exists."


    #Also, there should be other negative cases as well
    #with such as following list.
    #First name is required.
    #Last name is required.
    #Address is required.
    #City is required.
    #State is required.
    #Zip Code is required.
    #Social Security Number is required.
    #Username is required.
    #Password is required.
    #Password confirmation is required.

    # Furthermore, if any field requires any other validation those validations should be tested.
    # Such as a valid City or phone number according to the country etc. And Definitely,
    # there should be a test about the password field mask.
