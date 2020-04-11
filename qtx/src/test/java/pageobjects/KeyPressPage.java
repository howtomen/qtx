package pageobjects;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import frameworks.SuperPageObject;

public class KeyPressPage extends SuperPageObject {

	@FindBy(id="target")
	WebElement inputBox;
	
	@FindBy(id="result")
	WebElement result;
	
	public KeyPressPage(WebDriver driverInstance, String baseUrl) {
		super(driverInstance, baseUrl);
	}

	public KeyPressPage OpenKeyPressPage(String baseUrl) {
		Navigate("/key_presses");
		return this;
	}

	public KeyPressPage SendKey(Keys key) {
		inputBox.sendKeys(key);
		return this;
	}

	public String GetResult() {
		return result.getText();
	}

}
