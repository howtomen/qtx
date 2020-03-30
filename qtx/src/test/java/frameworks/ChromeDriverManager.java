package frameworks;
import org.openqa.selenium.chrome.ChromeDriver;
import frameworks.DriverManager;

public class ChromeDriverManager extends DriverManager {
	@Override
	protected void startService() {
		// TODO Auto-generated method stub
	}
	@Override
	protected void stopService() {
		// TODO Auto-generated method stub
	}
	@Override
	protected void createDriver() {
		 System.setProperty("webdriver.chrome.driver", "C:\\chromedriver.exe");
		 driver = new ChromeDriver();
	}
}