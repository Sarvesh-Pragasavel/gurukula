package com.gurukula;

import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.core.pages.WebElementFacade;
import net.thucydides.core.annotations.WhenPageOpens;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class StaffPage extends PageObject{
	
	@FindBy(css="li.dropdown.pointer.ng-scope")
	WebElement entities; 
	
	@FindBy(partialLinkText="Staff")
	WebElement staff;
	
	@FindBy(xpath="//div[@class='col-md-4']/button[@class='btn btn-primary']")
	WebElement newStaff;
	
	@FindBy(name="name")
	WebElement staffName;
	
	@FindBy(name="related_branch")
	WebElementFacade staffBranchDropDown;
	
	@FindBy(xpath="//div[@class='modal-footer']/button[@class='btn btn-primary']")
	WebElement newStaffButton;
	
	@FindBy(xpath="//table/tbody/tr[1]/td[2]")
	WebElement addedStaffName;
	
	@FindBy(xpath="//table/tbody/tr[1]/td[3]")
	WebElement addedStaffBranch;
	
	@FindBy(css=".btn.btn-info.btn-sm")
	WebElement viewStaffButton;
	
	@FindBy(xpath="//table/tbody/tr[1]/td[2]/input")
	WebElement viewedStaffName;
	
	@FindBy(xpath="//table/tbody/tr[2]/td[2]/input")
	WebElement viewedStaffBranch;
	

	@FindBy(css=".btn.btn-primary.btn-sm")
	WebElement editStaffButton;
	
	@FindBy(xpath="//input[@ng-model='staff.name']")
	WebElement editStaffName;
	
	@FindBy(xpath="//div[@class='modal-footer']/button[@class='btn btn-primary']")
	WebElement editNewStaffButton;
	
	@FindBy(xpath="//table/tbody/tr[1]/td[2]")
	WebElement editedStaff;
	

	
	
	@FindBy(xpath="//table/tbody/tr[1]/td[1]/a")
	WebElement addedStaffId;
	
	@FindBy(css=".btn.btn-danger.btn-sm")
	WebElement deleteStaffButton;
	
	@FindBy(xpath="//form/div[2]/p")
	WebElement deleteStaffId;
	
	@FindBy(xpath="//div[@class='modal-footer']/button[@class='btn btn-danger']")
	WebElement deleteNewStaffButton;
	
	
	
	
	@FindBy(linkText=">")
	WebElement nextPage;
	
	@FindBy(linkText="<")
	WebElement prevPage;
	
	@FindBy(xpath="//table/tbody/tr[2]/td[1]/a")
	WebElement staffId;
	
	  @WhenPageOpens
	  public void waitUntilEntitiesLoad() {
		  System.out.println("I am waiting for Staff page to load");
	    $(".dropdown.pointer.ng-scope").waitUntilVisible();
	  }
	
	public void selectEntities(){
		entities.click();
	}
	
	public void staffLink(){
		staff.click();
	}
	
	/**
	 * Method to create a new staff information by passing name and branch details.
	 * @param name
	 * @param branch
	 */
	public void createStaff(String name, String branch){
		WebDriverWait wait = new WebDriverWait(this.getDriver(), 15);
		wait.until(ExpectedConditions.elementToBeClickable(newStaff)); 
		newStaff.click();
		System.out.println("I am inside new Staff");
		staffName.sendKeys(name);
		staffBranchDropDown.selectByVisibleText(branch);
		System.out.println("Staff Name"+name);
		System.out.println("Staff Branch"+branch);
	}
	
	public void saveStaffBtn(){
		WebDriverWait wait = new WebDriverWait(this.getDriver(), 15);
		wait.until(ExpectedConditions.elementToBeClickable(newStaffButton)); 
		newStaffButton.click();
	}
	
	public String getStaffName(){ 
		return addedStaffName.getText();
	}
	
	public String getStaffBranch(){ 
		return addedStaffBranch.getText();
	}
	
	
	/**
	 * Method to view a new staff information by passing name details.
	 * @param name
	 * @param branch
	 */
	
	public void viewStaff(){
		viewStaffButton.click();
	}
	
	public String getCheckStaffName(){ 
		return viewedStaffName.getAttribute("value");
	}
	
	public String getCheckStaffBranch(){ 
		return viewedStaffBranch.getAttribute("value");
	}
	
	public void getCheckStaffNameNonEditable(){
		viewedStaffName.getAttribute("readonly");
	}
	
	public void getCheckStaffBranchNonEditable(){
		viewedStaffBranch.getAttribute("readonly");
	}
	
	
	/**
	 * Method to edit a new staff information by passing name and branch details.
	 * @param name
	 * @param branch
	 */
	
	public void editStaff(String CheckStaffName, String CheckBranchName){
		editStaffButton.click();
	}
	
	public void newEditStaff(String editName, String editBranch){ 
		editStaffButton.click();
		//editStaffName.clear();
		editStaffName.sendKeys(editName);
	}
	
	public void editStaffBtn(){
		editNewStaffButton.click();
	}
	
	public void checkEditedStaff(String editedName, String editedBranch){ 
		editedStaff.getText().compareTo(editedName);
	}

	/**
	 * Method to delete a new staff information by passing name and branch details.
	 * @param name
	 * @param branch
	 */
	
	public String getDeleteStaffId(){ 
		return addedStaffId.getText();
	}
	
	public void deleteStaff(){
		deleteStaffButton.click();
	}
	
	public String getCheckStaffId(){ 
		return deleteStaffId.getAttribute("value");
	}
	
	
	public void deleteStaffBtn(){
		deleteNewStaffButton.click();
	}
	
	
	public String getCheckNewStaffId(){ 
		return deleteStaffId.getAttribute("value");
	}
	
	/**
	 * Method to pagination a new staff information.
	 * @param name
	 * @param branch
	 */
	
	public void clickNextPage(){
		nextPage.click();
	}
	
	public void clickPreviousPage(){
		prevPage.click();
	}
	
	public String getStaffId(){
		return staffId.getText(); 
	}

	
}
