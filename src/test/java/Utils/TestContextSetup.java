package Utils;

import Pageobjects.PageObjectManager;
import org.openqa.selenium.WebDriver;

public class TestContextSetup {
     public WebDriver driver;
     public  String productName;
     public PageObjectManager pageObjectManager;
     public  TestBase testBase;
     public GenericUtils genericUtils;
     public TestContextSetup()
     {
          testBase=new TestBase();
          pageObjectManager=new PageObjectManager(testBase.webDriver());
          genericUtils=new GenericUtils(testBase.webDriver());
     }
}
