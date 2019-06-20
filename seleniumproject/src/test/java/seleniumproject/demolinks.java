package seleniumproject;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

public class demolinks {
	@Test
	public void demoptest()
	{

	System.setProperty("webdriver.chrome.driver", "src/test/resources/chromedriver.exe");
	WebDriver driver=new ChromeDriver();
	driver.get("https://www.google.co.in");
	driver.manage().window().maximize();

	WebElement div=driver.findElement(By.id("SIvCob"));
	List<WebElement> list= div.findElements(By.tagName("a"));
	Assert.assertEquals(list.size(), 9);
	}
}
