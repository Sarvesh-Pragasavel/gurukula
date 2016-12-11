package com.gurukula;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import net.serenitybdd.core.pages.PageObject;

public class RegisterPage extends PageObject{
	
	@FindBy(name="login")
	WebElement loginname;
	
	@FindBy(name="email")
	WebElement emailID;
	
	@FindBy(name="password")
	WebElement password;
	
	@FindBy(name="confirmPassword")
	WebElement confirmPassword;
	
	@FindBy(css="button.btn.btn-primary.ng-scope")
	WebElement register;
	
	@FindBy(css="div.alert.alert-success.ng-scope")
	WebElement registerMessage;
	
	public void loginDetail(String loginName){
		loginname.sendKeys(loginName);
		}
	
	public void emailDetail(String emailId){
		emailID.sendKeys(emailId);
		}
	
	public void passwordDetail(String passWord){
		password.sendKeys(passWord);
		}
	
	public void reconfirmDetail(String confirmPassWord){
		confirmPassword.sendKeys(confirmPassWord);
		}
	
	public void registerDetail(){
		register.click();
		}
	
	public String registerMsg(){
		return registerMessage.getText();
		}
}
