package com.gurukula.steps;

import net.thucydides.core.annotations.Step;
import org.junit.Assert;

import com.gurukula.HomePage;
import com.gurukula.LoginPage;

public class LoginSteps {
	
	HomePage homePage;
	LoginPage loginPage;
	
	@Step
	public void launch(){
		homePage.open();
	}
	
	@Step
	public void login(String userName,String passWord){
		homePage.loginLink();
		loginPage.loginDetail(userName,passWord);
	}
	
	@Step
	public void validateWelcomeMsg(String userName){
		 Assert.assertEquals("You are logged in as user \""+userName+"\".",homePage.getWelcomeMsg());
	}
	
	@Step
	public void validateHomePageMenu(){
		 Assert.assertEquals("Entities",homePage.getEntityMenu());
	}
	
	@Step
	public void userAlreadyLogin(String userName,String password){
		homePage.open();
		homePage.loginLink();
		loginPage.loginDetail(userName,password);
	}
	
	@Step
	public void logout() {
		homePage.clickAccountMenu();
		homePage.clickLogoutLink();
	}
	
	public void validateUserLogout(){
		Assert.assertEquals("Click here to login", homePage.getLogoutMessage());
	}
	
}
