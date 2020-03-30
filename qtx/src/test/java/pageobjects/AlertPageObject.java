package pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import frameworks.SuperPageObject;

public class AlertPageObject extends SuperPageObject{
	
	@FindBy(id = "result")
	WebElement result;
	String stringToSend = "Type this in";

	public AlertPageObject(WebDriver driverInstance, String baseUrl) {
		super(driverInstance, baseUrl);
	}

	public AlertPageObject OpenAlertPage() {
		Navigate("/javascript_alerts");
		return this;
	}

	public AlertPageObject Clickbutton(String text) {
		driver.findElement(By.xpath("//*[text()='" + text + "']")).click();
		return this;
	}

	public String HandleAlert() {
		driver.switchTo().alert().accept();
		return result.getText();
	}
	public String HandlePrompt() {
		driver.switchTo().alert().sendKeys(stringToSend);
		driver.switchTo().alert().accept();
		return result.getText();
	}
	

}
