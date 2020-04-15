package qtx;

import org.testng.annotations.Test;

import frameworks.TestSuperClass;
import pageobjects.DemoQAForm;

public class demoQAformSimpleTest extends TestSuperClass {
  
  String first = "Daniel";
  String last = "TestLast";
  String date = "4/01/2020";
  String continent = "Australia";
  String sex = "Male";
  String profession = "Automation Tester";
  String tool = "Selenium Webdriver";
  String years = "1";
  
 @Test
  public void FillFirstAndLast() {
	  
	   new DemoQAForm(driver, "https://demoqa.com/")
	  .goToPage()
	  .FillFirstandLast(first,last);
  }
  
  @Test
  public void FillMoreInfo() {
	  new DemoQAForm(driver, "https://demoqa.com/")
	  .goToPage()
	  .FillAll(first,last,date,continent, sex, profession, tool, years);
	  
  }
}

