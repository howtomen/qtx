package pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import frameworks.SuperPageObject;

public class TablePageObject extends SuperPageObject {

	public TablePageObject(WebDriver driverInstance, String baseUrl) {
		super(driverInstance, baseUrl);	
	}

	public TablePageObject OpenTablePage() {
		Navigate("/tables");
		return this;
	}

	public String GetValue() {
		return driver.findElement(By.xpath("//*[@id=\"table1\"]/tbody/tr[3]/td[4]")).getText();
	}
	
	

}
