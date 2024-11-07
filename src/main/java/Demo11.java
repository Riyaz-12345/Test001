import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.FindBy;

import java.net.MalformedURLException;
import java.net.URL;

public class Demo11 {
     static AndroidDriver driver;
    public static void main(String[] args) throws MalformedURLException, InterruptedException
    {
        DesiredCapabilities cap1 = new DesiredCapabilities();
        cap1.setCapability("deviceName", "Redmi 8");
        cap1.setCapability("udid", "140995fd0706");
        cap1.setCapability("platformName", "Android");
        cap1.setCapability("platformVersion", "10 QKQ1.191014.001");
        cap1.setCapability("appPackage", "io.selendroid.testapp");
        cap1.setCapability("appActivity", "io.selendroid.testapp.HomeScreenActivity");
        URL url1 = new URL("http://127.0.0.1:4723/wd/hub");
        driver=new AndroidDriver(url1, cap1);
        Thread.sleep(4000);
        cool();
        popup();
        touch();

    }
    static  void cool() throws InterruptedException
    {

        driver.findElement(By.id("com.android.permissioncontroller:id/continue_button")).click();
        Thread.sleep(4000);
        driver.findElement(By.id("android:id/button1")).click();
        driver.findElement(By.id("io.selendroid.testapp:id/buttonStartWebview")).click();
        Thread.sleep(3000);
//
        WebElement element1 = driver.findElement(By.xpath("//android.widget.EditText[@resource-id='name_input']"));
        element1.click();
        Thread.sleep(2000);
              element1.clear();
              Thread.sleep(2000);
              element1.sendKeys("Riyaz");
        Thread.sleep(3000);
        driver.findElement(By.xpath("//android.view.View[@class='android.view.View']")).click();
        driver.findElement(By.xpath("//android.widget.CheckedTextView[@text='Mercedes']")).click();
        Thread.sleep(2000);
        driver.findElement(By.xpath("//android.widget.Button[@text='Send me your name!']")).click();
        Thread.sleep(2000);

        driver.findElement(By.id("io.selendroid.testapp:id/goBack")).click();
        Thread.sleep(4000);
        driver.findElement(By.id("io.selendroid.testapp:id/showToastButton")).click();




    }
    static void popup() throws InterruptedException {
        WebElement element2 = driver.findElement(By.id("io.selendroid.testapp:id/showPopupWindowButton"));
        element2.click();
        Thread.sleep(3000);
        element2.click();
        Thread.sleep(3000);





}
    static void touch()
    {
        driver.findElement(By.id("io.selendroid.testapp:id/buttonTest")).click();
        driver.findElement(By.xpath("//android.widget.Button[@text='I agree']")).click();
    }


}
