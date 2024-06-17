package PageObjects;

import java.time.Duration;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class TI_004_CheckMedicalConditionPage extends BasePage {
	
	public TI_004_CheckMedicalConditionPage(WebDriver driver) {
		super(driver);
	}
	
	WebDriverWait wait=new WebDriverWait(driver,Duration.ofSeconds(10));
	Actions act=new Actions(driver);
	JavascriptExecutor js=(JavascriptExecutor)driver;
	
	//Locators
	
	@FindBy(xpath="//input[@id='ped_no']")
	WebElement medicalCheck;
	
	//Actions
	//Method to select the medical conditions
	public void selectMedicalCondition() {
		wait.until(ExpectedConditions.visibilityOf(medicalCheck));
		medicalCheck.click();
	}
}
