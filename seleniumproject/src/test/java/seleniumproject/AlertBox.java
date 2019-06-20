package seleniumproject;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.annotations.Test;

public class AlertBox {
	@Test
	public void alerts()
	{
	System.setProperty("webdriver.chrome.driver", "src/test/resources/chromedriver.exe");
	WebDriver driver=new ChromeDriver();
	driver.get("http://10.232.237.143:443/TestMeApp");
	driver.manage().window().maximize();
	driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	driver.findElement(By.cssSelector("input[value='FIND DETAILS']")).click();
	if(ExpectedConditions.alertIsPresent()!=null) //if there is alert box
	{
	Alert al=driver.switchTo().alert();
	String message=al.getText();
	System.out.println(message);
	Assert.assertEquals(message,"Please enter some product name");
	al.accept();
	}
}
}
