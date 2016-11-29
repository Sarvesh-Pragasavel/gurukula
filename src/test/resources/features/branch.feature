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

#Scenario: 002b- View Branch information 
#When user tries to View Branch
#Then respective Branch ID returns with Name and Code value in non-editable format

#Scenario: 002c- Edit Branch information 
#When user tries to Edit Branch
#Then respective Branch ID returns with Name and Code value in editable format
#
#Scenario: 002d- Delete Branch information 
#When user tries to Delete Branch
#Then respective Branch ID Name and Code values are sucessfully deleted from Branches
#
#Scenario: 002e- Query Branch information 
#When user Query Branch
#Then respective Branch ID alone returns with Name and Code value in Branches
