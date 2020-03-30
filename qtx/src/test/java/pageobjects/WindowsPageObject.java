package pageobjects;

import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import frameworks.SuperPageObject;

public class WindowsPageObject extends SuperPageObject {
	protected String parent;
	
	public WindowsPageObject(WebDriver driver, String baseUrl) {
		super(driver, baseUrl);
	}

	public WindowsPageObject OpenWindowsPage() {
		Navigate("/windows");
		return this;
	}

	public WindowsPageObject ClickLink() {
		parent=driver.getWindowHandle();
		driver.findElement(By.xpath("//*[@id=\"content\"]/div/a")).click();
		new WebDriverWait(driver,5).until(ExpectedConditions.numberOfWindowsToBe(2));
		return this;
	}

	public String ReturnText() {
		Set<String> allHandles = driver.getWindowHandles();
		for(String winHandle:allHandles)
		{
		    if (!parent.equalsIgnoreCase(winHandle))
		    {
		        driver.switchTo().window(winHandle);
		    }
		}
		String text = driver.findElement(By.xpath("//div[contains(@class, 'example')]/h3")).getText();
		driver.switchTo().window(parent);
		return text;
	}

}