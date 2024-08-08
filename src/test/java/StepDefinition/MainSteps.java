package StepDefinition;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import java.util.List;

public class MainSteps {
    @Given("user is on subForm page")
    public void user_is_on_sub_form_page() {
        // Write code here that turns the phrase above into concrete actions
        System.out.println("user is on subForm page");
    }
    //parameterization
    @When("user fill the details {string} and {string}")
    public void user_fill_the_details_and(String userName, String password) {
        // Write code here that turns the phrase above into concrete actions
        System.out.println("username " +userName+ "  and password is "+password);
    } 
    // Data Driven Testing
   @When("user fill the all details")
   public void user_fill_the_all_details(List<String> data) {
       // Write code here that turns the phrase above into concrete actions
       // For automatic transformation, change DataTable to one o
       System.out.println(data.get(0));
       System.out.println(data.get(1));
       System.out.println(data.get(2));
       System.out.println(data.get(3));
       System.out.println(data.get(4));
   }
    @Then("success massage should be displayed")
    public void success_massage_should_be_displayed() {
        // Write code here that turns the phrase above into concrete actions
        System.out.println("success massage should be displayed");
    }
    @Given("user databse configuration")
    public void user_databse_configuration() {
        // Write code here that turns the phrase above into concrete actions
        System.out.println("user credentials in database");
    }
    @When("user launch the browser")
    public void user_launch_the_browser() {
        // Write code here that turns the phrase above into concrete actions
        System.out.println("user launched the browser");

    }
    @Then("user submit form page should be displayed")
    public void user_submit_form_page_should_be_displayed() {
        // Write code here that turns the phrase above into concrete actions
        System.out.println("user will be in the submit form page");

    }
}
