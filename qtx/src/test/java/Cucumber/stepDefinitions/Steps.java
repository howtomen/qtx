package Cucumber.stepDefinitions;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import frameworks.DriverManagerFactory;
import frameworks.DriverType;

public class Steps {
	protected WebDriver driver;
	protected String url;
	protected WebElement checkbox1;
	protected WebElement checkbox2;
	
	@Given("^Chrome is open and Checkbox page is loaded$")
	public void openChrome() throws Throwable {
		driver = DriverManagerFactory.getManager(DriverType.CHROME).getDriver();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		url = "http://the-internet.herokuapp.com/checkboxes";
		PageFactory.initElements(driver, this);
		driver.get(url);
	}
	@When("^user locates the Checkboxes$")
	public void locateCheckbox() throws Throwable{
		 checkbox1 = driver.findElement(By.xpath("//*[@id=\"checkboxes\"]/input[1]"));
		 checkbox2 = driver.findElement(By.xpath("//*[@id=\"checkboxes\"]/input[2]"));
	}
	@Then("^user clicks the  unchecked checkboxes$")
	public void checkUncheckedboxes() throws Throwable{
		if (!checkbox1.isSelected()) 
			checkbox1.click();
		
		if (!checkbox2.isSelected()) 
			checkbox2.click();
	}
	@Then("^both checkboxes are checked$")
	public void checkbothareChecked() throws Throwable {
		if (checkbox1.isSelected() && checkbox2.isSelected()) 
			System.out.println("Both checkboxes are checked");
		else
			System.out.println("Both checkboxes are not checked");
		driver.quit();
	}
}
