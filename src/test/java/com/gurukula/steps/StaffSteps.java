package com.gurukula.steps;

import net.thucydides.core.annotations.Step;

import org.junit.Assert;

import com.gurukula.HomePage;
import com.gurukula.StaffPage;

public class StaffSteps {
	
	HomePage homePage;
	StaffPage staffPage;
	
	
	@Step
	public void selectEntities(){
		homePage.entitiesLink();
	}

	@Step
	public void selectStaffMenu(){
		staffPage.staffLink();
	}
	
	/**
	 * 
	 * @param name
	 * @param branch
	 */
	
	@Step
	public void newStaff(String name, String branch){
		staffPage.createStaff(name, branch);
	}
	
	@Step
	public void saveNewStaff(){
		staffPage.saveStaffBtn();
	}
	
	@Step
	public void viewNewStaff(String CheckStaffName, String CheckStaffBranch){
		staffPage.viewStaff(CheckStaffName, CheckStaffBranch);
	}
	
	@Step
	public void verifyViewStaff(String CheckStaffName, String CheckStaffBranch){
		Assert.assertEquals(CheckStaffName, staffPage.getCheckStaffName());
		Assert.assertEquals(CheckStaffBranch, staffPage.getCheckStaffBranch());
	}
	
	@Step
	public void viewStaffNonEditable(String CheckStaffName, String CheckStaffBranch){
		Assert.assertNotNull(CheckStaffName);
		Assert.assertNotNull(CheckStaffBranch);
	}
	
	@Step
	public void editStaffDetails(String editName, String editBranch, String newName){
		staffPage.newEditStaff(editName, editBranch, newName);
	}
	
	@Step
	public void saveeditStaff(){
		staffPage.editStaffBtn();
	}
	
	@Step
	public void isStaffDetailsAvailable(String editedName, String editedBranch) {
		Assert.assertTrue("Expected staff name is not available", staffPage.verifyEditedStaffName(editedName, editedBranch));
	}
	
	@Step
	public void deleteNewStaff(String CheckStaffName, String CheckStaffBranch){
		staffPage.deleteStaff(CheckStaffName,CheckStaffBranch);
	}
	
	@Step
	public void deleteStaff(){
		staffPage.deleteStaffBtn();
	}
	
	@Step
	public void verifyNewDeleteStaff(String CheckStaffName, String CheckStaffBranch){
		Assert.assertTrue("Expected staff details is not deleted", staffPage.verifyDeletedStaffName(CheckStaffName, CheckStaffBranch));
	}
	
	@Step
	public void searchStaffDetails(String editName){
		staffPage.newSearchStaff(editName);
	}
	
	@Step
	public void searchStaff(){
		staffPage.searchStaffBtn();
	}
	
	@Step
	public void nextPage(){
		staffPage.clickNextPage(); 
	}
	
	@Step
	public void prevPage(){
		staffPage.clickPreviousPage(); 
	}
	
	@Step
	public void validateNextPageStaffInfo(int staffCount){
		Assert.assertTrue(Integer.valueOf(staffPage.getStaffId()) > 20);
	}

}
