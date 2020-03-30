package pageobjects;

import java.util.ArrayList;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import frameworks.SuperPageObject;

public class FramePageObject extends SuperPageObject {

	public FramePageObject(WebDriver driverInstance, String baseUrl) {
		super(driverInstance, baseUrl);
	}

	public FramePageObject OpenFramePage() {
		Navigate("/nested_frames");
		return this;
	}

	public ArrayList<String> GetTextFromFrames(String [] frames) {
		ArrayList<String> results = new ArrayList<String>();
		
		driver.switchTo().frame("frame-top");
		for(String i: frames) {
			driver.switchTo().frame(i);
			results.add(driver.findElement(By.tagName("body")).getText());
			driver.switchTo().parentFrame();
			if (i == "frame-right")
				driver.switchTo().parentFrame();
		}
		
		return results;
	}

}
