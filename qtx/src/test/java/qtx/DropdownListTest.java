package qtx;


import org.testng.Assert;
import org.testng.annotations.Test;

import frameworks.TestSuperClass;
import pageobjects.DropDownPageObject;

public class DropdownListTest extends TestSuperClass {
	@Test
	public void canSelectDrobdownListItem() {
		
		String expectedSelection = new String("Option 2");


		String actualSelection = new DropDownPageObject(driver, BaseUrl)
				.OpenDropdownPage()
				.setDropDownList(expectedSelection)
				.getDropDownListValue();

		Assert.assertEquals(actualSelection, expectedSelection, "Can not select a dropdown list value!");
	}

}
