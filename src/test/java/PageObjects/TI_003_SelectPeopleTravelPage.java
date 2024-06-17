package PageObjects;

import java.time.Duration;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class TI_003_SelectPeopleTravelPage extends BasePage{
	
	//constructor
	public TI_003_SelectPeopleTravelPage(WebDriver driver) {
		super(driver);
	}
	//Declaration of WebDriverWait
	WebDriverWait wait=new WebDriverWait(driver,Duration.ofSeconds(30));
	//Declaration of actions class
	Actions act=new Actions(driver);
	//Declaration of javascriptExecutor
	JavascriptExecutor js=(JavascriptExecutor)driver;
	
	//Locators
	@FindBy(xpath="(//div[@class='memSelectRadioWrapper__radio'])[2]")
	WebElement people;
	
	@FindBy(xpath="//div[contains(text(),'Select age of traveller 1')]")
	WebElement select_age1;
		
	@FindBy(xpath="//div[@id='optionBox_0_wrapper']/div[23]")
	WebElement age1;
	
	@FindBy(xpath="//div[contains(text(),'Select age of traveller 2')]")
	WebElement select_age2;
	
	@FindBy(xpath="//div[@id='optionBox_1_wrapper']/div[24]")
	WebElement age2;
	
	@FindBy(xpath="//button[@class='travel_main_cta']")
	WebElement next2;
	
	//Actions
	//Method to select the persons age
	public void selectPeopleAge() throws InterruptedException {
		
		wait.until(ExpectedConditions.visibilityOf(people));
		people.click();
		
		wait.until(ExpectedConditions.visibilityOf(select_age1));
		select_age1.click();
		
		wait.until(ExpectedConditions.elementToBeClickable(age1));
		Thread.sleep(3000);
		age1.click();
		
		wait.until(ExpectedConditions.visibilityOf(select_age2));
		select_age2.click();
		
		wait.until(ExpectedConditions.visibilityOf(age2));
		Thread.sleep(3000);
		age2.click();
		
		wait.until(ExpectedConditions.visibilityOf(next2));
		next2.click();
	}
}
