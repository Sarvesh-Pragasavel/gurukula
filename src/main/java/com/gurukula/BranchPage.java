package com.gurukula;

import java.util.List;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import net.serenitybdd.core.annotations.findby.By;
import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.core.pages.WebElementFacade;


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
		
	@FindBy(xpath = "//table[@class = 'table table-striped']")
	WebElementFacade table;
	
	@FindBy(xpath="//table/tbody/tr[1]/td[2]/input")
	WebElement viewedBranchName;
	
	@FindBy(xpath="//table/tbody/tr[2]/td[2]/input")
	WebElement viewedBranchCode;

	@FindBy(xpath="//input[@ng-model='branch.name']")
	WebElementFacade editBranchName;
	
	@FindBy(xpath="//div[@class='modal-footer']/button[@class='btn btn-primary']")
	WebElement editNewBranchButton;
	
	@FindBy(xpath="//div[@class='modal-footer']/button[@class='btn btn-danger']")
	WebElement deleteNewBranchButton;
	
	@FindBy(id ="searchQuery")
	WebElement searchText;
	
	@FindBy(css =".btn.btn-info")
	WebElement searchBranchButton;
	
	
	public void selectEntities(){
		entities.click();
	}
	
	public void branchLink(){
		branch.click();
	}
	
	/**
	 * Enter the branch name details to input box in create branch page.
	 * Wait for 15 seconds to load the branch page.
	 * @param name
	 */
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
	

	public void viewBranch(String CheckBranchName, String CheckBranchCode){
		boolean branchDetailsPresent = false;
		List<WebElement> rows = table.findElements(By.tagName("tr"));
		for(int i = 0; i < rows.size() && !branchDetailsPresent; i++) {
			if(rows.get(i).getText().contains(CheckBranchName) && rows.get(i).getText().contains(CheckBranchCode)) {
				branchDetailsPresent = true;
				rows.get(i).findElement(By.cssSelector(".btn.btn-info.btn-sm")).click();
			}
		}
	}
	
	public String getCheckBranchName(){ 
		return viewedBranchName.getAttribute("value");
	}
	
	public String getCheckBranchCode(){ 
		return viewedBranchCode.getAttribute("value");
	}
	
	public boolean getCheckBranchNameNonEditable(){
		return viewedBranchName.getAttribute("readonly").equals("true");
	}
	
	public boolean getCheckBranchCodeNonEditable(){
		return viewedBranchCode.getAttribute("readonly").equals("true");
	}
	
	public boolean verifyBranch(String CheckBranchName, String CheckBranchCode) {
		boolean branchDetailsPresent = false;
		List<WebElement> rows = table.findElements(By.tagName("tr"));
		for(int i = 0; i < rows.size() && !branchDetailsPresent; i++) {
			branchDetailsPresent = rows.get(i).getText().contains(CheckBranchName) && rows.get(i).getText().contains(CheckBranchCode);
		}
		return branchDetailsPresent;
	}
	
	
	public void newEditBranch(String editName, String editCode, String newName) {
		boolean branchDetailsPresent = false;
		List<WebElement> rows = table.findElements(By.tagName("tr"));
		for(int i = 0; i < rows.size() && !branchDetailsPresent; i++) {
			if(rows.get(i).getText().contains(editName) && rows.get(i).getText().contains(editCode)) {
				branchDetailsPresent = true;
				rows.get(i).findElement(By.cssSelector(".btn.btn-primary.btn-sm")).click();
			}
		}
		typeInto(editBranchName.findBy(By.xpath("//input[@ng-model='branch.name']")), newName);
	}
	
	public void editBranchBtn(){
		editNewBranchButton.click();
	}
	
	
	public void deleteBranch(String CheckBranchName, String CheckBranchCode){
		boolean branchDetailsPresent = false;
		List<WebElement> rows = table.findElements(By.tagName("tr"));
		for(int i = 0; i < rows.size() && !branchDetailsPresent; i++) {
			if(rows.get(i).getText().contains(CheckBranchName) && rows.get(i).getText().contains(CheckBranchCode)) {
				branchDetailsPresent = true;
				rows.get(i).findElement(By.cssSelector(".btn.btn-danger.btn-sm")).click();
			}
		}
	}
	
	public void deleteBranchBtn(){
		deleteNewBranchButton.click();
	}
	
	public boolean verifyDeletedBranchName(String CheckBranchName, String CheckBranchCode) {
		boolean branchDetailsPresent = false;
		List<WebElement> rows = table.findElements(By.tagName("tr"));
		for(int i = 0; i < rows.size() && !branchDetailsPresent; i++) {
			branchDetailsPresent = rows.get(i).getText().contains(CheckBranchName) && rows.get(i).getText().contains(CheckBranchCode);
		}
		return branchDetailsPresent;
	}
	
	
	public void newSearchBranch(String editName){ 
		searchText.sendKeys(editName);
	}
	
	
	public void searchBranchBtn(){
		searchBranchButton.click();
	}
	
}
