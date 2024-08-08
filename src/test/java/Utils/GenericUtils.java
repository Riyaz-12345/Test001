package Utils;

import org.openqa.selenium.WebDriver;

import java.util.Iterator;
import java.util.Set;

public class GenericUtils {
    WebDriver driver;
    public GenericUtils(WebDriver driver)
    {
        this.driver=driver;
    }

    public void switchToOfferPage()
    {
        Set<String> windows =driver.getWindowHandles(); //[parentid,childid,subchildId]
        Iterator<String> it = windows.iterator();
        String parentId = it.next();
        String childId = it.next();
        driver.switchTo().window(childId);
    }
}
