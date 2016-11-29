package com.gurukula;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import net.serenitybdd.core.pages.PageObject;


public class BranchPage extends PageObject {
	
	@FindBy(css="li.dropdown.pointer.ng-scope")
	WebElement entities; 
	
	@FindBy(partialLinkText="Branch")
	WebElement branch;
	
	@FindBy(xpath="//div[@class='col-md-4']/button[@class='btn btn-primary']")
	WebElement newBranch;
	
	@FindBy(name="name")
	WebElement branchName;
	
	@FindBy(name="code")
	WebElement branchCode;
	
	@FindBy(xpath="//div[@class='modal-footer']/button[@class='btn btn-primary']")
	WebElement newBranchButton;
	
	@FindBy(xpath="//table/tbody/tr[1]/td[2]")
	WebElement addedBranchName;
	
	@FindBy(xpath="//table/tbody/tr[1]/td[3]")
	WebElement addedBranchCode;

	
	public void selectEntities(){
		entities.click();
	}
	
	public void branchLink(){
		branch.click();
	}
	
	
	public void enterBranchName(String name){
		WebDriverWait wait = new WebDriverWait(this.getDriver(), 15);
		wait.until(ExpectedConditions.elementToBeClickable(newBranch)); 
		newBranch.click();
		branchName.sendKeys(name);
	}
	
	public void enterBranchCode(String code){
		branchCode.sendKeys(code);
	}
	
	public void saveBranchBtn(){
		WebDriverWait wait = new WebDriverWait(this.getDriver(), 15);
		wait.until(ExpectedConditions.elementToBeClickable(newBranchButton)); 
		newBranchButton.click();
	}
	
	public String getBranchName(){
		return addedBranchName.getText();
	}
	
	public String getBranchCode(){
		return addedBranchCode.getText();
	}
	

}
