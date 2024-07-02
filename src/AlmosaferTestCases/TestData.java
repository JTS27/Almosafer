package AlmosaferTestCases;

import java.time.Duration;
import java.util.Random;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;

public class TestData {

	protected static WebDriver driver;
	
	String Url = "https://global.almosafer.com/en";
	String ExpectedEngLangTag = "en";
	String ExpectedArLangTag = "ar";
	String ExpectedCurrency = "SAR";
	String ExpectedContactNumber = "+966554400000";
	Random rand = new Random();

	@BeforeSuite
	public void setup() {
		if(driver == null) {
			driver = new ChromeDriver();
			driver.manage().window().maximize();
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		}
	}
	
	@AfterSuite
	public void tearDown() {
		if(driver != null) {
			driver.quit();
			driver = null;
		}
	}
	
	public void TheDefaultConfiguration() {
		driver.get(Url);
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		driver.findElement(By.cssSelector(".sc-jTzLTM.hQpNle.cta__button.cta__saudi.btn.btn-primary")).click();

	}
	
	
	
}
