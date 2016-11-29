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
	
	
}
