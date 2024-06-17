package PageObjects;

import java.time.Duration;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class TI_002_SelectDatePage extends BasePage {
	
	public TI_002_SelectDatePage(WebDriver driver) {
		super(driver);
	}
	//Declaration of WebDriverWait
	WebDriverWait wait=new WebDriverWait(driver,Duration.ofSeconds(10));
	//Declaration of Actions class
	Actions act=new Actions(driver);
	//Declaration of javascriptExecutor
	JavascriptExecutor js=(JavascriptExecutor)driver;
	
	//Locators
	@FindBy(xpath="//div[@class='MuiPickersDateRangePickerInput-root']//div[1]//div[1]//div[1]")
	WebElement startDate;
	
	@FindBy(xpath="(//div[@class='MuiPickersDesktopDateRangeCalendar-root']/div[1]//div[@class='MuiPickersCalendar-week'])[5]/div[5]")
	WebElement sDate;
	
	@FindBy(xpath="(//div[@class='MuiPickersDesktopDateRangeCalendar-root']/div[2]//div[@class='MuiPickersCalendar-week'])[4]/div[6]")
	WebElement eDate;
	
	@FindBy(xpath="//button[@class='travel_main_cta']")
	WebElement next1;
	
	//Actions
	//Method to click the start date
	public void clickStartDate() throws InterruptedException {
		Thread.sleep(3000);
		wait.until(ExpectedConditions.visibilityOf(startDate));
		startDate.click();
	}
	//Method to choose the start date
	public void chooseStartDate() {
		
		wait.until(ExpectedConditions.visibilityOf(sDate));
		sDate.click();
	}
	//Method to choose the end date
	public void chooseEndDate() {
		
		wait.until(ExpectedConditions.visibilityOf(eDate));
		eDate.click();
	}
	//Method to click the next button
	public void clickNext() {
		next1.click();
	}

}
