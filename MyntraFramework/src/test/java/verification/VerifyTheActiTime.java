package verification;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.aventstack.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.HTMLReporter;

import browsers.Base;
import pac1.Homepage;
import pac1.Login;
import utilityPac.UtilityClass;

public class VerifyTheActiTime extends Base{
WebDriver driver;
Login l;
Homepage h;
SoftAssert soft;
int testid;
String user;
String pwd;



static ExtentTest test;
static HTMLReporter reporter;

    @Parameters("BrowserName")
    
    @BeforeTest
    public void launchBrowser(String browser) {
    	System.out.println("Test");
    	
    	reporter=new HTMLReporter("./test-output/Extents/Extent.html");
        ExtentReports ext=new ExtentReports();
    	ext.flush();
    	
    	
    	if(browser.equals("Chrome")) {
    		driver=OpenChromeBrowser();
    	}
    	if(browser.equals("Firefox")) {
    		driver=OpenFirefoxBrowser();
    	}
    	if(browser.equals("Edge")) {
    		driver=OpenEdgeBrowser();
    	}
    
    	driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
    }

	@BeforeClass     // Launch Browser Code 
	public void CreatePomObject() {
	l=new Login(driver);
	h=new Homepage(driver);	
	}
		
	@BeforeMethod   // Create the object // login details 
	public void LoginToApplication_1() {
		
		driver.get("https://online.actitime.com/marolix7/login.do");
		l=new Login(driver);
		
		String user=UtilityClass.FetchData("Sheet1", 1, 0);
	    l.SendUserName(user);
	   
	    String pwd=UtilityClass.FetchData("Sheet1", 1, 1);
	    l.SendPassWord(pwd);
	    
	    l.ClickOnKeepMeSignIn();
	    
	    l.ClickOnLoginButton();
	    
		h=new Homepage(driver);
		
		soft=new SoftAssert();
		
	}
	@Test              // verify the User buttons
	public void VerifyTheTask() {
		testid=001;
		h.openTask();
		
		String url=driver.getCurrentUrl();
		String title=driver.getTitle();
		System.out.println(url);
		System.out.println(title);
		Assert.assertEquals("https://online.actitime.com/marolix7/timetrack/enter.do","https://online.actitime.com/marolix7/timetrack/enter.do");
	  
	}
	
	@Test
	public void VerifyTheReports() {
		testid=002;
		h.openReports();
		String url1=driver.getCurrentUrl();
		String title1=driver.getTitle();
		System.out.println(url1);
		System.out.println(title1);
		Assert.assertEquals("https://online.actitime.com/marolix7/reports/dashboard.do", "https://online.actitime.com/marolix7/reports/dashboard.do");

	}
	@Test
	public void TestA() {
		testid=003;
		System.out.println("TestA");
		boolean result=false; 
		Assert.assertFalse(result);	
	}

	@AfterMethod   // Logout 
	public void ClickOnLogout(ITestResult result) throws Exception {
		if(ITestResult.FAILURE==result.getStatus()) {
			UtilityClass.capturesnap(driver, testid=001,"VerifyTheTask");
		}
		h.ClickOnLogoutButton();
	}
	@AfterClass   // quit browser
	public void ClearPomObject() {
		l=null;
		h=null;
	}
	@AfterTest
	public void CloseTheBrowser() {
		driver.quit();
		driver=null;
		System.gc();
	}
	
	
}
