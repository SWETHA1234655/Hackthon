package PageObjects;

import java.time.Duration;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class TI_001_SelectCountryPage extends BasePage {
	
	public TI_001_SelectCountryPage(WebDriver driver) {
		super(driver);
	}
	//Declaration of WebDriverWait
	WebDriverWait wait=new WebDriverWait(driver,Duration.ofSeconds(10));
	//Declaration of actions class
	Actions act=new Actions(driver);
	//Declaration of javascriptExecutor
	JavascriptExecutor js=(JavascriptExecutor)driver;
	
	//Locators
	
	@FindBy(xpath="(//div[@class='prd-icon add shadowHandler short']//div/i)[7]")
	WebElement travelInsurance;
	
	@FindBy(xpath="//ul[@id='favourite-country']//li[4]")
	WebElement country;
	
	@FindBy(xpath="//button[@class='travel_main_cta']")
	WebElement next;
	
	//Actions
	//Method to click the travel insurance
	public void clickTravelInsurance() {
		
		wait.until(ExpectedConditions.visibilityOf(travelInsurance));
		js.executeScript("arguments[0].click();",travelInsurance);
	}
	//Method to choose the European country
	public void chooseCountry() throws InterruptedException {
		
		Thread.sleep(3000);
		wait.until(ExpectedConditions.visibilityOf(country));
		js.executeScript("arguments[0].click();",country);
	}
	//Method to click the next button
	public void clickNextButton() {
		wait.until(ExpectedConditions.visibilityOf(next));
		js.executeScript("arguments[0].click();",next);
	}
	

}
