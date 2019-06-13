package extentReports;

import java.io.File;

import org.testng.ITestResult;
import org.testng.SkipException;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

import org.junit.Assert;

public class ExtentReport {
	ExtentReports extent;
	ExtentTest logger;
	
	@BeforeTest
	public void startTest() {
		
		extent = new ExtentReports(System.getProperty("user.dir")+"test-output/STMExtentReport.html", true);
		extent.addSystemInfo("Host Name","AmazonWebAppTest")
		.addSystemInfo("Environment", "Automation Testing")
		.addSystemInfo("User Name", "k.deepika");
		
		extent.loadConfig(new File(System.getProperty("user.dir")+"\\extent-config.xml"));
	}
	
	@Test
	public void passTest() {
		logger = extent.startTest("passTest");
		Assert.assertTrue(true);
		logger.log(LogStatus.PASS, "Test case passed");
	}
	
	@Test
	public void failTest() {
		logger = extent.startTest("failTest");
		Assert.assertTrue(true);
		logger.log(LogStatus.FAIL, "Test case failed");
	}
	
	@Test
	public void skipTest() {
		logger = extent.startTest("skipTest");
		Assert.assertTrue(true);
		logger.log(LogStatus.SKIP, "Test case skipped");
	}
	
	@AfterMethod
	public void getResult(ITestResult result) {
		if(result.getStatus() == ITestResult.FAILURE) {
			logger.log(LogStatus.FAIL, "Test case failed is "+result.getName());
			logger.log(LogStatus.FAIL, "Test case failed is "+result.getThrowable());
		}
		else if(result.getStatus() == ITestResult.SKIP) {
			logger.log(LogStatus.SKIP, "Test case skipped is "+result.getName());
		}
		extent.endTest(logger);
	}
	
	@AfterTest
	public void endReport() {
		extent.flush();
		extent.close();
	}
}
