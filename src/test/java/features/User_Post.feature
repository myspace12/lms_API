@tag
Feature: Validating Post HTTPS request in User API
Background: Authorization set to  Basic Auth 

  @tag1
  Scenario Outline: Check if user is able create a new record with all valid field values
  Given User creates "Post" method Endpoint with data from "<SheetName>" and <RowNumber>
	When User calls "PostUser" endpoint with "POST" https Request
	Then User should receive status code and response body in "Post" method
	
	 Examples: 
      | SheetName  | RowNumber | 
      | UserPost   |     0     | 
      | UserPost   |     1     | 

  @tag2
  Scenario Outline: Check if user is able create a new record with all Invalid field values
  Given User creates "Post" method Endpoint with data from "<SheetName>" and <RowNumber>
	When User calls "PostUser" endpoint with "POST" https Request
	Then User should receive status code and response body in "Post" method
	
	 Examples: 
      | SheetName  | RowNumber| 
      | UserPost   |     2    | 
      | UserPost   |     3    | 

  