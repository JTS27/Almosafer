package AlmosaferTestCases;

import java.time.Duration;
import java.time.LocalDate;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

public class MainPageTestCases extends TestData{

	public void CheckLangTest() {
		WebElement htmlTag = driver.findElement(By.tagName("html"));
		
		String ActualLangTag = htmlTag.getAttribute("lang");
		
		Assert.assertEquals(ActualLangTag, ExpectedEngLangTag);
		
	}
	
	public void CheckCurrencyTest() {
		String ActualCurrency = driver.findElement(By.xpath("//button[@data-testid = 'Header__CurrencySelector']")).getText();
		
		Assert.assertEquals(ActualCurrency, ExpectedCurrency);
	}
	
	public void CheckContactNumberTest() {
		String ActualContactNumber = driver.findElement(By.tagName("strong")).getText();
		
		Assert.assertEquals(ActualContactNumber, ExpectedContactNumber);
	}
	
	
	public void IsQitafLogoDisplaiedTest() {
		WebElement theFooter = driver.findElement(By.tagName("footer"));
		
		boolean ActualLogoDisplaied = theFooter.findElement(By.cssSelector(".sc-bdVaJa.bxRSiR.sc-ekulBa.eYboXF")).isDisplayed();
		
		Assert.assertEquals(ActualLogoDisplaied, true);
	}

	public void CheckHotelNotSelcetedDefaultTest() {
		String expectedValue = "false";
		String actualValue =  driver.findElement(By.xpath("//a[@data-rb-event-key='hotels']")).getAttribute("aria-selected");
		
		Assert.assertEquals(expectedValue, actualValue);
	}
	
	public void CheckFlightDepartureAndFlightReturn() {
		LocalDate today = LocalDate.now();
		
		int expectedDepDate = today.plusDays(1).getDayOfMonth();
		int expectedRetDate = today.plusDays(2).getDayOfMonth();
		
		String depDate = driver.findElement(By.cssSelector("div[class='sc-iHhHRJ sc-kqlzXE blwiEW'] span[class='sc-cPuPxo LiroG']")).getText();
		String retDate = driver.findElement(By.cssSelector("div[class='sc-iHhHRJ sc-OxbzP edzUwL'] span[class='sc-cPuPxo LiroG']")).getText();

		int ActualDepDate = Integer.parseInt(depDate);
		int ActualRetDate = Integer.parseInt(retDate);
		
		Assert.assertEquals(expectedDepDate, ActualDepDate);
		Assert.assertEquals(expectedRetDate, ActualRetDate);
	}

	public void ChangeTheLanguageOfWebsiteRandomlyTest() {
		String [] websites = {"https://www.almosafer.com/en","https://www.almosafer.com/ar"};
		int randomIndex = rand.nextInt(websites.length);
		driver.get(websites[randomIndex]);
		
		if(driver.getCurrentUrl().contains("en")) {
			WebElement htmlTag = driver.findElement(By.tagName("html"));
			
			String ActualLangTag = htmlTag.getAttribute("lang");
			
			Assert.assertEquals(ActualLangTag, ExpectedEngLangTag);
		}
		else {
			WebElement htmlTag = driver.findElement(By.tagName("html"));
			
			String ActualLangTag = htmlTag.getAttribute("lang");
			
			Assert.assertEquals(ActualLangTag, ExpectedArLangTag);
		}
	}
	
	



}
