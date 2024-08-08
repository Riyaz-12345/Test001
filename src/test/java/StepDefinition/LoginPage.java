package StepDefinition;

import Pageobjects.LoginPageObject;
import Pageobjects.PageObjectManager;
import Utils.TestContextSetup;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.Assert;

import java.util.Iterator;
import java.util.Set;

public class LoginPage {
     TestContextSetup testContextSetup;
    WebDriver driver;
    public  String productName;
    PageObjectManager pageObjectManager;


    public LoginPage(TestContextSetup testContextSetup)
    {
        this.testContextSetup=testContextSetup;
    }

    @Given("user is on greenkart page")
    public void user_is_on_greenkart_page() {
        // Write code here that turns the phrase above into concrete actions
        System.setProperty("webdriver.chrome.driver", "C://Users/riyazp/Downloads/chromedriver-win64/chromedriver-win64/chromedriver.exe");
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--remote-debugging-port=9222");
        testContextSetup.driver = new ChromeDriver(options);
        testContextSetup.driver.manage().window().maximize();
        testContextSetup.driver.get("https://rahulshettyacademy.com/seleniumPractise/#/");

    }

    @When("user searched with shortname {string} and extracted actual name of the product")
    public void user_searched_with_shortname_and_extracted_actual_name_of_the_product(String shortname) {
        // Write code here that turns the phrase above into concrete
        LoginPageObject loginpage = new LoginPageObject(testContextSetup.driver);
        //LoginPageObject loginPage=new LoginPageObject(testContextSetup.driver);
        loginpage.searchItem(shortname);
        loginpage.getText();
        loginpage.getProductName();
        loginpage.click();

    }
}
