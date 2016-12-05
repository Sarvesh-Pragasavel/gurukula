package com.gurukula.steps;

import com.gurukula.HomePage;

import org.junit.Assert;

import com.gurukula.BranchPage;

import net.thucydides.core.annotations.Step;

public class BranchSteps {
	HomePage homePage;
	BranchPage branchPage;
	
	
	@Step
	public void selectEntities(){
		homePage.entitiesLink();
	}

	@Step
	public void selectBranch(){
		branchPage.branchLink();
	}
	
	@Step
	public void setBranchName(String name){
		branchPage.enterBranchName(name);
	}
	
	@Step
	public void setBranchCode(String code){
		branchPage.enterBranchCode(code);
	}
	
	@Step
	public void saveNewBranch(){
		branchPage.saveBranchBtn();
	}
	
	@Step
	public void verifyNewBranch(String savedName, String savedCode){
		Assert.assertEquals(savedName, branchPage.getBranchName());
		Assert.assertEquals(savedCode, branchPage.getBranchCode());
	}
	
	
	@Step
	public void viewNewBranch(String checkBranchName, String checkBranchCode){
		branchPage.viewBranch(checkBranchName, checkBranchCode);
	}
	
	@Step
	public void verifyViewBranch(String CheckBranchName, String CheckBranchCode){
		Assert.assertEquals(CheckBranchName, branchPage.getCheckBranchName());
		Assert.assertEquals(CheckBranchCode, branchPage.getCheckBranchCode());
	}
	
	@Step
	public void viewBranchNonEditable(String CheckBranchName, String CheckBranchCode){
		Assert.assertTrue("CheckBranchName NonEditable", branchPage.getCheckBranchNameNonEditable());
		Assert.assertTrue("CheckBranchCode NonEditable", branchPage.getCheckBranchCodeNonEditable());
	}
	
	@Step
	public void isBranchDetailsAvailable(String CheckBranchName, String CheckBranchCode) {
		Assert.assertTrue("Expected branch name is not available", branchPage.verifyBranch(CheckBranchName, CheckBranchCode));
	}
	
	@Step
	public void editBranchDetails(String editName, String editCode, String newName){
		branchPage.newEditBranch(editName, editCode, newName);
	}
	
	@Step
	public void saveEditBranch(){
		branchPage.editBranchBtn();
	}
	
	@Step
	public void deleteNewBranch(String CheckBranchName, String CheckBranchCode){
		branchPage.deleteBranch(CheckBranchName,CheckBranchCode);
	}
	
	@Step
	public void deleteBranch(){
		branchPage.deleteBranchBtn();
	}
	
	@Step
	public void verifyNewDeleteBranch(String CheckBranchName, String CheckBranchCode){
		Assert.assertTrue("Expected branch details is not deleted", branchPage.verifyDeletedBranchName(CheckBranchName, CheckBranchCode));
	}
	
	@Step
	public void searchBranchDetails(String editName){
		branchPage.newSearchBranch(editName);
	}
	
	@Step
	public void searchBranch(){
		branchPage.searchBranchBtn();
	}
	
	
}
