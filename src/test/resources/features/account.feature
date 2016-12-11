Feature: As a product owner I want an account information to viewed and edited.

		  
Background:
	Given user already logged in Gurukula application as "admin" "admin"

	
	 Scenario: 004a- Logged in user should view the settings information
		 When user selects submenu settings under Account Menu
		 Then system displays heading as "User settings for [admin]"
		 And user first name as "Administrator"
		 And user last name as "Administrator"
		 And user email address as "admin@localhost"
		 And user language perference as "English"
		 And button to save the changes
	 
	 Scenario: 004b- Logged in user should be able to edit the settings information
		 When user selects submenu settings under Account Menu
		 And user changed the first name "Administrator" to "tester"
		 And user changed the email address "admin@localhost" to "tester@gurukula.com"
		 And save the user settings
		 Then user settings are saved successfully with message "Settings saved!" 
		 And edited the new first name 
		 And edited the new email address
		 	 
	Scenario: 004c- Logged in user should be able to edit the existing password information
		 When user selects submenu password under Account Menu
		 And user changed the new password "tester"
		 And user reconfirm the new password "tester"
		 And save the password
		 Then user password saved successfully with message "Password changed!"
 
 
 
 
 
 