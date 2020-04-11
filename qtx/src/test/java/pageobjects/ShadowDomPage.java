package pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import frameworks.SuperPageObject;

public class ShadowDomPage extends SuperPageObject {
	@FindBy(tagName = "my-paragraph")
	WebElement root;

	public ShadowDomPage(WebDriver driverInstance, String baseUrl) {
		super(driverInstance, baseUrl);
	}

	public ShadowDomPage goToPage() {
		Navigate("/shadowdom");
		return this;
	}

	public String getShadowDomText() {
		WebElement shadowRoot = expandRootElement(root);
		System.out.println(shadowRoot.getAttribute("innerHTML"));
		return shadowRoot.findElement(By.tagName("slot")).getText();
	}

	public WebElement expandRootElement(WebElement element) {
		WebElement ele = (WebElement) ((JavascriptExecutor) driver).executeScript("return arguments[0].shadowRoot",
				element);
		return ele;
	}

}
