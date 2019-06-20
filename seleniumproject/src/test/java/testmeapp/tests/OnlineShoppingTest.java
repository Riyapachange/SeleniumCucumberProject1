package testmeapp.tests;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
 import org.openqa.selenium.WebDriver;
 import org.openqa.selenium.chrome.ChromeDriver;
 import org.openqa.selenium.interactions.Actions;
 import org.openqa.selenium.interactions.ClickAction;
 import org.testng.annotations.AfterMethod;
 import org.testng.annotations.AfterTest;
 import org.testng.annotations.BeforeTest;
 import org.testng.annotations.Test;

import com.utility.Drivers;



 public class OnlineShoppingTest {
  WebDriver driver;
  Actions act;

 
  /*@Test(priority=1)
  public void testRegistration()
  {
   

  driver.findElement(By.linkText("SignUp")).click();
   driver.findElement(By.id("userName")).sendKeys("ebi12345789");
   driver.findElement(By.id("firstName")).sendKeys("Ebinezar");
   driver.findElement(By.id("lastName")).sendKeys("mikkili");
   driver.findElement(By.id("password")).sendKeys("ebi123");
   driver.findElement(By.id("pass_confirmation")).sendKeys("ebi123");
   driver.findElement(By.id("gender")).click();
   driver.findElement(By.id("emailAddress")).sendKeys("ebi12345@gmail.com");
   driver.findElement(By.id("mobileNumber")).sendKeys("9652692976");
   driver.findElement(By.id("dob")).sendKeys("04/03/1990");
   driver.findElement(By.id("address")).sendKeys("banglorebanglore");
   driver.findElement(By.id("securityQuestion")).isSelected();
   driver.findElement(By.id("answer")).sendKeys("Ebi");
   driver.findElement(By.cssSelector("input[value='Register']")).click();
   
  }*/
  @Test(priority=1)
  public void testLogin()
  {
   
   driver.findElement(By.linkText("SignIn")).click();
   driver.findElement(By.id("userName")).sendKeys("seema5180");
   driver.findElement(By.id("password")).sendKeys("abc123");
   driver.findElement(By.cssSelector("input[value='Login']")).click();
  }
  @Test(priority=2)
  public void testCart()
  { 
   driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    act=new Actions(driver);
   act.moveToElement(driver.findElement(By.partialLinkText("All Categories"))).perform();
   act.click(driver.findElement(By.partialLinkText("Electronics"))).perform();
   act.click(driver.findElement(By.partialLinkText("Head Phone"))).perform();
   act.click(driver.findElement(By.partialLinkText("Add to cart"))).perform();

 }
  @Test(priority=3)
  public void testPayment()
  {
   driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
   act.click(driver.findElement(By.partialLinkText("Cart"))).perform();
   act.click(driver.findElement(By.partialLinkText("Checkout"))).perform();
   //driver.findElement(By.id("Shipping Address")).sendKeys("dghewiouyfgweklyfcgl");
   act.click(driver.findElement(By.cssSelector("input[value='Proceed to Pay']"))).perform();
  }
  @AfterTest
  public void endReportAfterTest()
  {
  driver.close();
  }
  @BeforeTest
  public void startReportBeforeTest()
  {
   driver=Drivers.getDriver("chrome");
   driver.get("http://10.232.237.143:443/TestMeApp/fetchcat.htm");
  }
  @AfterMethod 
  public void getResultAfterMethod()
  {
  
  }
 }
