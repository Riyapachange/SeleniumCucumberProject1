

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

public class Register {
	@Test
	public void testDemoWebShopRegister()
	{
		System.setProperty("webdriver.chrome.driver", "src/test/resources/chromedriver.exe");
		WebDriver driver=new ChromeDriver();
		driver.get("http://demowebshop.tricentis.com");
		driver.manage().window().maximize();
		driver.findElement(By.linkText("Register")).click(); 
		String title=driver.getTitle();
		Assert.assertTrue(title.contains("Register"));
		driver.findElement(By.id("gender-female")).click();
		driver.findElement(By.id("FirstName")).sendKeys("Riya");
		driver.findElement(By.id("LastName")).sendKeys("P");
		driver.findElement(By.id("Email")).sendKeys("Riya@12.com");
		driver.findElement(By.id("Password")).sendKeys("abc123");
		driver.findElement(By.id("ConfirmPassword")).sendKeys("abc123");
		driver.findElement(By.cssSelector("input[value='Register']")).click();
		boolean flag=driver.findElement(By.linkText("Log out")).isDisplayed();
		Assert.assertTrue(flag);
		driver.findElement(By.linkText("Log out")).click();
		driver.close();
	}
}
