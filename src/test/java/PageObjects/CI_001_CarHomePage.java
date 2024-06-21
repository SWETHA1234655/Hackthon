package PageObjects;

import java.time.Duration;


import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class CI_001_CarHomePage extends BasePage {
	
	// Constructor to initialize the driver from the BasePage class
	public CI_001_CarHomePage(WebDriver driver) {
		super(driver);
	}
	//Declaration of webdriverWait
	WebDriverWait wait=new WebDriverWait(driver,Duration.ofSeconds(10));
	//Declaration of javascriptExecuttor
	JavascriptExecutor js=(JavascriptExecutor)driver;
	
	//Locators
	@FindBy(xpath="(//div[@class='prd-icon add shadowHandler short']//div/i)[4]")
	WebElement carInsurance;
	
	@FindBy(xpath="//span[@class='CarRegDetails_blueTextButton__P1blP blueTextButton fontMedium']")
	WebElement clickNewCar;
	
	//Actions
	
	//Method to click the car insurance
	public void clickCarInsurance() {
		wait.until(ExpectedConditions.visibilityOf(carInsurance));
		js.executeScript("arguments[0].click();",carInsurance);
	}
	//method to click xthe new brand car
	public void clickNewBrandCar() throws InterruptedException {
		//Thread.sleep(2000);
		wait.until(ExpectedConditions.visibilityOf(clickNewCar));
		clickNewCar.click();
	}
	
	
}
