import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.net.MalformedURLException;
import java.net.URL;

public class Lio {
    static AndroidDriver driver;

    public static void main(String[] args) throws MalformedURLException, InterruptedException {
        DesiredCapabilities cap1 = new DesiredCapabilities();
        cap1.setCapability("deviceName", "Redmi 8");
        cap1.setCapability("udid", "140995fd0706");
        cap1.setCapability("platformName", "Android");
        cap1.setCapability("platformVersion", "10 QKQ1.191014.001");
        cap1.setCapability("appPackage", "com.swific.registerbook");
        cap1.setCapability("appActivity", "com.swific.registerbook.MainActivity");
        URL url1 = new URL("http://127.0.0.1:4723/wd/hub");
        driver = new AndroidDriver(url1, cap1);
        Thread.sleep(5000);

        driver.findElement(By.xpath("//android.widget.TextView[@text='English']/following-sibling::android.view.ViewGroup")).click();
        driver.findElement(By.xpath("//android.widget.TextView[@text,'SIGN UP WITH MOBILE NUMBER']")).click();
        Thread.sleep(2000);
        driver.findElement(By.xpath("//android.widget.EditText[contains(@text='Number')]")).sendKeys("7337790580");

}}
