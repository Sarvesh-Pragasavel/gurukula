package com.gurukula;

import java.util.List;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import net.serenitybdd.core.annotations.findby.By;
import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.core.pages.WebElementFacade;
import net.thucydides.core.annotations.WhenPageOpens;


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
	
	@FindBy(xpath = "//table[@class = 'table table-striped']")
	WebElementFacade table;
	
	@FindBy(xpath="//table/tbody/tr[1]/td[3]")
	WebElement addedStaffBranch;
	
	@FindBy(css=".btn.btn-info.btn-sm")
	WebElement viewStaffButton;
	
	@FindBy(xpath="//table/tbody/tr[1]/td[2]/input")
	WebElement viewedStaffName;
	
	@FindBy(xpath="//table/tbody/tr[2]/td[2]/input")
	WebElement viewedStaffBranch;
	
	@FindBy(xpath="//input[@ng-model='staff.name']")
	WebElementFacade editStaffName;
	
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
	
	@FindBy(id ="searchQuery")
	WebElement searchText;
	
	@FindBy(css =".btn.btn-info")
	WebElement searchStaffButton;
	
	@FindBy(linkText=">")
	WebElement nextPage;
	
	@FindBy(linkText="<")
	WebElement prevPage;
	
	@FindBy(xpath="//table/tbody/tr[2]/td[1]/a")
	WebElement staffId;
	
	  @WhenPageOpens
	  public void waitUntilEntitiesLoad() {
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
		staffName.sendKeys(name);
		staffBranchDropDown.selectByVisibleText(branch);
	}
	
	public void saveStaffBtn(){
		WebDriverWait wait = new WebDriverWait(this.getDriver(), 15);
		wait.until(ExpectedConditions.elementToBeClickable(newStaffButton)); 
		newStaffButton.click();
	}
	
	public boolean verifyStaff(String savedStaffName, String savedStaffBranch) {
		boolean flag = false;
		List<WebElement> rows = table.findElements(By.tagName("tr"));
		for(int i = 0; i < rows.size() && !flag; i++) {
			flag = rows.get(i).getText().contains(savedStaffName) && rows.get(i).getText().contains(savedStaffBranch);
		}
		return flag;
	}
	
	
	/**
	 * Method to view a new staff information by passing name details.
	 * @param name
	 * @param branch
	 */
	
	public void viewStaff(String CheckStaffName, String CheckStaffBranch){
		boolean staffDetailsPresent = false;
		List<WebElement> rows = table.findElements(By.tagName("tr"));
		for(int i = 0; i < rows.size() && !staffDetailsPresent; i++) {
			if(rows.get(i).getText().contains(CheckStaffName) && rows.get(i).getText().contains(CheckStaffBranch)) {
				staffDetailsPresent = true;
				rows.get(i).findElement(By.cssSelector(".btn.btn-info.btn-sm")).click();
			}
		}
	}
	
	public String getCheckStaffName(){ 
		return viewedStaffName.getAttribute("value");
	}
	
	public String getCheckStaffBranch(){ 
		return viewedStaffBranch.getAttribute("value");
	}
	
	public boolean getCheckStaffNameNonEditable(){
		return viewedStaffName.getAttribute("readonly").equals("true");
	}
	
	public boolean getCheckStaffBranchNonEditable(){
		return viewedStaffBranch.getAttribute("readonly").equals("true");
	}
	
	public void newEditStaff(String editName, String editBranch, String newName) {
		boolean staffDetailsPresent = false;
		List<WebElement> rows = table.findElements(By.tagName("tr"));
		for(int i = 0; i < rows.size() && !staffDetailsPresent; i++) {
			if(rows.get(i).getText().contains(editName) && rows.get(i).getText().contains(editBranch)) {
				staffDetailsPresent = true;
				rows.get(i).findElement(By.cssSelector(".btn.btn-primary.btn-sm")).click();
			}
		}
		typeInto(editStaffName.findBy(By.xpath("//input[@ng-model='staff.name']")), newName);
	}
	
	public void editStaffBtn(){
		editNewStaffButton.click();
	}
	
	public boolean verifyEditedStaffName(String editedName, String editedBranch) {
		boolean staffDetailsPresent = false;
		List<WebElement> rows = table.findElements(By.tagName("tr"));
		for(int i = 0; i < rows.size() && !staffDetailsPresent; i++) {
			staffDetailsPresent = rows.get(i).getText().contains(editedName) && rows.get(i).getText().contains(editedBranch);
		}
		return staffDetailsPresent;
	}
	
	/**
	 * Method to delete a new staff information by passing name and branch details.
	 * @param name
	 * @param branch
	 */
	
	public void deleteStaff(String CheckStaffName, String CheckStaffBranch){
		boolean staffDetailsPresent = false;
		List<WebElement> rows = table.findElements(By.tagName("tr"));
		for(int i = 0; i < rows.size() && !staffDetailsPresent; i++) {
			if(rows.get(i).getText().contains(CheckStaffName) && rows.get(i).getText().contains(CheckStaffBranch)) {
				staffDetailsPresent = true;
				rows.get(i).findElement(By.cssSelector(".btn.btn-danger.btn-sm")).click();
			}
		}
	}
	
	public void deleteStaffBtn(){
		deleteNewStaffButton.click();
	}
	
	public boolean verifyDeletedStaffName(String CheckStaffName, String CheckStaffBranch) {
		boolean staffDetailsNotPresent = false;
		List<WebElement> rows = table.findElements(By.tagName("tr"));
		for(int i = 0; i < rows.size() && !staffDetailsNotPresent; i++) {
			staffDetailsNotPresent = rows.get(i).getText().contains(CheckStaffName) && rows.get(i).getText().contains(CheckStaffBranch);
		}
		return staffDetailsNotPresent;
	}
	
	
	public void newSearchStaff(String editName){ 
		searchText.sendKeys(editName);
	}
	
	
	public void searchStaffBtn(){
		searchStaffButton.click();
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
