package stepDefinition;

import java.io.IOException;

import org.junit.Assert;
import PageObjects.*;
import factory.BaseClass;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import utilities.WriteExcel;

public class CarInsurance {
	
	@Given("Navigate to Car insurance page")
	public void navigateToCarInsurancePage() throws InterruptedException {
	    BaseClass.getLogger().info("********** Navigate to car insurance page **************** ");
		CI_001_CarHomePage chp=new CI_001_CarHomePage(BaseClass.getDriver());
		Thread.sleep(3000);
		chp.clickCarInsurance();
	}

	@When("Proceed without providing car number")
	public void proceedWithoutCarNumber() throws InterruptedException {
		BaseClass.getLogger().info("************ Proceed without providing car number *************** ");
		CI_001_CarHomePage chp=new CI_001_CarHomePage(BaseClass.getDriver());
		chp.clickNewBrandCar();
	}

	@When("Select city and RTO")
	public void selectCityAndRTO() throws InterruptedException {
		 BaseClass.getLogger().info("************ Select city and RTO number *************** ");
		CI_002_SelectCityAndRTOPage cr=new CI_002_SelectCityAndRTOPage(BaseClass.getDriver());
		cr.selectCity();
		cr.selectRTO();
		
	}

	@When("Select car brand")
	public void selectCarBrand() throws InterruptedException {
		BaseClass.getLogger().info("************ Select car brand *************** ");
		CI_003_SelectCarDetails cd=new CI_003_SelectCarDetails(BaseClass.getDriver());
		cd.selectCarBrand();
		
	}

	@When("Select car model")
	public void selectCarModel() throws InterruptedException {
		 BaseClass.getLogger().info("************ Select car model *************** ");
		CI_003_SelectCarDetails cd=new CI_003_SelectCarDetails(BaseClass.getDriver());
		cd.selectCarModel();
	}

	@When("Select car variant")
	public void selectCarVarient() throws InterruptedException {
		BaseClass.getLogger().info("************ Select car varient *************** ");
		CI_003_SelectCarDetails cd=new CI_003_SelectCarDetails(BaseClass.getDriver());
		cd.selectCarVarient();
	}
	
	@Then("Verify the user details page is displayed")
	public void verifyuserDetailsIsDisplayed() {
		 BaseClass.getLogger().info("************ Verify the user details page is displayed *************** ");
		CI_004_UserDetailsPage dp=new CI_004_UserDetailsPage(BaseClass.getDriver());
		Assert.assertEquals(dp.verifyuserDetailPage(),true);
	}
	
	@Then("Fill details with invalid phone number or e-mail")
	public void fillInvalidUserDetails() throws Exception {
		BaseClass.getLogger().info("************ Fill the invalid phone number or email *************** ");
		CI_004_UserDetailsPage dp=new CI_004_UserDetailsPage(BaseClass.getDriver());
		try {
			Thread.sleep(3000);
			dp.excel();
			dp.setName();
			dp.setMail();
			dp.setPhone();
			Assert.assertTrue(true);
		}
		catch(Exception e) {
			Assert.assertTrue(false);
		}
	}

	@Then("Print the error message displayed")
	public void printTheErrorMessage() throws Exception {
		BaseClass.getLogger().info("************ Print the error message *************** ");
		Thread.sleep(3000);
		CI_004_UserDetailsPage dp=new CI_004_UserDetailsPage(BaseClass.getDriver());
		String error=dp.getErrorMsg();
		System.out.println(error);
		WriteExcel.setCellData("Car Insurance", 1, 0,dp.getErrorMsg());
		Assert.assertEquals(error, "Enter a valid mobile number");
	}
}
