package verification;

import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;

import org.testng.annotations.Test;

public class DemoPractise {
	
@BeforeClass
public void beforeclass() {
	System.out.println("BeforeClass");
}
@BeforeMethod
public void beforemethod() {
	System.out.println("BeforeMethod");
}
@Test (priority=1)
public void TestA() {
	System.out.println("TestA");
}
@Test (priority=2,invocationCount=1)
public void TestB() {
	System.out.println("TestB");
}
@Test (priority=3 ,dependsOnMethods= {"TestA","TestB"}) 
public void TestC() {
	System.out.println("TestC");
}
@Test (enabled=false)
public void TestD() {
	System.out.println("TestD");
}
@Test (timeOut=3000)
public void TestE() throws Exception {
	System.out.println("TestE");
	Thread.sleep(2000);
	System.out.println("Hello");
}
@AfterMethod
public void afterMethod() {
	System.out.println("Aftermethod");
}
@AfterClass
public void afterclass() {
	System.out.println("AfterClass");
}

}
