Feature: Manage users by service
  As a user
  I want to be able to manage the users
  To check the result of the actions performed

  Scenario: Manage users by service
    When Peter wants to find a user with ID 1
    Then he should see the first name George and last name Bluth
    When Peter wants to find the number of users
    Then he should see 6 users
    Then Peter can delete the user with Id 6
