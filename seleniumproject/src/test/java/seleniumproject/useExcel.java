package seleniumproject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class useExcel {
	WebDriver driver;
	@BeforeClass
	public void beforeClass()
	{
		System.setProperty("webdriver.chrome.driver","src/test/resources/chromedriver.exe");
		driver=new ChromeDriver();
		driver.get("http://demowebshop.tricentis.com");
		driver.manage().window().maximize();
	}
	@AfterClass
	public void afterClass()
	{
		driver.close();
	}
	
	@Test(dataProvider="dp1")
	public void testDemoWebShopLogin(String username,String password,String status)
	{
		
		driver.findElement(By.linkText("Log in")).click();
		String title=driver.getTitle();
		Assert.assertTrue(title.contains("Login"));
		driver.findElement(By.id("Email")).sendKeys(username);
		driver.findElement(By.id("Password")).sendKeys(password);
		driver.findElement(By.cssSelector("input[value='Log in']")).click();
		boolean flag=driver.findElement(By.linkText("Log out")).isDisplayed();
		Assert.assertTrue(flag);
		driver.findElement(By.linkText("Log out")).click();
		
	}
	@DataProvider(name="dp1")
	public Object[][] getData()
	{
		return ReadExcel.readExcel("Sheet1");
	}



}
