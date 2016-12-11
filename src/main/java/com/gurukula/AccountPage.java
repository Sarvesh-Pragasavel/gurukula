package com.gurukula;


import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import net.serenitybdd.core.annotations.findby.By;
import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.core.pages.WebElementFacade;

public class AccountPage extends PageObject {
	

	@FindBy(partialLinkText="Settings")
	WebElement settings;
	
	@FindBy(partialLinkText="Password")
	WebElement passWord;
	
	@FindBy(css=".col-md-8.col-md-offset-2")
	WebElement title;
	
	@FindBy(xpath="//div[@class='alert alert-success ng-scope']")
	WebElement successMsg;
			
	@FindBy(name="firstName")
	WebElement firstName;
	
	@FindBy(name="lastName")
	WebElement lastName;
	
	@FindBy(name="email")
	WebElement email;
	
	@FindBy(name="langKey")
	WebElementFacade langKey;
	
	@FindBy(css="button.btn.btn-primary.ng-scope")
	WebElement save;
	
	@FindBy(name="password")
	WebElement newPassWord;
	
	@FindBy(name="confirmPassword")
	WebElement confirmPassWord;
	
	@FindBy(css="button.btn.btn-primary.ng-scope")
	WebElement savePassWord;
	
	
	public void settingsLink(){
		settings.click();
	}
	
	public void passwordLink(){
		passWord.click();
	}
	
	public String getCheckSettingsTitle(){ 
		return title.findElement(By.tagName("h2")).getText();
	}
	
	public String getCheckFirstName(){ 
		return firstName.getAttribute("value");
	}
	
	public String getCheckLastName(){ 
		return lastName.getAttribute("value");
	}
	
	public String getCheckEmail(){ 
		return email.getAttribute("value");
	}

	public String getCheckLanguage(){ 
		return langKey.findElement(By.tagName("option")).getText();
	}
	
	public boolean getCheckSaveBtn(){ 
		return save.isEnabled();
	}
	
	public void editFirstName(String EditFirstName){ 
		firstName.clear();
		firstName.sendKeys(EditFirstName);
	}
	
	public void editEmailId(String EditEmailId){ 
		email.clear();
		email.sendKeys(EditEmailId);
	}
	
	public void saveAccountDetails(){ 
		save.click();
	}
		
	public String getCheckSavedSettings(){
		return successMsg.getText();
	}
	
	public void editPassword(String newPassword){ 
		newPassWord.sendKeys(newPassword);
	}
	
	public void reconfirmPassword(String confirmPassword){ 
		confirmPassWord.sendKeys(confirmPassword);
	}
	
	public void savePasswordDetails(){ 
		savePassWord.click();
	}
	public String getCheckSavedPassword(){
		return successMsg.getText();
	}
	
}
