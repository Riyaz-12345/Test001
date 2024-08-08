package Pageobjects;

import org.openqa.selenium.WebDriver;

public class PageObjectManager {
    public LoginPageObject loginPageObject;
    public OfferPageObject offerpageObject;
    public WebDriver driver;
    public PageObjectManager(WebDriver driver)
    {
        this.driver=driver;
    }
    public LoginPageObject getLandPage()
    {
        loginPageObject= new LoginPageObject(driver);
        return loginPageObject;

    }
    public OfferPageObject offerPage()
    {
        offerpageObject=new OfferPageObject(driver);
        return offerpageObject;
    }


}
