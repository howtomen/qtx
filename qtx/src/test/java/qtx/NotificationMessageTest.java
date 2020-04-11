package qtx;

import org.testng.Assert;
import org.testng.annotations.Test;

import frameworks.TestSuperClass;
import pageobjects.NotificationMessagePage;
//problem 7/7

public class NotificationMessageTest extends TestSuperClass {
  @Test
  public void TestNotificationMessage() {
	  String expected = "Action successful\n" + 
		  		"×";
	  
	  String actual = new NotificationMessagePage(driver,BaseUrl)
			  .GoToPage()
			  .ClickButtonUntilSuccessful();
	  Assert.assertEquals(actual, expected);
  }
}
