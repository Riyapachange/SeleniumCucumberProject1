package seleniumproject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

public class newsel1 {
	@Test
public void testGoogleHomepage()
{
		System.setProperty("webdriver.chrome.driver", 
				"C:\\Users\\training_b6b.01.09\\eclipse-workspace\\Riya\\seleniumproject\\src\\test\\resources\\chromedriver.exe");
WebDriver driver=new ChromeDriver();
driver.get("http://www.google.co.in/");
driver.manage().window().maximize();
String title=driver.getTitle();
Assert.assertEquals(title, "Google");
}
}
