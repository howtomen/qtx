package qtx;

//import org.openqa.selenium.By;
//import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.Test;

public class DropdownListTest extends TestSuperClass {
	@Test
	public void canSelectDrobdownListItem() {
		
		String expectedSelection = new String("Option 2");

		//Select dropdownList = new Select(driver.findElement(By.id("dropdown")));
		//dropdownList.selectByIndex(2);

		String actualSelection = new DropDownPageObject(driver, BaseUrl)
				.OpenDropdownPage(BaseUrl)
				.setDropDownList(expectedSelection)
				.getDropDownListValue();

		Assert.assertEquals(actualSelection, expectedSelection, "Can not select a dropdown list value!");
	}

}
