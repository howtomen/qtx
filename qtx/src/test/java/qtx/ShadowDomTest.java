package qtx;

import org.testng.Assert;
import org.testng.annotations.Test;

import frameworks.TestSuperClass;
import pageobjects.ShadowDomPage;
//problem 3/7
public class ShadowDomTest extends TestSuperClass {
  @Test
  public void ShadowDomTesting() {
	  String expected = "My default text";
	  String actual = new ShadowDomPage(driver,BaseUrl)
			  .goToPage()
			  .getShadowDomText();
	  Assert.assertEquals(actual,expected, "String is not the righe one");
  }
}
