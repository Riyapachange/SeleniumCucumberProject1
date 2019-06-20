package seleniumproject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

public class Login {
@Test
public void testDemoWebShopLogin()
{
	System.setProperty("webdriver.chrome.driver", "src/test/resources/chromedriver.exe");
WebDriver driver=new ChromeDriver();
driver.get("http://demowebshop.tricentis.com");
driver.manage().window().maximize();
driver.findElement(By.linkText("Log in")).click();
String title=driver.getTitle();
Assert.assertTrue(title.contains("Login"));
driver.findElement(By.id("Email")).sendKeys("askmail@email.com");
driver.findElement(By.id("Password")).sendKeys("abc123");
driver.findElement(By.cssSelector("input[value='Log in']")).click();
boolean flag=driver.findElement(By.linkText("Log out")).isDisplayed();
Assert.assertTrue(flag);
driver.findElement(By.linkText("Log out")).click();
driver.close();
}
}
