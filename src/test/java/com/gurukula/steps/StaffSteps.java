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
	public void verifyNewStaff(String savedStaffName, String savedStaffBranch){
		Assert.assertEquals(savedStaffName, staffPage.getStaffName());
		Assert.assertEquals(savedStaffBranch, staffPage.getStaffBranch());
	}
	
	
	@Step
	public void viewNewStaff(){
		staffPage.viewStaff();
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
	
	/**
	 * 
	 * @param CheckStaffName
	 * @param CheckStaffBranch
	 */

	@Step
	public void editNewStaff(String CheckStaffName, String CheckStaffBranch){
		staffPage.editStaff(CheckStaffName, CheckStaffBranch);
	}
	
	@Step
	public void editStaff(String editName, String editBranch){
		staffPage.newEditStaff(editName, editBranch);
	}
	
	@Step
	public void saveeditStaff(){
		staffPage.editStaffBtn();
	}
	
	@Step
	public void verifyEditedStaff(String editedName, String editedBranch){
		staffPage.checkEditedStaff(editedName, editedBranch);
	}
	

	/**
	 * 
	 * @param staffID
	 */
	@Step
	public void verifyNewStaffId(int staffID){
		Assert.assertEquals(String.valueOf(staffID), staffPage.getDeleteStaffId());
	}
	
	@Step
	public void deleteNewStaff(){
		staffPage.deleteStaff();
	}
	
	@Step
	public void verifyDeleteStaff(String CheckStaffId){
		Assert.assertEquals(CheckStaffId, staffPage.getCheckStaffId());
	}
	
	@Step
	public void deleteStaff(){
		staffPage.deleteStaffBtn();
	}
	
	
	@Step
	public void verifyNewDeleteStaff(String CheckStaffId){
		Assert.assertEquals(CheckStaffId, staffPage.getCheckNewStaffId());
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
