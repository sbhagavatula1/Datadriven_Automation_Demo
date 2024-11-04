Feature: User Login
  
  Background:
    Given User is on the OrangeHRM login page
  @C11_ValidCredentials_from_Steps
  Scenario: Login with valid credentials entered directly in the Steps
    When User enters valid userID and valid Password directly in the Steps
    And click the Login button
    Then User should be redirected to the Dashboard page with title as shown in the expected alert message entered in the steps
  @D11_ValidCredentials_from_Scenario
  Scenario: Login with valid credentials from Scenario
    When User enters valid username "Admin" and valid password "admin123" in the Scenario
    And click the Login button
    Then User should be redirected to the Dashboard page with dashboard title "Dashboard"
  @D21_ValidCredentials_from_Examples
  Scenario Outline: Login with valid credentials from Examples
    When User enters valid username "<username_ex>" and valid password "<password_ex>" from Examples
    And click the Login button
    Then User should be redirected to the Dashboard page with dashboard title "<alertMessage_ex>"
    Examples:
    | username_ex  | password_ex   | alertMessage_ex  |
    | Admin        | admin123      | Dashboard        |
  @E11_ValidCredentials_from_DataTable_withHeader
  Scenario: Login with valid credentials from Data Table with header
    When User enters valid credentials from the datatable with header
    | username_dt_wh  | password_dt_wh |
    | Admin           | admin123       |
    And click the Login button
    Then User should be redirected to the Dashboard page with dashboard title from Data Table with header
    | alertMessage_dt_wh |
    | Dashboard          |
  @E21_ValidCredentials_from_DataTable_withoutHeader
  Scenario: Login with valid credentials from Data Table without header
    When User enters valid credentials from the datatable without header
    | Admin | admin123 |
    And click the Login button
    Then User should be redirected to the Dashboard page with dashboard title from Data Table without header
    | Dashboard |
  @F11_ValidCredentials_from_Config_File
  Scenario: Login with valid credentials entered directly in the Steps via Config File
    When User enters valid credentials in the steps via Config File
    And click the Login button
    Then User should be redirected to the Dashboard page with dashboard title as shown in the Config file
  @G11_ValidCredentials_from_Excel_File
  Scenario Outline: Validating Login process for User with valid data from Excel file
    When user enters valid user credentials read from excel sheet name "<SheetName>" and row number <RowNumber>
    And click the Login button
    Then User should be redirected to the dashboard page with dashboard title read from excel sheet name "<SheetName>" and row number <RowNumber>
    Examples: 
    | SheetName   | RowNumber |
    | Credentials |     0     |
    |      0      |     0     |
  @H11_ValidCredentials_from_CSV_File_withHeader
  Scenario: Login with valid credentials entered from CSV file with header
    When User enters valid credentials via CSV file with header
    And click the Login button
    Then User should be redirected to the Dashboard page with dashboard title read from CSV file with header
  @H21_ValidCredentials_from_CSV_File_withoutHeader
  Scenario: Login with valid credentials entered from CSV file without header
    When User enters valid credentials via CSV file without header
    And click the Login button
    Then User should be redirected to the Dashboard page with dashboard title read from CSV file without header
  @K11_ValidCredentials_from_MySQL_Database
  Scenario: Login with valid credentials entered from MySQL database
    When User enters valid credentials via MySQL database
    And click the Login button
    Then User should be redirected to the Dashboard page with dashboard title read from MySQL database
  @L11_ValidCredentials_from_SQLSERVER_Database
  Scenario: Login with valid credentials entered from SQLSERVER database
    When User enters valid credentials via SQLSERVER database
    And click the Login button
    Then User should be redirected to the Dashboard page with dashboard title read from SQLSERVER database

#  Scenario: User login with invalid credentials
#     When User enter invalid credentials
#     And click the Login button
#     Then User should see an error message  
#   Scenario: User login without providing credentials
#     When User click on the Login button without providing credentials
#     Then User should see an error message
#   Scenario: User login with missing username
#     When User enter the password without providing a username
#     And click the Login button
#     Then User should see an error message
#   Scenario: User login with missing password
#     When User enter the username without providing a password
#     And click the Login button
#     Then User should see an error message
#  @InvalidCredentials
#  Scenario Outline: Login with invalid credentials - Feature 1, Scenario - 2
#    When User enters username as "<username>" and password as "<password>"
#    Then User should be able to see credentials invalid error message "<errorMessage>"
#    Examples:
#    | username  | password   | errorMessage         |
#    | Admin     | admin12$$  | Invalid credentials  |
#    | admin$$   | admin123   | Invalid credentials  |
#    | abc123    | xyz$$      | Invalid credentials  |
#  @MissingUsernameCredentials
#  Scenario Outline: Login with missing credentials - Feature 1, Scenario - 3
#    When User enters username as "<username>" and password as "<password>"
#    Then User should be able to see username missing error message "<missngUsernameErrorMessage>"
#    Examples:
#    | username  | password   | missngUsernameErrorMessage    |
#    |           | xyz$$      | Required                      |
#    |           | admin123$$ | Required                      |
#  @MissingPasswordCredentials
#  Scenario Outline: Login with missing credentials - Feature 1, Scenario - 4
#    When User enters username as "<username>" and password as "<password>"
#    Then User should be able to see password missing error message "<missngPasswordErrorMessage>"
#    Examples:
#    | username  | password   | missngPasswordErrorMessage    |
#    | xyz$$     |            | Required                      |
#    | Admin     |            | Required                      |
#  @MissingCredentials
#  Scenario Outline: Login with missing credentials - Feature 1, Scenario - 5
#    When User enters username as "<username>" and password as "<password>"
#    Then User should be able to see both username and password missing error messages "<UsernameMissingErrorMessage>" and "<PasswordMissingErrorMessage>"
#    Examples:
#    | username  | password  | UsernameMissingErrorMessage    | PasswordMissingErrorMessage    |
#    |           |           | Required                       | Required                       |
#@03_InvalidCredentialsFromExamples
#@04_MissingUsernameCredentialsFromExamples
#@05_MissingPasswordCredentialsFromExamples
#@06_MissingCredentialsFromExamples
#@071_ValidCredentialsInDatatablesWithHeader
#@081_ValidCredentialsInDatatablesWithoutHeader
#@091_ValidCredentiaFromExcelFile
#@10_BackButtonFunctionality
#@11_ResetButtonFunctionality