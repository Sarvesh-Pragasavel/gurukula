package com.gurukula.stepDefinitions;

import java.util.Iterator;
import java.util.Map;
import java.util.Set;

import com.gurukula.steps.StaffSteps;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import net.serenitybdd.core.Serenity;
import net.thucydides.core.annotations.Steps;



public class StaffStepDefinitions {
	
	@Steps
	StaffSteps staffStep;
	
	@Given("^user selects staff page under Entities Menu$")
	public void user_is_in_Staff_page_under_Entities_Menu() {
		staffStep.selectEntities();
		staffStep.selectStaffMenu();
	}
	
	@When("^user fill in staff name as \"(.*?)\" and branch as \"(.*?)\"$")
	public void user_enters_Name_and_Branch_to_Create_a_new_Staff(String name, String branch) {
		Serenity.setSessionVariable("StaffName").to(name);
		Serenity.setSessionVariable("BranchName").to(branch);
		staffStep.newStaff(name, branch);
		staffStep.saveNewStaff();
	}
	
	@Then("^new staff information created successfully$")
	public void name_and_branch_are_sucessfuly_added_to_Staffs() {
		staffStep.isStaffDetailsAvailable(Serenity.sessionVariableCalled("StaffName").toString(),Serenity.sessionVariableCalled("BranchName").toString());
	}
	
	
	@Given("^staff name \"(.*?)\" , branch name \"(.*?)\" is displayed in Staff page$")
	public void already_has_added_Staff_information(String checkName, String checkBranch) {
		Serenity.setSessionVariable("CheckStaffName").to(checkName);
		Serenity.setSessionVariable("CheckStaffBranch").to(checkBranch);
		staffStep.isStaffDetailsAvailable(checkName, checkBranch);
	}
	
	@When("^user clicks on view button$")
	public void user_clicks_on_view_button() {
		staffStep.viewNewStaff(Serenity.sessionVariableCalled("CheckStaffName").toString(),Serenity.sessionVariableCalled("CheckStaffBranch").toString());
	}
	
	@Then("^the view page displays the staff information for the selected staff$")
	public void viewed_Staff_Details() {
		staffStep.verifyViewStaff(Serenity.sessionVariableCalled("CheckStaffName").toString(),Serenity.sessionVariableCalled("CheckStaffBranch").toString());	
	}
	
	@And("^the page should not be editable$")
	public void the_page_should_not_be_editable() {
		staffStep.viewStaffNonEditable(Serenity.sessionVariableCalled("CheckStaffName").toString(),Serenity.sessionVariableCalled("CheckStaffBranch").toString());
	}

	@When("^user tries to edit Staff information of \"(.*?)\" and \"(.*?)\" to \"(.*?)\"$")
	public void user_tries_to_edit_Staff_information_of_and_to(String name, String branch, String newName) throws Throwable {
		staffStep.editStaffDetails(name, branch, newName);
		staffStep.saveeditStaff();
	}
	
	@Then("^edited Staff \"(.*?)\" \"(.*?)\" returns in Name and Branch$")
	public void edited_Staff_returns_in_Name_and_Branch(String editedName, String editedBranch) throws Throwable {
		staffStep.isStaffDetailsAvailable(editedName, editedBranch);
	}
	
	@When("^user clicks on delete button$")
	public void user_clicks_on_delete_button() {
		staffStep.deleteNewStaff(Serenity.sessionVariableCalled("CheckStaffName").toString(),Serenity.sessionVariableCalled("CheckStaffBranch").toString());
		staffStep.deleteStaff();
	}
	
	@Then("^staff information deleted successfully$")
	public void staff_information_deleted_successfully() {
		staffStep.verifyNewDeleteStaff(Serenity.sessionVariableCalled("CheckStaffName").toString(),Serenity.sessionVariableCalled("CheckStaffBranch").toString());
	}
	
	
	@When("^user tries to search Staff information of \"(.*?)\"$")
	public void user_tries_to_search_Staff_information_of (String name) {
		staffStep.searchStaffDetails(name);
		staffStep.searchStaff();
	}
	
	@Then("^searched Staff \"(.*?)\" \"(.*?)\" returns in Name and Branch$")
	public void searched_Staff_returns_in_Name_and_Branch(String editedName, String editedBranch) throws Throwable {
		staffStep.isStaffDetailsAvailable(editedName, editedBranch);
	}
	
	
	@And("^staff page loaded with (\\d+) staff information$")
	public void staff_page_loaded_with_staff_information(int noOfStaff,Map<String,String> staffInfoMap){
		Set<String> itr = staffInfoMap.keySet();
		for(String key:itr){
			staffStep.newStaff(key,staffInfoMap.get(key));
			staffStep.saveNewStaff();
			
		}
	}
	
	
	@When("^user click on Next page$")
	public void user_click_on_next_page(){
		staffStep.nextPage();
	}
	
	@Then("^it loads staff information from (\\d+) onwards$")
	public void loads_staff_information_from_21_onwards(int staffCount){
		staffStep.validateNextPageStaffInfo(staffCount);
	}
	
	@When("^user click on previous page$")
	public void click_previous_page(){
		staffStep.prevPage();
	}
	
	@Then("^it loads staff information with first (\\d+) records$")
	public void loads_staff_information_first_twenty_record(int recordcount){
		 
	}
	

}
