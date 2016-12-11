package com.gurukula.stepDefinitions;


import com.gurukula.steps.LoginSteps;
import com.gurukula.steps.StaffSteps;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import net.serenitybdd.core.Serenity;
import net.thucydides.core.annotations.Steps;

public class LoginStepDefinitions {
		
		@Steps
		LoginSteps loginStep;
		
		@Steps
		StaffSteps staffStep;
		
		@Given("^User is a member of Gurukula application$")
		@And("^user launched Gurukula application$")
		public void user_launched_gurukula_application(){
			loginStep.launch();
		}
		
		@When("^user enters user name as \"(.*?)\" and password as \"(.*?)\"$")
		public void user_enters_username(String userName, String password){
			Serenity.setSessionVariable("Username").to(userName);
			loginStep.login(userName, password);
		}
		
		@Then("^user is logged in successfully$")
		public void user_logged_in_successfully(){
			loginStep.validateWelcomeMsg(Serenity.sessionVariableCalled("Username").toString());
		}
		
		@And("^user is able to view the homepage$")
		public void user_able_to_view_homepage(){
			loginStep.validateHomePageMenu();
		}
		
		@Given("^user already logged in Gurukula application as \"(.*?)\" \"(.*?)\"$")
		public void user_already_logged_into_application(String userName, String password){
			loginStep.userAlreadyLogin(userName, password);
		}
		
		@When("^user Logout from Account Menu$")
		public void user_logout_from_account_menu(){
			loginStep.logout();
		}
		
		@Then("^user is logout successfully$")
		@And("^user redirect to welcome page$")
		public void user_logout_successfully(){
			loginStep.validateUserLogout();
		}
		
		@Given("^User logged in as admin \"(.*?)\" \"(.*?)\"$")
		public void Gurukula_application_logged_in_as(String userName,String passWord) {
			loginStep.launch();
	        loginStep.login(userName,passWord);
	    }
		
}
