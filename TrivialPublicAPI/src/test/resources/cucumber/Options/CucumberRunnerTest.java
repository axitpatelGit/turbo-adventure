package cucumber.Options;

import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions(
		features="src/test/resources/features",
		glue= {"stepDefinations"},
		plugin = {"pretty","json:target/cucumber-reports/reports.json",

			            "junit:target/cucumber-reports/Cucumber.xml",

			            "html:target/cucumber-reports/reports2.html"},
		monochrome = true
		)
public class CucumberRunnerTest {
}
