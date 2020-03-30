package pageobjects;

import java.io.File;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import frameworks.SuperPageObject;

public class JqueryMenuPage extends SuperPageObject {
	
	public JqueryMenuPage(WebDriver driverInstance, String baseUrl) {
		super(driverInstance, baseUrl);
	}
	public JqueryMenuPage OpenMenuPage() {
		Navigate("/jqueryui/menu");
		return this;
	}
	public JqueryMenuPage ClickItemByMenuPath(String [] path) {
		
		for (int i=0; i < path.length; i++) {
		driver.findElement(By.xpath("//*[text()='" + path[i] + "']")).click();
		}
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			System.out.println("wait not observed");
		}
		return this;
	}
	public File getDownloadedFile() {
		
		return new File("C:\\Users\\Daniel Ariza\\Downloads\\menu.xls");
	
	}
	
	

}
