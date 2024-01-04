package com.propertiesFiles;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class Test_properties {

	public static void main(String[] args) throws IOException {
		
		
	//Resoruce or confirgration files are store into the property files
	// Files like  database access information , Envirnoment setting , special features , Functions.	
		
		
		
		FileInputStream fis=new FileInputStream(".\\src\\test\\java\\com\\propertiesFiles\\Data.properties");
		
		Properties p=new Properties();
		p.load(fis);
		
		
		String MyBrowser=p.getProperty("browser");
		System.out.println(MyBrowser);
		if(MyBrowser.equals("Firefox")) {
			
			WebDriver driver=new FirefoxDriver();
			driver.get("https://www.flipkart.com/");
			
		}
		
		else if (MyBrowser.equals("Edge")) {
			WebDriver driver=new EdgeDriver();
			driver.get("https://www.flipkart.com/");
		}
		
		else if (MyBrowser.equals("chrome")) {
			WebDriver driver=new ChromeDriver();
			driver.get("https://www.flipkart.com/");
		}
		
		
		

	}

}
