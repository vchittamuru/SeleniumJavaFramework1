import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BrowserTest {

	public static void main(String[] args) {

		//	System.setProperty("webdriver.gecko.driver", "D:\\JavaProjects\\SeleniumJavaFramework\\drivers\\GeckoDriver\\geckodriver.exe");

		//WebDriver driver = new FirefoxDriver();

		WebDriverManager.chromedriver().setup();

		
		WebDriver driver= new ChromeDriver();


		driver.get("https://sakshi.com/");
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		driver.close();
		driver.quit();
	}

}
