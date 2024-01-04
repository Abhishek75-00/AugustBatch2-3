package browsers;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;

public class Base {

	public static WebDriver OpenChromeBrowser() {
		
		WebDriver driver=new ChromeDriver();
		return driver;
	}
	
	public static WebDriver OpenFirefoxBrowser() {
		System.setProperty("webdriver.gecko.driver",".\\src\\test\\resources\\TestData\\geckodriver.exe");
		FirefoxOptions ops=new FirefoxOptions();
		ops.setBinary("C:\\Program Files\\Mozilla Firefox\\firefox.exe");
		WebDriver driver=new FirefoxDriver(ops);
		return driver;
	}
	
	public static WebDriver OpenEdgeBrowser() {
		System.setProperty("webdriver.edge.driver","\\src\\test\\resources\\TestData\\msedgedriver.exe");
		WebDriver driver=new EdgeDriver();
		return driver;
	}
	
	
}
