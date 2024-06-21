package PageObjects;

import java.time.Duration;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class HI_001_HealthHomePage extends BasePage {
	
	public HI_001_HealthHomePage (WebDriver driver) {
		super(driver);
	}
	//Declaration of WebDriverWait
	WebDriverWait wait=new WebDriverWait(driver,Duration.ofSeconds(10));
	//Declaration of Actions class
	Actions act=new Actions(driver);
	
	//Locators
	@FindBy(xpath="//li[@class='ruby-menu-mega shade mr']/a")
	WebElement insuranceProducts;
	
	@FindBy(xpath="(//a[@class='headlink'])[4]")
	WebElement healthInsurance;
	
	//Actions
	//Method to click the Insurance products
	public void clickInsProducts() {
		wait.until(ExpectedConditions.visibilityOf(insuranceProducts));
		act.moveToElement(insuranceProducts).perform();
	}
	//Method to click the health insurance
	public void clickHealthInsurance() {
		wait.until(ExpectedConditions.visibilityOf(healthInsurance));
		healthInsurance.click();
	}
	
	

}
