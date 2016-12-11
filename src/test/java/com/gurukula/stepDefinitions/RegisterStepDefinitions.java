package com.gurukula.stepDefinitions;


import com.gurukula.steps.LoginSteps;
import com.gurukula.steps.RegisterSteps;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import net.serenitybdd.core.Serenity;
import net.thucydides.core.annotations.Steps;

public class RegisterStepDefinitions {
	
		@Steps
		LoginSteps loginStep;
		
		@Steps
		RegisterSteps registerStep;
		
		@Given("^user is not a member of gurukula application$") 
		public void user_launched_gurukula_application(){
			loginStep.launch();
		}
		
		@And("^register a new user from home page$")
		public void register_a_new_user_from_home_page(){
			registerStep.registerNewUser();
		}
		
		@And("^register a new user from Account Menu$")
		public void register_a_new_user_from_Account_Menu(){
			registerStep.registerNewUserAM();
		}
		
		@When("^user provided login details as \"(.*?)\"$")
		public void user_provided_login_details_as(String loginName){
			Serenity.setSessionVariable("LoginName").to(loginName);
			registerStep.login(loginName);
		}
		
		@And("^email address as \"(.*?)\"$")
		public void email_address_as(String emailId){
			Serenity.setSessionVariable("EmailID").to(emailId);
			registerStep.email(emailId);
		}
		
		@And("^new password as \"(.*?)\"$")
		public void new_password_as(String passWord){
			Serenity.setSessionVariable("Password").to(passWord);
			registerStep.password(passWord);
			
		}
		
		@And("^reconfirm password as \"(.*?)\"$")
		public void reconfirm_password_as(String confirmPassWord){
			Serenity.setSessionVariable("Registername").to(confirmPassWord);
			registerStep.reconfirm(confirmPassWord);
		}
		
		@And("^register$")
		public void user_enters_username(){
			registerStep.register();
		}
		
		@Then("^new user is registered successfully$")
		public void new_user_is_registered_successfully(){
			registerStep.validateRegisterMsg();
		}



}
