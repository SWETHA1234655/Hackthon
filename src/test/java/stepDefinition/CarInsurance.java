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
	
	CI_001_CarHomePage chp;
	CI_002_SelectCityAndRTOPage cr;
	CI_003_SelectCarDetails cd;
	CI_004_UserDetailsPage dp;
	
	@Given("Navigate to Car insurance page")
	public void navigateToCarInsurancePage() throws InterruptedException {
	    BaseClass.getLogger().info("********** Navigate to car insurance page **************** ");
	    chp=new CI_001_CarHomePage(BaseClass.getDriver());
		Thread.sleep(3000);
		chp.clickCarInsurance();
	}

	@When("Proceed without providing car number")
	public void proceedWithoutCarNumber() throws InterruptedException {
		BaseClass.getLogger().info("************ Proceed without providing car number *************** ");
		chp=new CI_001_CarHomePage(BaseClass.getDriver());
		chp.clickNewBrandCar();
	}

	@When("Select city and RTO")
	public void selectCityAndRTO() throws InterruptedException {
		BaseClass.getLogger().info("************ Select city and RTO number *************** ");
	    cr=new CI_002_SelectCityAndRTOPage(BaseClass.getDriver());
		cr.selectCity();
		cr.selectRTO();
		
	}

	@When("Select car brand")
	public void selectCarBrand() throws InterruptedException {
		BaseClass.getLogger().info("************ Select car brand *************** ");
		cd=new CI_003_SelectCarDetails(BaseClass.getDriver());
		cd.selectCarBrand();
		
	}

	@When("Select car model")
	public void selectCarModel() throws InterruptedException {
		 BaseClass.getLogger().info("************ Select car model *************** ");
	     cd=new CI_003_SelectCarDetails(BaseClass.getDriver());
		 cd.selectCarModel();
	}

	@When("Select car variant")
	public void selectCarVarient() throws InterruptedException {
		BaseClass.getLogger().info("************ Select car varient *************** ");
		cd=new CI_003_SelectCarDetails(BaseClass.getDriver());
		cd.selectCarVarient();
	}
	
	@Then("Verify the user details page is displayed")
	public void verifyuserDetailsIsDisplayed() {
		 BaseClass.getLogger().info("************ Verify the user details page is displayed *************** ");
		 dp=new CI_004_UserDetailsPage(BaseClass.getDriver());
		 Assert.assertEquals(dp.verifyuserDetailPage(),true);
	}
	
	@Then("Fill details with invalid phone number or e-mail")
	public void fillInvalidUserDetails() throws Exception {
		BaseClass.getLogger().info("************ Fill the invalid phone number or email *************** ");
		dp=new CI_004_UserDetailsPage(BaseClass.getDriver());
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
		dp=new CI_004_UserDetailsPage(BaseClass.getDriver());
		String error=dp.getErrorMsg();
		System.out.println(error);
		WriteExcel.setCellData("Car Insurance", 1, 0,dp.getErrorMsg());
		Assert.assertEquals(error, "Enter a valid mobile number");
	}
}
