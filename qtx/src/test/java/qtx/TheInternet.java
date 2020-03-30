package qtx;
import org.testng.Assert;
import org.testng.annotations.Test;

import frameworks.TestSuperClass;

public class TheInternet extends TestSuperClass{

	
//  // As a user
//  // I want to log in
//  // So users can do stuff
	@Test
  public void canLogIn() {

	  // arrange
	String userName = new String("tomsmith");
	String password = new String("SuperSecretPassword!");
	String expectedGreenBoxText = new String("You logged into a secure area!\n×");
  
	 String actualGreenBoxText = new  LoginPageObject(driver, BaseUrl)
			 .OpenLoginPage(BaseUrl)
			 .login(userName, password)
			 .getLoginConfirmationMessage();
	 
	 Assert.assertEquals(actualGreenBoxText, expectedGreenBoxText, "Can not Log in!");
	 
  }
 
  
  

}