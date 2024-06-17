package PageObjects;

import java.io.IOException;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import utilities.WriteExcel;

public class HI_002_HealthInsuranceMenuPage extends BasePage {
	
	public HI_002_HealthInsuranceMenuPage(WebDriver driver) {
		super(driver);
	}
	
	//Declaration of WebDriverWait
	WebDriverWait wait=new WebDriverWait(driver,Duration.ofSeconds(10));
	//Declaration of Actions class
	Actions act=new Actions(driver);
	
	//Locators
	@FindBy(xpath="//div[@class='hide-nav hide-mobile-link onlydesktop']")
	WebElement healthMenu;
	
	@FindBy(xpath="(//ul[@class='dropdown-menu min'])[3]//li")
	List<WebElement> menuItem;
	
	//Method to verify the health insurance page
	public boolean verifyHealthPage() throws InterruptedException {
		Thread.sleep(2000);	
		if( healthMenu.isDisplayed()) {
			return true;
		}
		else {
			return false;
		}
	//	return healthMenu.isDisplayed();
	}
	
	//Method to click the health insurance menu
	public String clickHealthMenu() {
		try {
			wait.until(ExpectedConditions.visibilityOf(healthMenu));
			act.moveToElement(healthMenu).perform();
			return "Health menu hovered successfully";
		}
		catch(Exception e) {
			return "Health menu is not hovered";
		}
		
	}
	//Method to get the menu items
	public String getMenuItem() throws IOException {
		try {
			int i=1;
			for(WebElement item:menuItem) {
				String menu=item.getText();
				System.out.println(menu);
				WriteExcel.setCellData("Health Insurance", i, 0,menu );
				i++;
				
			}
			return "Menu item are retrived successfully";
		}
		catch(Exception e) {
			return "Menu item not retrived";
		}
	}
	

}
