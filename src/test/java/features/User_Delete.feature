@tag
Feature: Validating Delete HTTPS request in User API
Background: Authorization set to  Basic Auth 

  @tag1
  Scenario Outline: Check if user is able delete a record with valid User_ID
  Given User creates "delete" method Endpoint with data from "<SheetName>" and <RowNumber>
	When User calls "DeleteUser" endpoint with "Delete" https Request
	Then User should receive status code and response body in "Delete" method
	 Examples: 
      | SheetName   | RowNumber | 
      | UserDelete  |     0   | 
     
	 @tag2
  Scenario Outline: Check if user is able delete a record with Invalid User_ID
  Given User creates "delete" method Endpoint with data from "<SheetName>" and <RowNumber>
	When User calls "DeleteUser" endpoint with "Delete" https Request
	Then User should receive status code and response body in "Delete" method
	
	 Examples: 
      | SheetName   | RowNumber | 
      | UserDelete  |     1     | 
      | UserDelete  |     2     | 
