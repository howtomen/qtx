package pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import frameworks.SuperPageObject;

public class NotificationMessagePage extends SuperPageObject {

	@FindBy(xpath = "//*[@id='content']/div[@class='example']/p/a")
	WebElement newMessageButton;
	
	WebElement message;
	String expected = "Action successful\n" + 
	  		"×";
	

	public NotificationMessagePage(WebDriver driverInstance, String baseUrl) {
		super(driverInstance, baseUrl);
	}

	public NotificationMessagePage GoToPage() {
		Navigate("/notification_message_rendered");
		return this;
	}

	public String ClickButtonUntilSuccessful() {
		newMessageButton.click();
		message = driver.findElement(By.xpath("//*[@id='flash']"));
		while (message.getText().contains("Action unsuccesful")) {
			System.out.println(message.getText());
			newMessageButton.click();
			message = driver.findElement(By.xpath("//*[@id='flash']"));
		}
		return message.getText();
		
	}

	
}
