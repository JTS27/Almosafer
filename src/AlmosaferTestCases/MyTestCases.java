package AlmosaferTestCases;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class MyTestCases extends TestData{
	
	MainPageTestCases TC = new MainPageTestCases();
	HotelPageTestCases HTC = new HotelPageTestCases();
	
	@BeforeTest
	public void mySetup() {
		TheDefaultConfiguration();
		
	}
	
	@Test (priority = 1 , enabled = true ,description = "MainPageTest")
	public void CheckLang() {
		TC.CheckLangTest();
	}
	
	@Test (priority = 2 , enabled = true)
	public void CheckCurrency() {
		TC.CheckCurrencyTest();
	}
	
	@Test (priority = 3 , enabled = true)
	public void CheckContactNumber() {
		TC.CheckContactNumberTest();
	}
	
	@Test (priority = 4 , enabled = true)
	public void IsQitafLogoDisplaied() {
		TC.IsQitafLogoDisplaiedTest();
	}
	
	@Test (priority = 5 , enabled = true)
	public void CheckHotelNotSelcetedDefault() {
		TC.CheckHotelNotSelcetedDefaultTest();
	}
	
	@Test (priority = 6 , enabled = true)
	public void CheckFlightDepartureAndFlightReturn() {
		TC.CheckFlightDepartureAndFlightReturn();
	}
	
	@Test (priority = 7 , enabled = true)
	public void ChangeTheLanguageOfWebsiteRandomly() {
		TC.ChangeTheLanguageOfWebsiteRandomlyTest();
	}
	
	@Test (priority = 8 , enabled = true)
	public void SelectHotel() {
		HTC.SelectHotelTest();
	}
	
	@Test (priority = 10 , enabled = true)
	public void SelectNumOfPeople() {
		HTC.SelectNumOfPeopleTest();
	}
	
	@Test (priority = 11 , enabled = true)
	public void CheckThePageIsFullyLoaded() {
		HTC.CheckThePageIsFullyLoadedTest();
	}
	
	@Test (priority = 12 , enabled = true)
	public void SortItems() throws InterruptedException {
		HTC.SortItemsTest();
	}
	
	
}
