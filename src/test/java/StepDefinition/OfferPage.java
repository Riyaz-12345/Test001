package StepDefinition;

import Pageobjects.OfferPageObject;
import Pageobjects.PageObjectManager;
import Utils.TestContextSetup;
import io.cucumber.java.en.Then;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

import java.util.Iterator;
import java.util.Set;


public class OfferPage {
    public OfferPage(TestContextSetup testContextSetup)
    {

        this.testContextSetup=testContextSetup;
    }
    PageObjectManager pageObjectManager;
    String productName2;
    TestContextSetup testContextSetup;
    @Then("user searched with the same name in cart and extracted same name of the product")
    public void user_searched_with_the_same_name_in_cart_and_extracted_same_name_of_the_product() throws InterruptedException {
        // Write code here that turns the phrase above into concrete actions
        switchTo();
        OfferPageObject offering = new OfferPageObject(testContextSetup.driver);
       // OfferPageObject offerPage=new OfferPageObject( testContextSetup.driver);
        offering.searchProduct1();
        offering.getProduct();
        //Assert.assertTrue(testContextSetup.productName.contains(productName2));

    }
    public void switchTo()
    {
        testContextSetup.genericUtils.switchToOfferPage();
    }



}
