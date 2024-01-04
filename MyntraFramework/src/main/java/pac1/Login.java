package pac1;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Login{

	
//	private variable-- webelement -
//	public constructor - initialize Webelement
//	public methods     - Action 
	
	@FindBy (xpath="//input[@id='username']")
	private WebElement Username;
	
	@FindBy (xpath="//input[@name='pwd']")
	private WebElement Password;
	
	@FindBy (xpath="//input[@id='keepLoggedInCheckBox']")
	private WebElement KeepMeSignIn;
	
	@FindBy (xpath="//td[@id='loginButtonContainer']")
	private WebElement LoginButton;
	
	
	//intalize
	private WebDriver driver;
	String user;
	String pwd;
	private Actions act;
	private WebDriverWait wait;
	
	public Login(WebDriver driver) {
		PageFactory.initElements(driver,this);
	this.driver=driver;
	act=new Actions(driver);
	wait=new WebDriverWait(driver,Duration.ofSeconds(10));
	
	}
	
	// Utilize or providing actions to variable
	
	public void SendUserName(String user) {
		Username.sendKeys(user);
	}
	public void SendPassWord(String pwd) {
		Password.sendKeys(pwd);
	}
	public void ClickOnKeepMeSignIn() {
		KeepMeSignIn.click();
	}
	public void ClickOnLoginButton() {
		wait.until(ExpectedConditions.visibilityOf(LoginButton));
		act.moveToElement(LoginButton).click().build().perform();;
	}
	
	//or 
	
//	public void LoginToApplication() {
//		Username.sendKeys("chethankrishna.marolix@gmail.com");
//		Password.sendKeys("AMdLPABh");
//		KeepMeSignIn.click();
//		LoginButton.click();
//	}
	
}
