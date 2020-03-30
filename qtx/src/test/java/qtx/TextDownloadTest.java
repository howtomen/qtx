package qtx;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

import org.testng.annotations.Test;

import frameworks.TestSuperClass;
import pageobjects.DownloadPageObject;

public class TextDownloadTest extends TestSuperClass{
  @Test
  public void TextDownloadAndPrint() throws IOException {
	  String line;
	  
	  File textDownload = new DownloadPageObject(driver, BaseUrl)
			  .OpenDownloadPage()
			  .GetTextFile();
	  
	  //print file
	  try (BufferedReader br = new BufferedReader(new FileReader(textDownload))) {
		   while ((line = br.readLine()) != null) {
		       System.out.println(line);
		   }
		}
	  textDownload.delete();
  }
}
