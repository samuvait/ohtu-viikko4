Feature: As a registered user can log in with valid username/password-combination

Scenario: user can login with correct password
Given login is selected
When correct username "jukka" and password "akkuj123" are given
Then user is logged in

Scenario: user can not login with incorrect password
Given login is selected
When correct username "jukka" and incorrect password "wrong123" are given
Then user is not logged in and error message is given

Scenario: nonexistent user can not login to 
        Given login is selected
        When  incorrect username "kolme" and incorrect password "wrong123" are given
        Then  nonexistent user is not logged in and error message is given