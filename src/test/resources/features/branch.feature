Feature:  Gurukula application is used to maintain 'Branches' entity - Id, branch code and name.
		  User can perform create, udpate, read and delete operation.
		  User navigate to Branch via Entities menu.
		  
Background:
	Given User logged in as admin "admin" "admin"
	And user selects branch page under Entities Menu

	
	Scenario: 002a- Create a new Branch information 
		When user fill in branch name as "GURUKULA"
		And user fill in branch code as "GURUAMS"
		Then new branch is created sucessfully

	Scenario: 002b- View Branch information 
		And branch name "GURUKULA" , branch code "GURUAMS" is displayed in Branch page
		When user clicks on view branch button
		Then the view page displays the branch information for the selected branch
		And the branch view page should not be editable
		
	Scenario: 002c- Edit Branch information
		And branch name "GURUKULA" , branch code "GURUAMS" is displayed in Branch page
		When user tries to edit branch information of "GURUKULA" and "GURUAMS" to "BREPORT"
		Then edited Branch "BREPORT" "GURUAMS" returns in Name and Code
	
	
	Scenario: 002d- Delete Branch information 
		And branch name "BREPORT" , branch code "GURUAMS" is displayed in Branch page
		When user clicks on delete button on branch
		Then branch information deleted successfully
	
	
	Scenario: 002e- Search a Branch information 
		When user fill in branch name as "GURUKULA"
		And user fill in branch code as "GURUAMS"
		Then new branch is created sucessfully
		When user tries to search branch information of "GURUKULA"
		Then searched Branch "GURUKULA" "GURUAMS" returns in Name and Code
