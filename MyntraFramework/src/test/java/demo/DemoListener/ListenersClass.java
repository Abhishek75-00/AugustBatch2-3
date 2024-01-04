package demo.DemoListener;

import org.testng.ITestListener;
import org.testng.ITestResult;

public class ListenersClass implements ITestListener {

	@Override
	public void onTestStart(ITestResult result) {
		
		System.out.println(result.getName()+" Test Start");
	}

	@Override
	public void onTestSuccess(ITestResult result) {
		System.out.println(result.getName()+" Test Success");
	}

	@Override
	public void onTestFailure(ITestResult result) {
		System.out.println(result.getName()+" Test fail");
	}

}
