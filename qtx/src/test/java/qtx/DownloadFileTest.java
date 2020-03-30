package qtx;

import java.io.File;

import org.testng.Assert;
import org.testng.annotations.Test;
import frameworks.TestSuperClass;
import pageobjects.JqueryMenuPage;

public class DownloadFileTest extends TestSuperClass {
	String Filename = "menu.xls";
  @Test
  public void canDownloadFile() {
	  File deleteFile = new File("C:\\Users\\Daniel Ariza\\Downloads\\menu.xls");
	  if (deleteFile.exists())
		  deleteFile.delete();
	  
	  File downloadedFile = new JqueryMenuPage(driver, BaseUrl)
			  .OpenMenuPage()
			  .ClickItemByMenuPath(new String[] { "Enabled", "Downloads", "Excel" })
			  .getDownloadedFile();
	  Assert.assertEquals(downloadedFile.getName(), Filename, "File not found");
	  
	  downloadedFile.delete();
  }
}
