package tests;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import pac1.Homepage;
import pac1.Login;
import utilityPac.UtilityClass;

public class Verification {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
Login l;
Homepage h;

		WebDriver driver=new ChromeDriver();
		driver.get("https://online.actitime.com/marolix7/login.do");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		
		
		
		//Testcase1 -- Task Page
		 l=new Login(driver);
		String user=UtilityClass.FetchData("Sheet1", 1, 0);
		    l.SendUserName(user);
		String  pwd=UtilityClass.FetchData("Sheet1", 1, 1);
		    l.SendPassWord(pwd);
		    l.ClickOnKeepMeSignIn();
		    l.ClickOnLoginButton();
		
		h=new Homepage(driver);
		h.openTask();
		
		String url=driver.getCurrentUrl();
		String title =driver.getTitle();
		System.out.println(url);
		System.out.println(title);
		
		
		if(url.equals("https://online.actitime.com/marolix7/tasks/tasklist.do") && title.equals("actiTIME - Task List"))
{
			System.out.println("Pass");
}
		else {
			System.out.println("Fail");
		}
		
		h.ClickOnLogoutButton();
		
		
		//Testcase 2 - Reports
		
		 l=new Login(driver);
			
			String user1=UtilityClass.FetchData("Sheet1", 1, 0);
		    l.SendUserName(user1);
		String  pwd1=UtilityClass.FetchData("Sheet1", 1, 1);
		    l.SendPassWord(pwd1);
		    l.ClickOnKeepMeSignIn();
		    l.ClickOnLoginButton();
		
		h.openReports();
		String url1=driver.getCurrentUrl();
		String title1=driver.getTitle();
		System.out.println(url1);
		System.out.println(title1);
		if(url1.equals("https://online.actitime.com/marolix7/administration/userlist.do")&& title1.equals("actiTIME - Reports Dashboard")) {
			System.out.println("Pass");
		}
		else {
			System.out.println("Fail");
		}
		
		h.ClickOnLogoutButton();
		
		// Testcase 3 - Users
		String user2=UtilityClass.FetchData("Sheet1", 1, 0);
	    l.SendUserName(user2);
	String  pwd2=UtilityClass.FetchData("Sheet1", 1, 1);
	    l.SendPassWord(pwd2);
	    l.ClickOnKeepMeSignIn();
	    l.ClickOnLoginButton();
	
	h.openUsers();
	String url2=driver.getCurrentUrl();
	String title2=driver.getTitle();
	System.out.println(url2);
	System.out.println(title2);
		if(url2.equals("")&& title2.equals("")) {
			System.out.println("Pass");
		}
		else {
			System.out.println("Fail");
		}
		h.ClickOnLogoutButton();
	}

}
