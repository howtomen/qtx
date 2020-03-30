package qtx;

import org.testng.annotations.Test;

import frameworks.TestSuperClass;
import pageobjects.InfiniteScrollPageObject;

public class ScrollParagraphTest extends TestSuperClass {
  @Test
  public void PrintParagraph() {
	  
	  
	  String paragraph = new InfiniteScrollPageObject(driver, BaseUrl)
			  .OpenScrollPage()
			  .GetParagraph();
	  System.out.print(paragraph);
  }
}
