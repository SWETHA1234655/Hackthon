package PageObjects;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class CI_003_SelectCarDetails extends BasePage {
	
	public CI_003_SelectCarDetails(WebDriver driver) {
		super(driver);
	}
	//Declaration of WebDriverWait
	WebDriverWait wait=new WebDriverWait(driver,Duration.ofSeconds(10));
	
	//Locators
	@FindBy(xpath="//div[@class='animationWrap']//ul//li[8]")
	WebElement carBrand;
	
	@FindBy(xpath="//div[@class='animationWrap']//ul//li[6]")
	WebElement carModel;
	
	@FindBy(xpath="//div[@class='animationWrap']//ul//li[3]")
	WebElement carVarient; 
	
	//Actions
	//Method to select the car brand name
	public void selectCarBrand() throws InterruptedException {
		Thread.sleep(3000);
		wait.until(ExpectedConditions.visibilityOf(carBrand));
		carBrand.click();
	}
	//Method to select the model model
	public void selectCarModel() throws InterruptedException {
		Thread.sleep(3000);
		wait.until(ExpectedConditions.visibilityOf(carModel));
		carModel.click();
	}
	//Method to select the car varient
	public void selectCarVarient() throws InterruptedException {
		Thread.sleep(3000);
		wait.until(ExpectedConditions.visibilityOf(carVarient));
		carVarient.click();
	}
	
}
