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
	
	@FindBy(xpath="//input[@id='ped_yes']")
	WebElement medicalCheck1;
	
	@FindBy(xpath="//button[normalize-space()='View plans']")
	WebElement viewPlan;
	
	//Actions
	//Method to select the medical conditions
	public void selectMedicalCondition() throws InterruptedException {
		//Thread.sleep(3000);
		wait.until(ExpectedConditions.visibilityOf(medicalCheck));
		medicalCheck.click();
		driver.navigate().to("https://travel.policybazaar.com/quotes?encp=UnhvUDQrYmF6YzZmeUttb2lWZHZlUT09&family=0&newpq=1&profiletypeid=1&sum_insured=d60&token=eyJhbGciOiJSUzI1NiIsInR5cCI6IkpXVCJ9.eyJpYXQiOjE3MTg5Njg2NzYsImp0aSI6IjMwNjhiYjc0LTNjZjMtNGZmZC05ZGZiLWU0ODg4ZDc0ZTQxOCIsIlByb3Bvc2VySUQiOiIzMjYyNDU0IiwibmJmIjoxNzE4OTY4Njc2LCJleHAiOjE3MjE1OTY2NzYsImlzcyI6InRyYXZlbC5wb2xpY3liYXphYXIuY29tIiwiYXVkIjoidHJhdmVsIn0.VD1PKQAlI0YtD4bPK51VcWFzDRpp0c7NViE76hRI1NLiXe3OlnRledaXGc_ka1ybUcCTYiS5vwHm0jZ0g8DQ8qPXmTnvP6INQT53voizA8GzKKpGcvS8kmwXR3xIiRCZe3nHA10s3B2xcomr_1CLg-rfaBpCQZfAI16CDoqC5MMpEKB9dYORNcxFNaIY0Y3MTYnFLZpDabCjrDLsDGmUp6TDHU_FbFXTPBaFPCuzLwiN6rjNMfhGZQ7iGNOVGIxMxxcaONIV_z8TK2kj6Ax2n8gIyy5h9pDjgoUYeie8LfNMFxFxXaLN_uv87NOeo0dOmBlFnCf6h99_yyiwHMprQA&utm_content=newpq&utm_term=newjourney&visa_type=d32");
		//Thread.sleep(3000);
	//	viewPlan.click();
	//	driver.navigate().to("https://tinyurl.com/4hjb84ms");
	}

	
}
