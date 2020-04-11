package pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

import frameworks.SuperPageObject;

public class EntryAdPage extends SuperPageObject {
	
	@FindBy(xpath="//*[@id=\"modal\"]/div[@class='modal']/div[@class='modal-footer']/p")
	WebElement CloseButton;

	public EntryAdPage(WebDriver driverInstance, String baseUrl) {
		super(driverInstance, baseUrl);
	}

	public EntryAdPage goToPage() {
		Navigate("/entry_ad");
		return this;
	}

	public EntryAdPage closeAd() {
		WebDriverWait wait = new WebDriverWait(driver, 10);
		wait.until(ExpectedConditions.visibilityOf(CloseButton));
		CloseButton.click();
		return this;
	}

	public String getHeader() {
		return driver.findElement(By.tagName("h3")).getText();
	}
	
	

}
