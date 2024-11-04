Feature: Employee Creation

Scenario: HR manager creates a new employee record

  Given User is logged as an HR manager
  And User creates the employee page
  When User enters all the required employee details
  And click on the Create Employee button
  Then the employee record should be saved correctly in the system

Scenario: HR manager receives an error message for missing required fields

  Given User is logged as an HR manager
  And User is on the employee creation page
  When User tries to create an employee record without providing the required fields
  And click on the Create Employee button
  Then User should see an error message indicating the missing fields

Scenario: HR manager receives an error message for invalid data in fields

  Given User is logged as an HR manager
  And User is on the employee creation page
  When User enters invalid data in one or more fields
  And click on the Create Employee button
  Then User should see an error message indicating the invalid data


