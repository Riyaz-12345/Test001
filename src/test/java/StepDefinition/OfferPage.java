package StepDefinition;

import Pageobjects.OfferPageObject;
import Pageobjects.PageObjectManager;
import Utils.TestContextSetup;
import io.cucumber.java.en.Then;

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
    @Then("user search with the same name in cart and extracted same name of the product")
    public void user_search_with_the_same_name_in_cart_and_extracted_same_name_of_the_product() throws InterruptedException {
        // Write code here that turns the phrase above into concrete actions

        Set<String> windows =this.testContextSetup.driver.getWindowHandles(); //[parentid,childid,subchildId]
        Iterator<String> it = windows.iterator();
        String parentId = it.next();
        String childId = it.next();
        this.testContextSetup.driver.switchTo().window(childId);
        OfferPageObject offering = new OfferPageObject(this.testContextSetup.driver);
        //OfferPageObject offerPage=new OfferPageObject( testContextSetup.driver);
        offering.searchProduct1();
        offering.getProduct();
        this.testContextSetup.driver.close();
        //Assert.assertTrue(testContextSetup.productName.contains(productName2));

    }




}
