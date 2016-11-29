package com.gurukula.stepDefinitions;

import com.gurukula.steps.BranchSteps;

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
	

	

}
