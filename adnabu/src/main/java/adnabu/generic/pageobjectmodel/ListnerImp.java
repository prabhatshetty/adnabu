package adnabu.generic.pageobjectmodel;

import java.io.File;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

import adnabu.utils.WebDriverActions;

public class ListnerImp implements ITestListener

{

	public static ExtentReports extent;
	public static ExtentSparkReporter spark;
	public static ExtentTest test;


	public void onTestStart(ITestResult result) {
		// TODO Auto-generated method stub
		result.getMethod().getMethodName();
		test = extent.createTest("Name of the Test is "+result.getMethod().getMethodName()+"");

	}

	public void onTestSuccess(ITestResult result) {
		// TODO Auto-generated method stub

	}

	public void onTestFailure(ITestResult result) {
		// TODO Auto-generated method stub
		String failedTc = result.getMethod().getMethodName();
		LocalDateTime currentDateTime = LocalDateTime.now();

		// Format the date and time using a specific pattern (optional)
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
		String formattedDateTime = currentDateTime.format(formatter);
		TakesScreenshot ts = (TakesScreenshot)WebDriverActions.driver;
		
		String base64path = ts.getScreenshotAs(OutputType.BASE64);
		test.addScreenCaptureFromBase64String(base64path);
		File srcImg = ts.getScreenshotAs(OutputType.FILE);
		
		File destImg = new File("./Screenshot/"+failedTc+".png");	
		try{
			FileUtils.copyFile(srcImg, destImg);

		}catch (IOException e)
		{
			e.printStackTrace();


		}
	
		//fetch the exception and print
		Throwable throwable = result.getThrowable();
		test.fail(throwable.getMessage());
		



	}



	public void onTestSkipped(ITestResult result) {
		// TODO Auto-generated method stub

	}

	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
		// TODO Auto-generated method stub

	}

	public void onTestFailedWithTimeout(ITestResult result) {
		// TODO Auto-generated method stub

	}

	public void onStart(ITestContext context) {
		// TODO Auto-generated method stub
		extent = new ExtentReports();
		spark = new ExtentSparkReporter("Extentreport.html");
		spark.config().setDocumentTitle("Automation report");
		spark.config().setTheme(Theme.DARK);
		extent.setSystemInfo("Browser", "Chrome 118");
		extent.attachReporter(spark);

	}

	public void onFinish(ITestContext context) {
		// TODO Auto-generated method stub
		extent.flush();

	}

}
