package qtx;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;

public class SliderPageObject extends SuperPageObject {
	public SliderPageObject (WebDriver driverInstance, String url) {
		super(driverInstance, url);
	}

	public SliderPageObject OpenSliderPage(String baseUrl) {
		String url = baseUrl + "/horizontal_slider";
		Navigate(url);
		return this;
	}
	public String MoveSlider() {
		Actions move = new Actions(driver);
		WebElement slider = driver.findElement(By.tagName("input"));
		Action action = (Action) move.dragAndDropBy(slider, 138, 168).build();
		action.perform();
		return slider.getAttribute("value");
	}

}
