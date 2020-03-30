package qtx;

import java.util.List;
import java.util.ArrayList;
import java.util.Arrays;

import org.testng.Assert;
import org.testng.annotations.Test;

import frameworks.TestSuperClass;
import pageobjects.FramePageObject;

public class FrameTest extends TestSuperClass {
  @Test
  public void FrameTesting() {
	  List<String> list1 = Arrays.asList("LEFT", "MIDDLE", "RIGHT", "BOTTOM" );
	  ArrayList<String> expectedResult = new ArrayList<>();
	  
	  expectedResult.addAll(list1);
	  
	  String[] frames = {"frame-left", "frame-middle", "frame-right", "frame-bottom" };
	  ArrayList<String> actual =  new FramePageObject(driver, BaseUrl)
			  .OpenFramePage()
			  .GetTextFromFrames(frames);
	  Assert.assertEquals(actual, expectedResult, "Frame text not found");
  }
}
