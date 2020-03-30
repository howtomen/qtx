package pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;

import frameworks.SuperPageObject;

public class HoversPageObJect extends SuperPageObject {
	@FindBy(xpath = "//*[@id=\"content\"]/div/div[3]/img")
	WebElement Profile;

	public HoversPageObJect(WebDriver driverInstance, String baseUrl) {
		super(driverInstance, baseUrl);
	}

	public HoversPageObJect OpenHoverPage() {
		Navigate("/hovers");
		return this;
	}

	public String ClickProfileLink() {
		Actions action = new Actions(driver);
		action.moveToElement(Profile).build().perform();
		return driver.findElement(By.xpath("//*[@id=\"content\"]/div/div[3]/div/a")).getAttribute("href");
	}

}
