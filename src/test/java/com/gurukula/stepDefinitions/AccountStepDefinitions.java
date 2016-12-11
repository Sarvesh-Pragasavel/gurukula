package com.gurukula.stepDefinitions;

import com.gurukula.steps.AccountSteps;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import net.serenitybdd.core.Serenity;
import net.thucydides.core.annotations.Steps;


public class AccountStepDefinitions {
	
	
	@Steps
	AccountSteps accountStep;
	
		
	@When("^user selects submenu settings under Account Menu$")
	public void user_selects_submenu_settings_under_Account_Menu(){
		accountStep.selectSettings();
	}
	
	@And("^user changed the first name \"(.*?)\" to \"(.*?)\"$")
	public void user_changed_the_first_name(String CheckFirstName, String EditFirstName){
		accountStep.verifyAccountFirstName(CheckFirstName);
		Serenity.setSessionVariable("EditedFirstName").to(EditFirstName);
		accountStep.editAccountFirstName(EditFirstName);
	}
	
	@And("^user changed the email address \"(.*?)\" to \"(.*?)\"$")
	public void user_changed_the_email_address(String CheckEmail, String EditEmailId){
		accountStep.verifyAccountEmail(CheckEmail);
		Serenity.setSessionVariable("EditedEmailId").to(EditEmailId);
		accountStep.editAccountEmailId(EditEmailId);
	}
	
	@And("^save the user settings$")
	public void save_the_user_settings(){
		accountStep.saveAccountSettingsDetails();
	}
	
	@Then("^system displays heading as \"(.*?)\"$")
	public void system_displays_heading_as(String CheckTitle){
		accountStep.verifyAccountTitle(CheckTitle);
	}
	
	@And("^user first name as \"(.*?)\"$")
	public void user_first_name_as(String CheckFirstName){
		accountStep.verifyAccountFirstName(CheckFirstName);
	}

	@And("^user last name as \"(.*?)\"$")
	public void user_last_name_as(String CheckLastName){
		accountStep.verifyAccountLastName(CheckLastName);
	}
	
	@And("^user email address as \"(.*?)\"$")
	public void user_email_address_as(String CheckEmail){
		accountStep.verifyAccountEmail(CheckEmail);
	}
	
	@And("^user language perference as \"(.*?)\"$")
	public void user_language_perference_as(String CheckLanguage){
		accountStep.verifyAccountLanguage(CheckLanguage);
	}
	 
	@And("^button to save the changes$")
	public void button_to_save_the_changes(){
		accountStep.verifyAccountSaveBtn();
	}
	
	@Then("^user settings are saved successfully with message \"(.*?)\"$")
	public void user_settings_are_saved_successfully_message(String CheckSettingsSaved){
		accountStep.verifySavedAccountStatus(CheckSettingsSaved);
	}
	
	@And("^edited the new first name$")
	public void edited_the_new_first_name(){
		accountStep.verifyAccountFirstName(Serenity.setSessionVariable("EditedFirstName").toString());
	}
	
	@And("^edited the new email address$")
	public void edited_the_new_email_address(){
		accountStep.verifyAccountEmail(Serenity.setSessionVariable("EditedEmailId").toString());
	}
	
	@When("^user selects submenu password under Account Menu$")
	public void user_selects_submenu_password_under_Account_Menu(){
		accountStep.selectPassword();
		
	}

	@When("^user changed the new password \"(.*?)\"$")
	public void user_changed_the_new_password(String newPassword){
		accountStep.editNewPassword(newPassword);
		
	}

	@When("^user reconfirm the new password \"(.*?)\"$")
	public void user_reconfirm_the_new_password(String confirmPassword){
		accountStep.editConfirmPassword(confirmPassword);
	}
	
	@When("^save the password$")
	public void save_the_password(){
		accountStep.savePasswordsDetails();
	}

	@Then("^user password saved successfully with message \"(.*?)\"$")
	public void user_password_saved_successfully(String CheckPasswordSaved) {
		accountStep.verifySavedPasswordStatus(CheckPasswordSaved);
	}
}
