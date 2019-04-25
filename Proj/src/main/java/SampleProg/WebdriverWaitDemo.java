package SampleProg;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class WebdriverWaitDemo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	public boolean isElementPresent(WebDriver driver, WebElement elementName, int timeout) {
		try {
			WebDriverWait wait = new WebDriverWait(driver, timeout);
			wait.until(ExpectedConditions.visibilityOf(elementName));
			return true;
		} catch (Exception e) {
			return false;
		}

	}

}
