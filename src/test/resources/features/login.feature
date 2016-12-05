Feature:  As a product owner I want system to perform login and logout feature for Gurukula application.

	Scenario: 001a- Login to Gurukula application as existing User
		Given User is a member of Gurukula application
		When user enters user name as "admin" and password as "admin"
		Then user is logged in successfully
		And user is able to view the homepage

	Scenario: 001b- Logout to Gurukula application as existing User
		Given user already logged in Gurukula application as "admin" "admin"
		When user Logout from Account Menu
		Then user is logout successfully
		And user redirect to welcome page