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
When user tries to edit Staff information of "TESTER" to "DEVELOPER"
Then edited Staff "TESTERDEVELOPER" "GURUKULA" returns in Name and Branch

Scenario: 003d- Delete Staff information 
And staff id 1 information is present in Staff page
When user clicks on delete button
#Then the delete page displays the staff id information for the selected staff
#When user deletes the staff information
#Then staff information deleted successfully

#Yet to start Working

Scenario: 003e- Search a Staff information 
And staff name "TESTER" , branch name "GURUKULA" is displayed in Staff page
#When user enters "TESTER" staff name in query 
#And clicks on search a staff button
#Then page displays only the staff information for the searched staff


Scenario: 003f- Pagination on Staff information 
And staff page loaded with 21 staff information
|CHECK|GURUKULA|
When user click on Next page
Then it loads staff information from 21 onwards
When user click on previous page
Then it loads staff information with first 20 records