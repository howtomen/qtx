package qtx;

import org.testng.Assert;
import org.testng.annotations.Test;

import frameworks.TestSuperClass;
import pageobjects.AddRemoveElementsPage;

//problem 5/7

public class AddRemoveElements extends TestSuperClass {
  @Test
  public void AddingAndRemovingElementsTest() {
	  int expected = 6;
	  int actual = new AddRemoveElementsPage(driver, BaseUrl)
			  .goToPage()
			  .AddElements()
			  .RemoveElements()
			  .CountElements();
	 Assert.assertEquals(actual, expected);
  }
}
