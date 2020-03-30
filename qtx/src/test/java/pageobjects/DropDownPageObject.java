package pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import frameworks.SuperPageObject;

public class DropDownPageObject extends SuperPageObject {
	
	public DropDownPageObject(WebDriver driverInstance, String url) {

		super(driverInstance, url);
	}
	
	public DropDownPageObject OpenDropdownPage() {
		Navigate("/dropdown");
		return this;
	}
	
	public DropDownPageObject setDropDownList(String value) {

		getDropDown().selectByVisibleText(value);
		return this;
	}
	
	public String getDropDownListValue() {
		
		return getDropDown().getFirstSelectedOption().getText();
		
	}
	
	//maps one UI control, the drop down and the second option.
	public Select getDropDown() {
		WebElement dropDown = driver.findElement(By.id("dropdown"));
		Select customerDropDownList = new Select(dropDown);
		return customerDropDownList;
	}
}
