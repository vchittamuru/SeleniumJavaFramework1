package test;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;

import io.github.bonigarcia.wdm.WebDriverManager;

public class ExtentReportsBasixDemo {

	//private static WebDriver driver=null;
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		// start reporters
        ExtentHtmlReporter htmlReporter = new ExtentHtmlReporter("extent.html");

        
     // create ExtentReports and attach reporter(s)
        ExtentReports extent = new ExtentReports();
        extent.attachReporter(htmlReporter);
        
        
     // creates a toggle for the given test, adds all log events under it    
        ExtentTest test1 = extent.createTest("Google Search Test one", "Test to validate google text functionality");
        

		WebDriverManager.chromedriver().setup();

		WebDriver driver= new ChromeDriver();
		
		
		// log(Status, details)
        test1.log(Status.INFO, "starting test case");

		
		driver.get("https://www.google.com/");
		
		test1.pass("Navigated to google");
		
		driver.findElement(By.name("q")).sendKeys("selenium");
		test1.pass("Entered text in textbox");
		
		driver.findElement(By.name("btnK")).sendKeys(Keys.RETURN);
		test1.pass("clicked search button");
			
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		driver.close();
		driver.quit();
		
		test1.pass("closed the browser");
		
		test1.info("test completed");
		
		extent.flush();
        
	}

}
