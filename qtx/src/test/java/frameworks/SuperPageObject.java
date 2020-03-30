package frameworks;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public abstract class SuperPageObject {

	protected WebDriver driver;
	protected String baseUrl;
	
	protected SuperPageObject(WebDriver driverInstance, String baseUrl) {
		this.driver = driverInstance;
        this.baseUrl = baseUrl;
        
        PageFactory.initElements(driver, this);
        
	}
	
	protected void Navigate(String url) {
		String link = baseUrl+ url;
		driver.get(link);
	}
}
