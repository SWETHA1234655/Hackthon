package stepDefinition;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;

import PageObjects.*;
import factory.BaseClass;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import utilities.WriteExcel;

public class TravelInsurance {
	
//	WebDriver driver;
	TI_001_SelectCountryPage cp;
	TI_002_SelectDatePage dp;
	TI_003_SelectPeopleTravelPage tp;
	TI_004_CheckMedicalConditionPage mp;
	TI_005_PlanPage pp;
	
	@Given("Navigate to travel insurance page")
	public void navigateToTravelInsurancePage() throws IOException {
	    BaseClass.getLogger().info("************ Navigate to travel insurance page *************** ");
		cp=new TI_001_SelectCountryPage(BaseClass.getDriver());
		cp.clickTravelInsurance();
		WriteExcel.createExcel();
	}

	@When("Click on any european country as destination")
	public void clickOnAnyEuropeanCountry() throws InterruptedException {
		BaseClass.getLogger().info("************ Click on Any destination country *************** ");
		cp=new TI_001_SelectCountryPage(BaseClass.getDriver());
		cp.chooseCountry();
	}

	@When("Click on next to navigate date page")
	public void clickOnNextToNavigateDatePage() {
		BaseClass.getLogger().info("************ click on next page to navigate date page *************** ");
		cp=new TI_001_SelectCountryPage(BaseClass.getDriver());
		cp.clickNextButton();
	}

	@When("Select the date and click on Next")
	public void selectDateAndClickOnNext() throws InterruptedException {
		BaseClass.getLogger().info("************ choose the date and click on next *************** ");
		dp=new TI_002_SelectDatePage(BaseClass.getDriver());
		dp.clickStartDate();
		dp.chooseStartDate();
		dp.chooseEndDate();
		dp.clickNext();
	}

	@When("Select the number of travellers and enter the age and click on next")
	public void selectNoOfTravellersAndEnterAge() throws InterruptedException {
		BaseClass.getLogger().info("************ Select number of traveller and age and click on next *************** ");
		tp=new TI_003_SelectPeopleTravelPage(BaseClass.getDriver());
		tp.selectPeopleAge();
		
	}

	@When("Verify your Medical History and click on next")
	public void verifyTheMedicalHistory() throws InterruptedException {
		BaseClass.getLogger().info("************ Choose the medical history details *************** ");
		mp=new TI_004_CheckMedicalConditionPage(BaseClass.getDriver());
		mp.selectMedicalCondition();
	}
	
	@Then("Verify the sort by dropdown is visible")
	public void verifySortDropdownIsDisplay() throws InterruptedException {
		BaseClass.getLogger().info("************ The plan page is visible *************** ");
		TI_005_PlanPage pp=new TI_005_PlanPage(BaseClass.getDriver());
		Thread.sleep(3000);
		Assert.assertEquals(pp.verifySortIsVisible(),true);
		pp.clickSort();
	}
	
	@Then("Verify the premium low to high and click")
	public void verifyLowToHighClick() throws InterruptedException{
		BaseClass.getLogger().info("************ The premium low to hign is select *************** ");
		pp=new TI_005_PlanPage(BaseClass.getDriver());
		Thread.sleep(5000);
		pp.chooselowToHigh();
		Assert.assertEquals(pp.chooselowToHigh(),"Premium to high is selected");
	}
	@Then("Verify the insurance plans are visible")
	public void verifyPlanIsVisible() throws InterruptedException {
		pp=new TI_005_PlanPage(BaseClass.getDriver());
		Assert.assertEquals(pp.verifyPlansDisplay(), true);
	}
	@Then("Display three lowest international  travel insurance plan")
	public void displayThreeLowestInternationalPlan() throws InterruptedException {
		BaseClass.getLogger().info("************ The lowest international travel plan is displayed *************** ");
		pp=new TI_005_PlanPage(BaseClass.getDriver());
		try {
			pp.getPlanNameAndPrice();
			Assert.assertTrue(true);
		}
		catch(Exception e) {
			Assert.assertTrue(false);
		}
	}

}
