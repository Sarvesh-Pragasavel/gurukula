package com.gurukula.steps;

import net.thucydides.core.annotations.Step;
import org.junit.Assert;

import com.gurukula.HomePage;
import com.gurukula.RegisterPage;

public class RegisterSteps {
	
	HomePage homePage;
	RegisterPage registerPage;
	
	@Step
	public void launch(){
		homePage.open();
	}
	
	@Step
	public void registerNewUser(){
		homePage.registerLink();
	}
	
	@Step
	public void registerNewUserAM(){
		homePage.clickAccountMenu();
		homePage.registerLinkAM();
	}
	
	@Step
	public void login(String loginName){
		registerPage.loginDetail(loginName);
	}
	
	@Step
	public void email(String emailId){
		registerPage.emailDetail(emailId);
	}
	
	@Step
	public void password(String passWord){
		registerPage.passwordDetail(passWord);
	}
	
	@Step
	public void reconfirm(String confirmPassWord){
		registerPage.reconfirmDetail(confirmPassWord);
	}
	
	@Step
	public void register(){
		registerPage.registerDetail();
	}
	
	@Step
	public void validateRegisterMsg(){
		Assert.assertEquals("Registration saved! Please check your email for confirmation.",registerPage.registerMsg());
	}
	
}
