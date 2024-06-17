package PageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

//BasePage class that serves as the foundation for all page objects.
public class BasePage {
	
	WebDriver driver;
	//Costructor
	public BasePage(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver,this);
	}

}
