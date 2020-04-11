package qtx;

import org.testng.annotations.Test;

import frameworks.TestSuperClass;

import pageobjects.DynamicControlPage;

//Test 2 of 7;

public class DynamicControls extends TestSuperClass{
  @Test
  public void TestDynamicControl() {
	 String text = "Testing Controls";
	 new DynamicControlPage(driver, BaseUrl)
			 .goToPage()
			 .EnableText()
			 .SendText(text);
  }
}
