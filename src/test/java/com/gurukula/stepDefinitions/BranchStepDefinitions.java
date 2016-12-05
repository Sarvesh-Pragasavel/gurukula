package com.gurukula.stepDefinitions;

import com.gurukula.steps.BranchSteps;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import net.serenitybdd.core.Serenity;
import net.thucydides.core.annotations.Steps;

public class BranchStepDefinitions {
	
	@Steps
	BranchSteps branchStep;
	
	
	@Given("^user selects branch page under Entities Menu$")
	public void user_selects_branch_page_under_Entities_Menu() {
		branchStep.selectEntities();
		branchStep.selectBranch();
	}
	
	@When("^user fill in branch name as \"(.*?)\"$")
	public void user_fill_in_branch_name(String name) {
		Serenity.setSessionVariable("BranchNameDetail").to(name);
		branchStep.setBranchName(name);
	}
	
	@When("^user fill in branch code as \"(.*?)\"$")
	public void user_fill_in_branch_code(String code) {
		Serenity.setSessionVariable("BranchCode").to(code);
		branchStep.setBranchCode(code);
		branchStep.saveNewBranch();
	}
	
	@Then("^new branch is created sucessfully$")
	public void new_branch_is_created_successfully() {
		branchStep.verifyNewBranch(Serenity.sessionVariableCalled("BranchNameDetail").toString(),Serenity.sessionVariableCalled("BranchCode").toString());
	}
	
	@Given("^branch name \"(.*?)\" , branch code \"(.*?)\" is displayed in Branch page$")
	public void already_has_added_branch_information(String checkBranchName, String checkBranchCode) {
		Serenity.setSessionVariable("CheckBranchName").to(checkBranchName);
		Serenity.setSessionVariable("CheckBranchCode").to(checkBranchCode);
		branchStep.isBranchDetailsAvailable(checkBranchName, checkBranchCode);
	}
	
	@When("^user clicks on view branch button$")
	public void user_clicks_on_view_branch_button() {
		branchStep.viewNewBranch(Serenity.sessionVariableCalled("CheckBranchName").toString(),Serenity.sessionVariableCalled("CheckBranchCode").toString());
	}
	
	@Then("^the view page displays the branch information for the selected branch$")
	public void viewed_Branch_Details() {
		branchStep.verifyViewBranch(Serenity.sessionVariableCalled("CheckBranchName").toString(),Serenity.sessionVariableCalled("CheckBranchCode").toString());	
	}
	
	@And("^the branch view page should not be editable$")
	public void the_branch_view_page_should_not_be_editable() {
		branchStep.viewBranchNonEditable(Serenity.sessionVariableCalled("CheckBranchName").toString(),Serenity.sessionVariableCalled("CheckBranchCode").toString());
	}

	@When("^user tries to edit branch information of \"(.*?)\" and \"(.*?)\" to \"(.*?)\"$")
	public void user_tries_to_edit_branch_information_of_and_to(String name, String code, String newName) throws Throwable {
		branchStep.editBranchDetails(name, code, newName);
		branchStep.saveEditBranch();
	}
	
	@Then("^edited Branch \"(.*?)\" \"(.*?)\" returns in Name and Code$")
	public void edited_Branch_returns_in_Name_and_Code(String editedName, String editedCode){
		branchStep.isBranchDetailsAvailable(editedName, editedCode);
	}

	@When("^user clicks on delete button on branch$")
	public void user_clicks_on_delete_button_on_branch() {
		branchStep.deleteNewBranch(Serenity.sessionVariableCalled("CheckBranchName").toString(),Serenity.sessionVariableCalled("CheckBranchCode").toString());
		branchStep.deleteBranch();
	}
	
	@Then("^branch information deleted successfully$")
	public void branch_information_deleted_successfully() {
		branchStep.verifyNewDeleteBranch(Serenity.sessionVariableCalled("CheckBranchName").toString(),Serenity.sessionVariableCalled("CheckBranchCode").toString());
	}
	
	
	@When("^user tries to search branch information of \"(.*?)\"$")
	public void user_tries_to_search_branch_information_of (String name) {
		branchStep.searchBranchDetails(name);
		branchStep.searchBranch();
	}
	
	@Then("^searched Branch \"(.*?)\" \"(.*?)\" returns in Name and Code$")
	public void searched_Staff_returns_in_Name_and_Code(String deletedName, String deletedCode) {
		branchStep.isBranchDetailsAvailable(deletedName, deletedCode);
	}
	
}
