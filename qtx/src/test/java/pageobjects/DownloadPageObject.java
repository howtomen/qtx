package pageobjects;

import java.io.File;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import frameworks.SuperPageObject;

public class DownloadPageObject extends SuperPageObject {
	
	@FindBy(xpath = "//*[text()='text.txt']")
	WebElement textFile;

	public DownloadPageObject(WebDriver driverInstance, String baseUrl) {
		super(driverInstance, baseUrl);
		}
	public DownloadPageObject OpenDownloadPage() {
		Navigate("/download");
		return this;
	}
	public File GetTextFile() {
		textFile.click();
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			System.out.println("wait not observed");
		}
		return new File("C:\\Users\\Daniel Ariza\\Downloads\\text.txt");
	}
	
	
}
