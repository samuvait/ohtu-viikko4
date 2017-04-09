Feature: A new user account can be created if a proper unused username and password are given

    Scenario: creation successful with correct username and password
        Given new user is selected
        When  unused username "kissa" and correct password "kissa123" are given
        Then  account is created successfully

    Scenario: creation fails with too short username and valid passord
        Given new user is selected
        When  short username "ab" and correct password "kissa123" are given
        Then  user is not created and error "username should have at least 3 characters" is reported

    Scenario: creation fails with correct username and too short password
        Given new user is selected
        When  correct username "jussi" and short password "kissa12" are given
        Then user is not created and error "password should have at least 8 characters" is reported

    Scenario: creation fails with correct username and password consisting of letters
        Given new user is selected
        When  correct username "jussi" and letter password "kissaabc" are given
        Then user is not created and error "password can not contain only letters" is reported

    Scenario: creation fails with already taken username and valid pasword
        Given new user is selected
        When  existing username "jukka" correct password "pekka123" are given
        Then user is not created and error "username is already taken" is reported

    Scenario: creation fails when password and password confirmation do not match
        Given new user is selected
        When  unused username "pato" and correct password "padon123" and wrong confirmation "padon321" are given
        Then user is not created and error "password and password confirmation do not match" is reported

    Scenario: user can login with successfully generated account
        Given user with username "liisa" with password "salainen1" is successfully created
        And   login is selected
        When  correct username "liisa" and password "salainen1" are given
        Then  user is logged in

    Scenario: user can not login with account that is not successfully created
        Given user with username "aa" and password "bad" is unsuccessfully created
        And   login is selected
        When  short username "aa" and incorrect password "bad" are given
        Then  user is not logged in and error message is given
