package pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;

import frameworks.SuperPageObject;

public class DemoQAForm extends SuperPageObject{

	@FindBy(xpath = "//input[@name='firstname']")
	WebElement FirstNameInput;
	@FindBy(xpath = "//input[@id='lastname']")
	WebElement LastNameInput;
	@FindBy(id="datepicker")
	WebElement DateInput;
	@FindBy(id="continents")
	WebElement ContinentInput;
	
	public DemoQAForm(WebDriver driverInstance, String baseUrl) {
		super(driverInstance, baseUrl);
	}

	public DemoQAForm goToPage() {
		Navigate("automation-practice-form/");
		return this;
	}

	public void FillFirstandLast(String first, String last) {
		FirstNameInput.sendKeys(first);
		LastNameInput.sendKeys(last);
		
	}
	


	public void FillAll(String first, String last, String date, String continent, String sex, String profession, String tool, String years) {
		FirstNameInput.sendKeys(first);
		LastNameInput.sendKeys(last);
		DateInput.sendKeys(date);
		Select dropdown = new Select(ContinentInput);
		dropdown.selectByVisibleText(continent);
		driver.findElement(By.xpath("//*[@name = 'sex' and @value='"+sex+"']")).click();
		driver.findElement(By.xpath("//*[@name = 'exp' and @value='"+years+"']")).click();
		driver.findElement(By.xpath("//*[@name = 'profession' and @value='"+profession+"']")).click();
		driver.findElement(By.xpath("//*[@name = 'tool'and  @value='"+tool+"']")).click();
	}
}
