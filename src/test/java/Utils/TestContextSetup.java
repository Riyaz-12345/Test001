package Utils;

import Pageobjects.PageObjectManager;
import org.openqa.selenium.WebDriver;

public class TestContextSetup {
     public WebDriver driver;
     public  String productName;
     public PageObjectManager pageObjectManager;
     public GenericUtils genericUtils;
     public TestContextSetup()
     {
          pageObjectManager=new PageObjectManager(driver);
          genericUtils=new GenericUtils(driver);
     }
}
