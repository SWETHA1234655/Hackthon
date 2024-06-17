package PageObjects;

import java.io.IOException;
import java.time.Duration;
import java.util.List;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import utilities.WriteExcel;

public class TI_005_PlanPage extends BasePage {
	
	public TI_005_PlanPage(WebDriver driver) {
		super(driver);
	}
	
	//Declaration of WebDriverWait
	WebDriverWait wait=new WebDriverWait(driver,Duration.ofSeconds(10));
	//Declaration of Actions class
	Actions act=new Actions(driver);
	//Declaration of javascriptExecutor
	JavascriptExecutor js=(JavascriptExecutor)driver;
	
	//Locators
	@FindBy(xpath="//p[@class='filter_name_heading']")
	WebElement sort;
	
	@FindBy(xpath="//input[@value='Premium low to high']")
	WebElement chooseLTH;
	
	@FindBy(xpath="(//div[@class='cardWrapper__showMore '])[1]")
	WebElement clickShowMore;
	
	@FindBy(xpath="//*[@id=\"root\"]/div/div[2]/section/article/div/div/div/div/div")
	List<WebElement> plans;
	
	@FindBy(xpath="//div[@class='quotesCard__cta familyPlanPriceContainer']//span")
	List<WebElement> price;
	
	//Actions
	//Method to verify the plan page
	public boolean verifySortIsVisible() throws InterruptedException {
		Thread.sleep(3000);
		wait.until(ExpectedConditions.visibilityOf(sort));
		if(sort.isDisplayed()) {
			return true;
		}
		else {
			return false;
		}
		
	}
	//Method to click the sort
	public void clickSort() throws InterruptedException {
		Thread.sleep(3000);
		wait.until(ExpectedConditions.visibilityOf(sort));
		sort.click();
	}
	//Method to choose the premium low to high
	public String chooselowToHigh() throws InterruptedException {
		Thread.sleep(5000);
		wait.until(ExpectedConditions.visibilityOf(chooseLTH));
		chooseLTH.click();
		if(chooseLTH.isSelected()) {
			return "Premium to high is selected"; 
		}
		else {
			return "Premium to high is selected"; 
		}
	}
	//Method to verify the plan page is display
	public boolean verifyPlansDisplay() throws InterruptedException {
		Thread.sleep(3000);
		return clickShowMore.isDisplayed();
	}

	//Method to get the plan name and price
	public void  getPlanNameAndPrice() throws IOException {
		int row=1,row1=1;
		for(int i=0;i<3;i++) {
			System.out.println("Plan Name :"+plans.get(i).getText());
			System.out.println("Price :"+price.get(i).getText());
			WriteExcel.setCellData("Travel Insurance", row, 0,plans.get(i).getText());
			WriteExcel.setCellData("Travel Insurance", row1, 1,price.get(i).getText());
			row++;
			row1++;
		}
	}
}
