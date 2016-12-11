Feature: As a product owner user should be able to Register a new User account


	Scenario: 005a- Register a new User account from Home page
		Given user is not a member of gurukula application 
		And register a new user from home page
		When user provided login details as "gurukula"
		And email address as "gurukula@gmail.com"
		And new password as "Testing@123"
		And reconfirm password as "Testing@123"
		And register
		Then new user is registered successfully

	Scenario: 005b- Register a new User account from Account Menu
		Given user is not a member of gurukula application 
		And register a new user from Account Menu
		When user provided login details as "host"
		And email address as "host@gmail.com"
		And new password as "Developer@123"
		And reconfirm password as "Developer@123"
		And register
		Then new user is registered successfully