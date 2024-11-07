import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.net.MalformedURLException;
import java.net.URL;

public class Calculater {
    public static void main(String[] args) throws MalformedURLException, InterruptedException {
        DesiredCapabilities cap =new DesiredCapabilities();
        cap.setCapability("deviceName","Redmi 8");
        cap.setCapability("udid","140995fd0706");
        cap.setCapability("platformName","Android");
        cap.setCapability("platformVersion","10 QKQ1.191014.001");
        cap.setCapability("appPackage","com.miui.calculator");
        cap.setCapability("appActivity","com.miui.calculator.cal.CalculatorActivity");
        URL url=new URL("http://127.0.0.1:4723/wd/hub");
        AndroidDriver driver=new AndroidDriver(url,cap);


                      driver.findElement(By.id("android:id/button1")).click();
           driver.navigate().back();
               Thread.sleep(2000);
                //driver.findElement(By.id("com.miui.calculator:id/btn_c_s")).click();
               driver.findElement(By.id("com.miui.calculator:id/btn_8_s")).click();
               driver.findElement(By.id("com.miui.calculator:id/btn_plus_s")).click();
               driver.findElement(By.id("com.miui.calculator:id/btn_7_s")).click();
               driver.findElement(By.id("com.miui.calculator:id/btn_equal_s")).click();
       String sr = driver.findElement(By.id("com.miui.calculator:id/result")).getText();
       System.out.println(sr);

}}
