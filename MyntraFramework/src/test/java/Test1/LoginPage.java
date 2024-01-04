package Test1;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import pac1.Homepage;
import pac1.Login;
import utilityPac.UtilityClass;

public class LoginPage {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		WebDriver driver =new ChromeDriver();
		
		driver.get("https://online.actitime.com/marolix7/login.do");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		
		Login l=new Login(driver);
		
		String user=UtilityClass.FetchData("Sheet1", 1, 0);
	    l.SendUserName(user);
	    String pwd=UtilityClass.FetchData("Sheet1", 1, 1);
	    l.SendPassWord(pwd);
	    
	    l.ClickOnKeepMeSignIn();
	    
	    l.ClickOnLoginButton();
		
	
	 
	 
	 Homepage h=new Homepage(driver);
	 h.openTask();
	 h.openReports();
	 h.openUsers();
	// h.ClickOnLogoutButton();
	 
	}

}
