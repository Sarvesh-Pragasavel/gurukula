package com.gurukula;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import net.serenitybdd.core.pages.PageObject;

public class LoginPage extends PageObject{
	
	@FindBy(id="username")
	WebElement username;
	
	@FindBy(id="password")
	WebElement password;
	
	@FindBy(css="button.btn.btn-primary.ng-scope")
	WebElement Authenticate;
	
	
	public void loginDetail(String userName,String passWord){
		username.sendKeys(userName);
		password.sendKeys(passWord);
		Authenticate.click();
			}

}
