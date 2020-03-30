package frameworks;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

import frameworks.DriverManagerFactory;
import frameworks.DriverType;


public class TestSuperClass {
	  protected WebDriver driver;
	  
	  protected String BaseUrl;
	  
	  @BeforeTest
	  public void beforeTest() {
		  driver = DriverManagerFactory.getManager(DriverType.CHROME).getDriver();
		  BaseUrl = "http://the-internet.herokuapp.com";
		  driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
	  }

	  @AfterTest
	  public void afterTest() {
		  if(driver != null) {
				driver.quit();
			}
	  }
}