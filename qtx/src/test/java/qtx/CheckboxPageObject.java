package qtx;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class CheckboxPageObject extends SuperPageObject {
	
	public CheckboxPageObject (WebDriver driverInstance, String url) {
		super(driverInstance, url);
	}
	
	public CheckboxPageObject OpenCheckboxPage(String BaseUrl) {
		String url = BaseUrl+ "/checkboxes";
		Navigate(url);
		return this;
	}
	public boolean ClickCheckboxes() {
		WebElement checkbox1 = driver.findElement(By.xpath("//*[@id=\"checkboxes\"]/input[1]"));
		WebElement checkbox2 = driver.findElement(By.xpath("//*[@id=\"checkboxes\"]/input[2]"));
		
		if (!checkbox1.isSelected()) 
			checkbox1.click();
		
		if (!checkbox2.isSelected()) 
			checkbox2.click();
		
		if (checkbox1.isSelected() && checkbox2.isSelected()) 
			return true;
		else
			return false;
	}
	
}
