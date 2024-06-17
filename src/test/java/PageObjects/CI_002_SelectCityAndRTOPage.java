package PageObjects;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class CI_002_SelectCityAndRTOPage extends BasePage {
	
	public CI_002_SelectCityAndRTOPage(WebDriver driver) {
		super(driver);
	}
	
	//Declaration of WebDriverWait
	WebDriverWait wait=new WebDriverWait(driver,Duration.ofSeconds(10));
	
	//Locators
	@FindBy(xpath="//ul//li[3]")
	WebElement city;
	
	@FindBy(xpath="//ul[@class='CityRTO_rtoList__Plo2H']//li[3]")
	WebElement cityRTO;
	
	//Actions
	//Method to select the city
	public void selectCity() throws InterruptedException {
		Thread.sleep(3000);
		wait.until(ExpectedConditions.visibilityOf(city));
		city.click();
	}
	//Method to select the RTO
	public void selectRTO() throws InterruptedException {
		Thread.sleep(3000);
		wait.until(ExpectedConditions.visibilityOf(cityRTO));
		cityRTO.click();
	}
	

}
