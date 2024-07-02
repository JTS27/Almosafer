package AlmosaferTestCases;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

public class HotelPageTestCases extends TestData{

	public void SelectHotelTest() {
		driver.findElement(By.xpath("//a[@data-rb-event-key='hotels']")).click();
		
		WebElement searchTab = driver.findElement(By.xpath("//input[@data-testid='AutoCompleteInput']"));
		
		if(driver.getCurrentUrl().contains("en")) {
			String []citesEng = {"Dubai","Jeddah","Riyadh"};
			int randIndex = rand.nextInt(citesEng.length);
			
			searchTab.sendKeys(citesEng[randIndex]);
			driver.findElement(By.xpath("//li[@data-testid='AutoCompleteResultItem0']")).click();
		}
		else {
			String []citesAr = {"جدة","دبي"};
			int randIndex = rand.nextInt(citesAr.length);
			
			searchTab.sendKeys(citesAr[randIndex]);
			driver.findElement(By.xpath("//li[@data-testid='AutoCompleteResultItem0']")).click();
		}
	}
	
	public void SelectNumOfPeopleTest() {
		WebElement selectorElement = driver.findElement(By.xpath("//select[@data-testid='HotelSearchBox__ReservationSelect_Select']"));
		Select mySelector = new Select(selectorElement);
		
		int randInd = rand.nextInt(2);
		mySelector.selectByIndex(randInd);
		
		driver.findElement(By.xpath("//button[@data-testid='HotelSearchBox__SearchButton']")).click(); 
	}
	
	public void CheckThePageIsFullyLoadedTest() {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofMinutes(2));
		
		WebElement resultTab = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//span[@data-testid='HotelSearchResult__resultsFoundCount']")));
		
		boolean ActualRes = resultTab.getText().contains("found")||resultTab.getText().contains("وجدنا");
		
		Assert.assertEquals(ActualRes, true);
	}
	
	public void SortItemsTest() throws InterruptedException {
		driver.findElement(By.xpath("//button[@data-testid='HotelSearchResult__sort__LOWEST_PRICE\']")).click();
		
		Thread.sleep(2000);
		
		WebElement pricesContainer = driver.findElement(By.cssSelector(".sc-htpNat.KtFsv.col-9"));
		
		List<WebElement> prices = pricesContainer.findElements(By.className("Price__Value"));
		
		String firstPriceStr = prices.get(0).getText();
		String lastPriceStr = prices.get(prices.size()-1).getText();
		
		int firstPrice = Integer.parseInt(firstPriceStr);
		int lastPrice = Integer.parseInt(lastPriceStr);
		
		Assert.assertEquals(firstPrice<lastPrice, true);
	}
}
