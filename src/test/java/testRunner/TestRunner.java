package testRunner;

import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

//Defines the JUnit runner class to run Cucumber tests.
@RunWith(Cucumber.class)
//To reference the location of feature files and step definitions.
@CucumberOptions(
			
	//	features={".//featureFiles/Feature_003_HealthInsurance.feature",".//featureFiles/Feature_002_CarInsurance.feature"},
	//	features= {".//featureFiles/Feature_001_TravelInsurance.feature"},
		
		//Points to the directory where the feature files are located.
		features= {".//featureFiles"},
		//Specifies the package with step definition classes.
		glue="stepDefinition",
		//Defines various plugins for report
		plugin= {"pretty", "html:reports/myreport.html", 
				  "rerun:target/rerun.txt",
				  "com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:"
				},
		dryRun=false,// checks mapping between scenario steps and step definition methods
		monochrome=true,// to avoid junk characters in output
		publish=true // to publish report in cucumber server
		)

public class TestRunner {
	
}
