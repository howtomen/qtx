package pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import frameworks.SuperPageObject;

public class BasicAuthPageObject extends SuperPageObject {

	public BasicAuthPageObject(WebDriver driverInstance, String baseUrl) {
		super(driverInstance, baseUrl);
	}
	public BasicAuthPageObject login() {
		driver.get("http://admin:admin@the-internet.herokuapp.com/basic_auth");
		return this;
	}
	public String VerifyLogin() {
		return driver.findElement(By.xpath("//*[@id=\"content\"]/div/p")).getText();
	}


}
