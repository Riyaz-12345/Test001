package Pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class OfferPageObject {
    WebDriver driver;
    public OfferPageObject(WebDriver driver)
    {

        this.driver=driver;
    }
    By search=By.xpath("//input[@type='search']");
    By product=By.xpath("//td[text()='Tomato']");
    public void searchProduct1()
    {
        driver.findElement(search).sendKeys("tom");


    }
    public String getProduct()
    {

        return driver.findElement(product).getText();
    }


}
