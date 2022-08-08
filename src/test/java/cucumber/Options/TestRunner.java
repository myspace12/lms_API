package cucumber.Options;

import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
	@CucumberOptions(features="src/test/java/features",glue= "stepdefinitions",
	                  plugin= {"html:target/Cucumber.html",
			                    "json:target/Cucumber.json","com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:",
			                     "rerun:target/failedScenarios.txt"})

	public class TestRunner {


}
