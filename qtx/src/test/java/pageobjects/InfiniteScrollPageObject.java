package pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;

import frameworks.SuperPageObject;

public class InfiniteScrollPageObject extends SuperPageObject {

	public InfiniteScrollPageObject(WebDriver driverInstance, String baseUrl) {
		super(driverInstance, baseUrl);
		}

	public InfiniteScrollPageObject OpenScrollPage() {
		Navigate("/infinite_scroll");
		return this;
	}

	public String GetParagraph() {
		 ((JavascriptExecutor) driver)
         .executeScript("window.scrollTo(0, document.body.scrollHeight)");
		 try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				System.out.println("wait not observed");
			}
		 
		 
		return driver.findElement(By.xpath("//*[@id=\"content\"]/div/div/div/div/div[3]")).getText();
	}

}
