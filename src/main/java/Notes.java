import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.net.MalformedURLException;
import java.net.URL;

public class Notes {
    public static void main(String[] args) throws MalformedURLException, InterruptedException {
        DesiredCapabilities cap =new DesiredCapabilities();
        cap.setCapability("deviceName","Redmi 8");
        cap.setCapability("udid","140995fd0706");
        cap.setCapability("platformName","Android");
        cap.setCapability("platformVersion","10 QKQ1.191014.001");
        // cap.setCapability("app","C:\\Users\\riyazp\\dummy files\\selendroid-test-app-0.17.0 (1).apk");
        cap.setCapability("appPackage","com.application.zomato");
        cap.setCapability("appActivity","com.application.zomato.zomatoWallet.rechargeCart.bottomSheet.ZWalletCartBottomSheetActivity");
        URL url=new URL("http://127.0.0.1:4723/wd/hub");
        AndroidDriver driver=new AndroidDriver(url,cap);
        driver.findElement(By.id("com.miui.notes:id/content_add")).click();

}}
