package pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import frameworks.SuperPageObject;

public class DynamicControlPage extends SuperPageObject {
	@FindBy(xpath = "//*[@id=\"input-example\"]/button")
	WebElement EnableButton;
	@FindBy(xpath = "//*[@id=\"input-example\"]/input")
	WebElement TextBox;
	String Result;
	
	public DynamicControlPage(WebDriver driverInstance, String baseUrl) {
		super(driverInstance, baseUrl);
	}

	public DynamicControlPage goToPage() {
		Navigate("/dynamic_controls");
		return this;
	}

	public DynamicControlPage EnableText() {
		EnableButton.click();
		return this;
	}

	public DynamicControlPage SendText(String text) {
		WebDriverWait wait = new WebDriverWait(driver,10);
		wait.until(ExpectedConditions.elementToBeClickable(TextBox));
		TextBox.sendKeys(text);
		return this;
	}
}
