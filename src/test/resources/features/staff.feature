Feature:  Gurukula application is used to maintain 'Staff' entity - Id, staff name and branch.
		  User can perform create, udpate, read and delete operation.
		  User navigate to Staff via Entities menu.

Background:
	Given User logged in as admin "admin" "admin"
	And user selects staff page under Entities Menu
	

	Scenario: 003a- Create a new Staff information 
		When user fill in staff name as "TESTER" and branch as "GURUKULA"
		Then new staff information created successfully
	
	Scenario: 003b- View Staff information 
		And staff name "TESTER" , branch name "GURUKULA" is displayed in Staff page
		When user clicks on view button
		Then the view page displays the staff information for the selected staff
		And the page should not be editable
	
	Scenario: 003c- Edit Staff information
		And staff name "TESTER" , branch name "GURUKULA" is displayed in Staff page
		When user tries to edit Staff information of "TESTER" and "GURUKULA" to "DEVELOPER"
		Then edited Staff "DEVELOPER" "GURUKULA" returns in Name and Branch
	
	Scenario: 003d- Delete Staff information 
		And staff name "DEVELOPER" , branch name "GURUKULA" is displayed in Staff page
		When user clicks on delete button
		Then staff information deleted successfully
	
	Scenario: 003e- Search a Staff information 
		And staff name "TESTER" , branch name "GURUKULA" is displayed in Staff page
		When user tries to search Staff information of "TESTER"
		Then searched Staff "TESTER" "GURUKULA" returns in Name and Branch
	
	
	Scenario: 003f- Pagination on Staff information 
		And staff page loaded with 21 staff information
		|CHECK|GURUKULA|
		When user click on Next page
		Then it loads staff information from 21 onwards
		When user click on previous page
		Then it loads staff information with first 20 records