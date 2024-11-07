import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.MobileCapabilityType;
import io.appium.java_client.remote.MobilePlatform;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.Select;

import java.net.MalformedURLException;
import java.net.URL;

public class selendroid {
    public static void main(String[] args) throws MalformedURLException, InterruptedException {
        DesiredCapabilities cap =new DesiredCapabilities();
        cap.setCapability("deviceName","Redmi 8");
        cap.setCapability("udid","140995fd0706");
        cap.setCapability("platformName","Android");
        cap.setCapability("platformVersion","10 QKQ1.191014.001");
       // cap.setCapability("app","C:\\Users\\riyazp\\dummy files\\selendroid-test-app-0.17.0 (1).apk");
       cap.setCapability("appPackage","io.selendroid.testapp");
      cap.setCapability("appActivity","io.selendroid.testapp.HomeScreenActivity");
        URL url=new URL("http://127.0.0.1:4723/wd/hub");
                AndroidDriver driver=new AndroidDriver(url,cap);
                Thread.sleep(2000);
                driver.findElement(By.id("com.android.permissioncontroller:id/continue_button")).click();
                Thread.sleep(4000);
                driver.findElement(By.id("android:id/button1")).click();
                driver.findElement(By.id("io.selendroid.testapp:id/waitingButtonTest")).click();
                Thread.sleep(15000);
                driver.findElement(By.id("io.selendroid.testapp:id/inputUsername")).sendKeys("riyazp");
                 driver.findElement(By.id("io.selendroid.testapp:id/inputEmail")).sendKeys("pinjar34@gmail.com");
                 driver.findElement(By.id("io.selendroid.testapp:id/inputPassword")).sendKeys("123456345");
                 Thread.sleep(3000);
        WebElement text = driver.findElement(By.id("io.selendroid.testapp:id/inputName"));
                   text.clear();
                 Thread.sleep(3000);
                 text.sendKeys("Riyazp");
                 Thread.sleep(3000);
                 driver.findElement(By.id("io.selendroid.testapp:id/input_preferedProgrammingLanguage")).click();
                 Thread.sleep(2000);
        driver.findElement(By.xpath("//android.widget.CheckedTextView[@text='Scala']")).click();
        Thread.sleep(3000);
        driver.findElement(By.id("io.selendroid.testapp:id/input_adds")).click();
        Thread.sleep(2000);
         driver.findElement(By.id("io.selendroid.testapp:id/btnRegisterUser")).click();
         Thread.sleep(2000);
        String xt = driver.findElement(By.id("io.selendroid.testapp:id/buttonRegisterUser")).getText();
        if(xt.contains("User"))
        {
            System.out.println("test case is pass");
        }
        else
        {
            System.out.println("test case is fail");
        }




    }
}
