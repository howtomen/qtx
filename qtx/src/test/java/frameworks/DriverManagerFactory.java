package frameworks;

import frameworks.ChromeDriverManager;

public class DriverManagerFactory {
	public static DriverManager getManager(DriverType type) {
		switch(type) {
		case CHROME:
			return new ChromeDriverManager();
		case FIREFOX:
			return new FirefoxDriverManager();
		default:
			System.out.printf("We do not support this driver: %s", type);
		}
		return null;
	}
}