package SampleProg;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Platform;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.BrowserType;
import org.openqa.selenium.remote.DesiredCapabilities;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.MobileCapabilityType;

public class MobileBrowser {

	public static void main(String[] args) throws MalformedURLException {

		DesiredCapabilities capabilities = DesiredCapabilities.android();
		capabilities.setCapability(MobileCapabilityType.BROWSER_NAME, BrowserType.CHROME);
		capabilities.setCapability(MobileCapabilityType.PLATFORM, Platform.ANDROID);
		capabilities.setCapability(MobileCapabilityType.PLATFORM_NAME, "Android");
		capabilities.setCapability(MobileCapabilityType.DEVICE_NAME, "my phone");
		capabilities.setCapability(MobileCapabilityType.VERSION, "7.1.1");

		URL url = new URL("http://127.0.0.1:4723/wd/hub");

		WebDriver driver = new AndroidDriver<WebElement>(url, capabilities);

		driver.get("https://prometheus-book.appointment-plus.com/7gxt448e/");
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		System.out.println("Title " + driver.getTitle());
		driver.findElement(By.cssSelector(".navbar-toggle.collapsed")).click();

	}

}
