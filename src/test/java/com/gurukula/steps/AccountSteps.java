package com.gurukula.steps;

import com.gurukula.HomePage;

import org.junit.Assert;

import com.gurukula.AccountPage;

import net.thucydides.core.annotations.Step;

public class AccountSteps {

	
	HomePage homePage;
	AccountPage accountPage;
	
	

	@Step
	public void selectSettings(){
		homePage.clickAccountMenu();
		accountPage.settingsLink();
	}
	
	@Step
	public void selectPassword(){
		homePage.clickAccountMenu();
		accountPage.passwordLink();
	}
	
	@Step
	public void verifyAccountTitle(String CheckTitle){
		Assert.assertEquals(CheckTitle, accountPage.getCheckSettingsTitle());
	}
	
	@Step
	public void verifyAccountFirstName(String CheckFirstName){
		Assert.assertEquals(CheckFirstName, accountPage.getCheckFirstName());
	}
	
	@Step
	public void verifyAccountLastName(String CheckLastName){
		Assert.assertEquals(CheckLastName, accountPage.getCheckLastName());
	}
	
	@Step
	public void verifyAccountEmail(String CheckEmail){
		Assert.assertEquals(CheckEmail, accountPage.getCheckEmail());
	}

	@Step
	public void verifyAccountLanguage(String CheckLanguage){
		Assert.assertEquals(CheckLanguage, accountPage.getCheckLanguage());
	}

	@Step
	public void verifyAccountSaveBtn(){
		Assert.assertTrue("Save bustton is present in Account Settings",  accountPage.getCheckSaveBtn());
	}
	
	@Step
	public void editAccountFirstName(String EditFirstName){
		accountPage.editFirstName(EditFirstName);
	}
	
	@Step
	public void editAccountEmailId(String EditEmailId){
		accountPage.editEmailId(EditEmailId);
	}
	
	@Step
	public void saveAccountSettingsDetails(){
		accountPage.saveAccountDetails();
	}
	
	@Step
	public void verifySavedAccountStatus(String SavedSettings){
		Assert.assertEquals(SavedSettings, accountPage.getCheckSavedSettings());
	}
	
	@Step
	public void editNewPassword(String newPassword){
		accountPage.editPassword(newPassword);
	}
	
	@Step
	public void editConfirmPassword(String confirmPassword){
		accountPage.reconfirmPassword(confirmPassword);
	}
	
	@Step
	public void savePasswordsDetails(){
		accountPage.savePasswordDetails();
	}
	
	@Step
	public void verifySavedPasswordStatus(String CheckPasswordSaved){
		Assert.assertEquals(CheckPasswordSaved, accountPage.getCheckSavedPassword());
	}
}
