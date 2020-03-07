package qtx;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;


public class TestSuperClass {
	  protected WebDriver driver;
	  
	  protected String BaseUrl;
	  
	  @BeforeTest
	  public void beforeTest() {
		  driver = DriverManagerFactory.getManager(DriverType.CHROME).getDriver();
		  BaseUrl = "http://the-internet.herokuapp.com";
	  }

	  @AfterTest
	  public void afterTest() {
		  driver.quit();
	  }
}