package SampleProg;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class DynamicTable {

	public static void main(String[] args) throws InterruptedException {
		System.setProperty("webdriver.chrome.driver", "D:\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.get("https://dojotoolkit.org/documentation/tutorials/1.8/datagrid/demo/datagrid-simple.php");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.findElement(By.xpath("//*[@id=\"gridHdr0\"]")).click();
		Thread.sleep(3000);
		WebElement tableRowValue = driver.findElement(By.xpath("//table/tbody/tr/td[1]"));
		tableRowValue.click();
		WebElement tableRow = driver.findElement(By.cssSelector(".dojoxGridCell.dojoxGridCellFocus"));
		int i = 1;
		while (tableRow.isDisplayed()) {
			System.out.println("I value=" + i);
			// Thread.sleep(500);
			System.out.println(tableRow.getText());
			tableRow.sendKeys(Keys.ARROW_DOWN);
			tableRow = driver.findElement(By.cssSelector(".dojoxGridCell.dojoxGridCellFocus"));
			i++;
			if (i == 207) {
				break;
			}

		}

		driver.quit();

	}

}
