package org.example;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class MyStcpDefs {
    HomePage homePage = new HomePage();
    RegistrationPage registrationPage = new RegistrationPage();
    RegistrationSuccesPage registrationSuccesPage = new RegistrationSuccesPage();

    @Given("I am on registration page")
    public void i_am_on_registration_page() {
        // Write code here that turns the phrase above into concrete actions
      homePage.clickOnRegisterButton();
    }
    @Then("I enter required registration details")
    public void i_enter_required_registration_details() {
        // Write code here that turns the phrase above into concrete actions
        registrationPage.userRegistrationDetails();

    }
    @Then("I click on register submit button")
    public void i_click_on_register_submit_button() {
        // Write code here that turns the phrase above into concrete actions
        registrationPage.clickOnRegistrationButton();
    }
    @Then("I should able to registered successfully")
    public void i_should_able_to_registered_successfully() {
        // Write code here that turns the phrase above into concrete actions
        registrationSuccesPage.clickOnContinueButton();

    }
    @Then("I should be logged in")
    public void i_should_be_logged_in() {
        // Write code here that turns the phrase above into concrete actions
    }

    @When("I click on {string} link from top menu header")
    public void i_click_on_link_from_top_menu_header(String category_name) {
        // Write code here that turns the phrase above into concrete actions
        homePage.clickOnCategoryLink(category_name);

    }
    @Then("I should be able to successfully navigate to related {string} with same category name")
    public void i_should_be_able_to_successfully_navigate_to_related_with_same_category_name(String category_url) {
        // Write code here that turns the phrase above into concrete actions
        Utils.verifyCurrentURL(category_url);
    }



}
