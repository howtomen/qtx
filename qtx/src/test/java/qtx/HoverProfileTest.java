package qtx;

import org.testng.Assert;
import org.testng.annotations.Test;

import frameworks.TestSuperClass;
import pageobjects.HoversPageObJect;

public class HoverProfileTest extends TestSuperClass {
  @Test
  public void TestUserLink() {
	  String expectedUrl = "http://the-internet.herokuapp.com/users/3";
	  
	  String actualUrl = new HoversPageObJect(driver, BaseUrl)
			  .OpenHoverPage()
			  .ClickProfileLink();
	  Assert.assertEquals(actualUrl, expectedUrl, "Wrong URL returned");
  }
}
