package pac1;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.Alert;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Homepage {

	@FindBy(xpath="//a[@class='content tasks']")
	private WebElement task;
	
	@FindBy(xpath="//a[@class='content reports']")
	private WebElement reports;

	 @FindBy(xpath="//a[@class='content users']")
	 private WebElement Users;
	 
	 @FindBy(xpath="(//a[contains(@id,'logoutLink')])[1]")
	 private WebElement LogoutButton;
	 
//	 @FindBy (xpath="")
//	 private List<WebElement> File;
	 
	 
	 private WebDriver driver;
	 private Actions act;
	 private WebDriverWait wait;
	 private JavascriptExecutor js;
	 private Alert alt;
	 
	 
	public Homepage(WebDriver driver){
		 PageFactory.initElements(driver, this);
		 this.driver=driver;
		wait=new WebDriverWait(driver,Duration.ofSeconds(0));
		act=new Actions(driver);
		js=(JavascriptExecutor)driver;
	 }
	
	public void openTask() {
		act.moveToElement(task).click().build().perform();
	}
	public void openReports() {
	wait.until(ExpectedConditions.visibilityOf(reports));
		reports.click();
	}
	public void openUsers() {
		js.executeScript("arguments[0].click();",Users);
//		Users.click();
	}
	public void ClickOnLogoutButton() {
		wait.until(ExpectedConditions.visibilityOf(LogoutButton));
		
     act.moveToElement(LogoutButton).click().build().perform();
}
	
}
