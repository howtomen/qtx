package qtx;


import org.testng.Assert;
import org.testng.annotations.Test;

import frameworks.TestSuperClass;
import pageobjects.BasicAuthPageObject;
//1 of 7
public class BasicAuth extends TestSuperClass {
  @Test
  public void BasicAuthTest() {
	  String actual = new BasicAuthPageObject(driver, BaseUrl)
			  .login()
			  .VerifyLogin();
	  String expected = "Congratulations! You must have the proper credentials.";
	Assert.assertEquals(expected, actual);
  }
}
