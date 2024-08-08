package Pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPageObject {
    WebDriver driver;
    public LoginPageObject(WebDriver driver)
    {
        this.driver=driver;
    }

    By search=By.xpath("//input[@type='search']");
    By productName=By.xpath("//h4[text()='Tomato - 1 Kg']");
    By topDeals=By.xpath("//a[text()='Top Deals']");
    public void searchItem(String shortname)
    {
        driver.findElement(search).sendKeys(shortname);
    }
    public void getText()
    {
        driver.findElement(search).getText();
    }
    public String getProductName()
    {
       return driver.findElement(productName).getText();
    }
    public void click()
    {
        driver.findElement(topDeals).click();
    }



}
