package qtx;

import org.testng.Assert;
import org.testng.annotations.Test;

public class CheckboxTest extends TestSuperClass {

	//as a user
	//I want to be able to click checkboxes
	//so i can select items
	@Test
	public void clickCheckboxes() {
		boolean allChecked = new CheckboxPageObject(driver, BaseUrl)
				.OpenCheckboxPage(BaseUrl)
				.ClickCheckboxes();
		
		Assert.assertEquals(allChecked, true, "Checkboxes are not Selected!");
		
		//testing push file 
				
		
		
		
	}
}
