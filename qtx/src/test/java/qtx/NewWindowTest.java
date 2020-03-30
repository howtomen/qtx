package qtx;

import org.testng.Assert;
import org.testng.annotations.Test;

import frameworks.TestSuperClass;
import pageobjects.WindowsPageObject;

public class NewWindowTest extends TestSuperClass{
  @Test
  public void SwitchTabsGetText() {
	  String text = new WindowsPageObject(driver, BaseUrl)
			  .OpenWindowsPage()
			  .ClickLink()
			  .ReturnText();
	  Assert.assertEquals(text, "New Window", "Text is incorrect");
  }
}
