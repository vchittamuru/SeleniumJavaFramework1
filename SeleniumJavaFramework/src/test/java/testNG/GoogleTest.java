package testNG;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;

import io.github.bonigarcia.wdm.WebDriverManager;

public class GoogleTest {

	WebDriver driver;
	ExtentHtmlReporter htmlReporter;
	ExtentReports extent;

	@BeforeMethod
	public void setup()
	{

		htmlReporter = new ExtentHtmlReporter("extent.html");

		// create ExtentReports and attach reporter(s)
		extent = new ExtentReports();
		extent.attachReporter(htmlReporter);

		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.get("https://www.google.com/");

		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);

	}

	@Test
	public void venkyTest() throws IOException
	{
		// creates a toggle for the given test, adds all log events under it    
		ExtentTest test = extent.createTest("MyFirstTest", "Sample description");

		// log(Status, details)
		test.log(Status.INFO, "This step shows usage of log(status, details)");

		// info(details)
		test.info("This step shows usage of info(details)");

		// log with snapshot
		test.fail("details", MediaEntityBuilder.createScreenCaptureFromPath("screenshot.png").build());

		// test with snapshot
		test.addScreenCaptureFromPath("screenshot.png");
	}



	@Test(priority=2,groups="title")
	public void googleTitileTest()
	{
		String title= driver.getTitle();
		System.out.println(title);
	}


	@Test(priority=3,groups="logo")
	public void googleLogoTest()
	{
		boolean b= driver.findElement(By.xpath("//img[@alt='Googl']")).isDisplayed();
	}


	@Test(priority=1,groups="test")
	public void test1()
	{
		System.out.println("test 1");
	}


	@Test(priority=4,groups="test")
	public void test2()
	{
		System.out.println("test 2");
	}



	@AfterMethod
	public void tearDown()
	{
		extent.flush();
		driver.quit();
	}

}
