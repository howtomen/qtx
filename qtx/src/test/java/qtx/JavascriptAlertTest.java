package qtx;

import org.testng.Assert;
import org.testng.annotations.Test;

import frameworks.TestSuperClass;
import pageobjects.AlertPageObject;

public class JavascriptAlertTest extends TestSuperClass {
  @Test
  public void jsAlert() {
	  String expectedResult = "You successfuly clicked an alert";
	  String actual = new AlertPageObject(driver, BaseUrl)
			  .OpenAlertPage()
			  .Clickbutton("Click for JS Alert")
			  .HandleAlert();
	  Assert.assertEquals(actual, expectedResult, "Alert was not handled");
  }
  @Test
  public void jsConfirm() {
	  String expectedResult = "You clicked: Ok";
	  String actual = new AlertPageObject(driver, BaseUrl)
			  .OpenAlertPage()
			  .Clickbutton("Click for JS Confirm")
			  .HandleAlert();
	  Assert.assertEquals(actual, expectedResult, "Alert was not handled");
  }
  @Test
  public void jsPrompt() {
	  String expectedResult = "You entered: Type this in";
	  String actual = new AlertPageObject(driver, BaseUrl)
			  .OpenAlertPage()
			  .Clickbutton("Click for JS Prompt")
			  .HandlePrompt();
	  Assert.assertEquals(actual, expectedResult, "Alert was not handled");
  }
}
