package qtx;

import org.testng.Assert;
import org.testng.annotations.Test;

import frameworks.TestSuperClass;
import pageobjects.EntryAdPage;

//test 4/7

public class EntryAdTest extends TestSuperClass{
  @Test
  public void TestingEntryAd() {
	  
	   String expected = "Entry Ad";
	   String actual = new EntryAdPage(driver, BaseUrl)
			   .goToPage()
			   .closeAd()
			   .getHeader();
	   Assert.assertEquals(actual, expected);
  }
}
