package SampleProg;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.MobileCapabilityType;

public class TVLKDemo {

	@SuppressWarnings("deprecation")
	public static void main(String[] args) throws InterruptedException {
		AppiumDriver<WebElement> driver = null;
		DesiredCapabilities capabilities = null;
		capabilities = new DesiredCapabilities();
		capabilities.setCapability(MobileCapabilityType.AUTOMATION_NAME, "uiautomator2");
		capabilities.setCapability(MobileCapabilityType.PLATFORM, "Android");
		capabilities.setCapability("deviceName", "emulator-5554");
		capabilities.setCapability("platformVersion", "7.1.1");
		// capabilities.setCapability("App", readProperty("APK"));
		capabilities.setCapability("appPackage", "com.traveloka.android.staging");
		capabilities.setCapability("appActivity", "com.traveloka.android.appentry.splash.SplashActivity");

		try {
			driver = new AndroidDriver<WebElement>(new URL("http://127.0.0.1:4723/wd/hub"), capabilities);
			Set<String> context = driver.getContextHandles();
			System.out.println("Available contexts=" + context);
		} catch (MalformedURLException e) {
			e.printStackTrace();
		}
		Thread.sleep(10000);
		driver.findElement(By.xpath("//*[@text=\"Continue\"]")).click();
	}

}
