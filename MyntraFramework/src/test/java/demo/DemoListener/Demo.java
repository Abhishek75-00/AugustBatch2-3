package demo.DemoListener;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;




@Listeners(ListenersClass.class)
public class Demo {

	@Test
	public void testone() {
		
		WebDriver driver=new ChromeDriver();
		driver.get("http://e-quarz.com/");
		driver.manage().window().maximize();
		Assert.assertEquals(driver.getTitle(),"E-Quarz Online Shopping | E-Quarz Ecommerce");
		
		
		
		
		
	}
	
	
	
	
}
