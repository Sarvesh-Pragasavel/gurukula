package com.gurukula;

import net.serenitybdd.core.pages.PageObject;
import net.thucydides.core.annotations.DefaultUrl;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;


@DefaultUrl("/#/")
public class HomePage extends PageObject {
	
	@FindBy(linkText="login")
	WebElement login;
	
	@FindBy(css="li.dropdown.pointer.ng-scope")
	WebElement entities; 
	
	@FindBy(css="div.alert.alert-success.ng-scope.ng-binding")
	WebElement welcomeMessage;
	
	@FindBy(css="li.dropdown.pointer.ng-scope a.dropdown-toggle")
	WebElement entitiesMenu;
	
	@FindBy(partialLinkText="Account")
	WebElement accountMenu;
	
	@FindBy(partialLinkText="Log out")
	WebElement logoutLink;
	
	@FindBy(xpath="//div[2]/div/div[1]")
	WebElement logoutMessage;
		
	public void loginLink(){
		login.click();
	}

	public void entitiesLink(){
		entities.click();
	}
	
	public String getWelcomeMsg(){
		return welcomeMessage.getText();
	}
	
	public String getEntityMenu(){
		return entitiesMenu.getText();
	}
	
	public void clickAccountMenu(){
		accountMenu.click();
	}
	
	public void clickLogoutLink(){
		logoutLink.click();
	}
	
	public String getLogoutMessage(){
		return logoutMessage.getText();
	}

}
