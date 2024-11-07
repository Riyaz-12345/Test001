import com.sun.scenario.effect.impl.sw.sse.SSEBlend_SRC_OUTPeer;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

public class flipkart {
    static AndroidDriver driver;

    public static void main(String[] args) throws MalformedURLException, InterruptedException {
        DesiredCapabilities cap1 = new DesiredCapabilities();
        cap1.setCapability("deviceName", "Redmi 8");
        cap1.setCapability("udid", "140995fd0706");
        cap1.setCapability("platformName", "Android");
        cap1.setCapability("platformVersion", "10 QKQ1.191014.001");
        cap1.setCapability("appPackage", "com.flipkart.android");
        cap1.setCapability("appActivity", "com.flipkart.android.SplashActivity");
        URL url1 = new URL("http://127.0.0.1:4723/wd/hub");
        driver = new AndroidDriver(url1, cap1);
        Thread.sleep(5000);
        login();
    }
    static void login() throws InterruptedException {
       // driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.findElement(By.xpath("//android.widget.TextView[@text='English']/../../android.widget.ImageView")).click();
        driver.findElement(By.id("com.flipkart.android:id/select_btn")).click();
        Thread.sleep(10000);
        //driver.navigate().back();
        //Thread.sleep(2000);
        driver.findElement(By.id("com.flipkart.android:id/custom_back_icon")).click();
        Thread.sleep(4000);
        driver.findElement(By.xpath("//android.widget.TextView[@text='Search for products']")).click();
        Thread.sleep(1000);
        driver.findElement(By.xpath("//android.widget.EditText[@text='Search for Products, Brands and More']")).sendKeys("leather jackets");
        Thread.sleep(3000);
        driver.findElement(By.xpath("//android.widget.TextView[@text='leather jackets black for men']")).click();
        Thread.sleep(2000);
        driver.findElement(By.id("com.flipkart.android:id/allow_button")).click();
        Thread.sleep(3000);
        driver.findElement(By.id("com.android.permissioncontroller:id/permission_allow_foreground_only_button")).click();
        Thread.sleep(3000);
        driver.findElement(By.xpath("//android.widget.TextView[@text='Roadster']")).click();
        Thread.sleep(1000);
        driver.findElement(By.xpath("//android.widget.TextView[@text='Add to cart']/..")).click();
        Thread.sleep(3000);
        driver.findElement(By.xpath("//android.widget.TextView[@text='XL']")).click();
        Thread.sleep(1000);
        driver.findElement(By.xpath("//android.widget.TextView[@text='Continue']/..")).click();
        Thread.sleep(4000);
        driver.findElement(By.xpath("//android.widget.TextView[@text='Go to cart']/..")).click();
        Thread.sleep(5000);

    }
}