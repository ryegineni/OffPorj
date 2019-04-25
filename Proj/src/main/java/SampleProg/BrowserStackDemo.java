package SampleProg;

import java.net.MalformedURLException;
import java.net.URL;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

public class BrowserStackDemo {

	public static void main(String[] args) throws MalformedURLException, InterruptedException {
		// TODO Auto-generated method stub
		String USERNAME = "ravi988";
		String AUTOMATE_KEY = "BVvRSQyswH9fQzPAF8bA";
		String URL = "https://" + USERNAME + ":" + AUTOMATE_KEY + "@hub-cloud.browserstack.com/wd/hub";

		DesiredCapabilities caps = new DesiredCapabilities();
		caps.setCapability("browser", "Chrome");
		caps.setCapability("browser_version", "70.0");
		caps.setCapability("os", "Windows");
		caps.setCapability("os_version", "10");
		caps.setCapability("resolution", "1024x768");

		WebDriver driver = new RemoteWebDriver(new URL(URL), caps);
		driver.get("http://www.google.com");
		WebElement element = driver.findElement(By.name("q"));

		element.click();
		Actions action = new Actions(driver);
		action.sendKeys("BrowserStack").build().perform();
		Thread.sleep(3000);
		System.out.println("Auto suggestion=" + driver.findElements(By.xpath("//div[@class='sbtc']")).get(2).getText());
		// element.sendKeys("BrowserStack");
		element.submit();

		System.out.println(driver.getTitle());

		driver.quit();

	}

	public void sleep(int waitInSec) {
		for (int i = 1; i <= waitInSec; i++) {
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
			}
		}
	}

}
