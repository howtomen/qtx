package pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import frameworks.SuperPageObject;

public class SecurePageObject extends SuperPageObject{
	
	@FindBy(id="flash") //web element annotations
	private WebElement greenBox;
	
	public SecurePageObject(WebDriver driverInstance, String url) {
		super(driverInstance, url);
	}

	public String getLoginConfirmationMessage() {
		
		return greenBox.getText();
		
	}

}

