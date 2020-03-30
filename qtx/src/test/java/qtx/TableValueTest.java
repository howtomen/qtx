package qtx;

import org.testng.Assert;
import org.testng.annotations.Test;

import frameworks.TestSuperClass;
import pageobjects.TablePageObject;

public class TableValueTest extends TestSuperClass {
  @Test
  public void GetTableValue() {
	  String expected = "$100.00";
	  
	  String actual = new TablePageObject(driver,BaseUrl)
			  .OpenTablePage()
			  .GetValue();
	  Assert.assertEquals(actual, expected, "Value is not correct!");
  }
}
