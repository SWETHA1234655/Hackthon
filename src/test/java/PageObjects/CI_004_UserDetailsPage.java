package PageObjects;

import java.io.IOException;
import java.time.Duration;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import utilities.DataReader;
import utilities.WriteExcel;

public class CI_004_UserDetailsPage extends BasePage {
	
	public CI_004_UserDetailsPage(WebDriver driver) {
		super(driver);
	}
	WebDriverWait wait=new WebDriverWait(driver,Duration.ofSeconds(10));
	
	//Locators
	@FindBy(xpath="//input[@placeholder='Full name']")
	WebElement f_name;
	
	@FindBy(xpath="//input[@placeholder='Your email']")
	WebElement mail;
	
	@FindBy(xpath="//input[@placeholder='Mobile number']")
	WebElement phoneNo;
	
	@FindBy(xpath="//div[@class='errorMsg']")
	WebElement errormsg;
	
	//Actions
	
	//Method to get the excel data
	public static void excel() throws Exception {
		DataReader.ExcelData();
	}
	//Method to verify the user details page
	public boolean verifyuserDetailPage() {
		return f_name.isDisplayed();
		
	}
	//Method to set the user name
	public void setName() throws InterruptedException {
		Thread.sleep(3000);
		wait.until(ExpectedConditions.visibilityOf(f_name));
		f_name.sendKeys(DataReader.Name);
	}
	//Method to set the user mail id
	public void setMail() {
		wait.until(ExpectedConditions.visibilityOf(mail));
		mail.sendKeys(DataReader.E_Mail);
	}
	//Method to set the user phone number
	public void setPhone() {
		wait.until(ExpectedConditions.visibilityOf(phoneNo));
		phoneNo.sendKeys(DataReader.Phone_No);
		
	}
	//Method to get the error message
	public String getErrorMsg() throws IOException {
		wait.until(ExpectedConditions.visibilityOf(errormsg));
		//String errorM=errormsg.getText();
		//WriteExcel.setCellData("Car Insurance", 1, 0, errorM);
		return errormsg.getText();
		
		
	}
	
}
