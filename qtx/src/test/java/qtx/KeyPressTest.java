package qtx;


import org.testng.annotations.Test;

import frameworks.TestSuperClass;
import pageobjects.KeyPressPage;

import org.openqa.selenium.Keys;
import org.testng.Assert;

//Test 6/7

public class KeyPressTest extends TestSuperClass {
  @Test
  public void TestingLogin() {
  String expected = "You entered: TAB";
  
  String actual = new KeyPressPage(driver,BaseUrl)
		  .OpenKeyPressPage(BaseUrl)
		  .SendKey(Keys.TAB)
		  .GetResult();
  Assert.assertEquals(actual, expected);
  } 
}
