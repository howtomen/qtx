package frameworks;

import java.util.concurrent.TimeUnit;


import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import frameworks.DriverManagerFactory;
import frameworks.DriverType;

public class TestSuperClass {
	protected WebDriver driver;

	protected String BaseUrl;

	@Parameters("browser")
	@BeforeClass
	public void beforeTest(String browser) {
		if (browser.equalsIgnoreCase("chrome")) {
			driver = DriverManagerFactory.getManager(DriverType.CHROME).getDriver();
			BaseUrl = "http://the-internet.herokuapp.com";
			driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		}
		if (browser.equalsIgnoreCase("firefox")) {
			driver = DriverManagerFactory.getManager(DriverType.FIREFOX).getDriver();
			BaseUrl = "http://the-internet.herokuapp.com";
			driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		}

	}

	@Parameters("browser")
	@AfterClass
	public void afterTest(String browser) {
		if (browser.equalsIgnoreCase("chrome")) {
			if (driver != null) {
				driver.quit();
			}
		}
		if (browser.equalsIgnoreCase("firefox")) {
			if (driver != null) {
				driver.close();
			}
		}
	}
}