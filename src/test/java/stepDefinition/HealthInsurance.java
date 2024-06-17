package stepDefinition;

import java.io.IOException;
import org.junit.Assert;
import PageObjects.*;
import factory.BaseClass;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import utilities.WriteExcel;

public class HealthInsurance {
	
	@Given("The user click on Insurance products menu")
	public void clickInsuranceProductsMenu() throws IOException {
		BaseClass.getLogger().info("************ Click insurance products menu *************** ");
		HI_001_HealthHomePage hhp=new HI_001_HealthHomePage(BaseClass.getDriver());
		hhp.clickInsProducts();
	}

	@When("Navigate the health insurance page")
	public void navigateHealthInsurancePage() {
		BaseClass.getLogger().info("************ Navigate to Health insurance page *************** ");
		HI_001_HealthHomePage hhp=new HI_001_HealthHomePage(BaseClass.getDriver());
		hhp.clickHealthInsurance();
	}
	
	@Then("verify the health insurance page is displayed")
	public void verifyHealthInsurancePageIsDisplayed() throws InterruptedException {
		BaseClass.getLogger().info("************ verify the health insurance page is displayed *************** ");
		HI_002_HealthInsuranceMenuPage mp=new HI_002_HealthInsuranceMenuPage(BaseClass.getDriver());
		Assert.assertEquals(mp.verifyHealthPage(),true);
		
	}

	@Then("Hover the health insurance menu")
	public void hoverHealthInsuranceMenu() {
		BaseClass.getLogger().info("************ hover the health insurance menu *************** ");
		HI_002_HealthInsuranceMenuPage mp=new HI_002_HealthInsuranceMenuPage(BaseClass.getDriver());
		Assert.assertEquals(mp.clickHealthMenu(),"Health menu hovered successfully");
	
	}

	@Then("Retrieve all the sub menus as list and print them")
	public void retrieveTheSubMenuItems() throws IOException {
		BaseClass.getLogger().info("************ Retrieve all the sub menus successfully *************** ");
		HI_002_HealthInsuranceMenuPage mp=new HI_002_HealthInsuranceMenuPage(BaseClass.getDriver());
		Assert.assertEquals(mp.getMenuItem(), "Menu item are retrived successfully");;
	}

}
