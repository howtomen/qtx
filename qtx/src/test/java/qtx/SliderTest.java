package qtx;

import org.testng.Assert;
import org.testng.annotations.Test;

import frameworks.TestSuperClass;
import pageobjects.SliderPageObject;

public class SliderTest extends TestSuperClass {
	//As a user
	//I want to move the slider to the max value
	//So I can prove that I know how to use the Actions
  @Test
  public void CanMoveSlider() {
	  String maxValue = "5";
	  String actualValue = new SliderPageObject(driver, BaseUrl)
			  .OpenSliderPage()
			  .MoveSlider();
	  
	  Assert.assertEquals(actualValue, maxValue, "Slider isn't moved to the max value!");
	  
  }
}
