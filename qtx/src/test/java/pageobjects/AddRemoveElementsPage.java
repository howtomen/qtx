package pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import frameworks.SuperPageObject;

public class AddRemoveElementsPage extends SuperPageObject {
	
	@FindBy(xpath="//*[@id=\"content\"]/div/button")
	WebElement AddButton;
	WebDriverWait wait = new WebDriverWait(driver,5);
	
	public AddRemoveElementsPage(WebDriver driverInstance, String baseUrl) {
		super(driverInstance, baseUrl);
	}

	public AddRemoveElementsPage goToPage() {
		Navigate("/add_remove_elements/");
		return this;
	}

	public AddRemoveElementsPage AddElements() {
		for(int i = 0; i < 10; i++) {
			int j = i+1;
			AddButton.click();
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"elements\"]/button[" + j + "]")));
		}
		return this;
	}

	public AddRemoveElementsPage RemoveElements() {
		WebElement FirstDelete = null; 
		
		for (int i = 0; i < 4; i++) {
			FirstDelete = driver.findElement(By.xpath("//*[@id=\"elements\"]/button[1]"));
			wait.until(ExpectedConditions.elementToBeClickable(FirstDelete));
			FirstDelete.click();
		}
		
		return this;
	}

	public int CountElements() {
		return  driver.findElements(By.xpath("//*[@id=\"elements\"]/button")).size();
	}

}
