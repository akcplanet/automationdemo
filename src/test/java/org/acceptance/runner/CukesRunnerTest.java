package org.acceptance.runner;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions( plugin = {"html:target/cucumber-html-report",
        "json:target/Report_CUST.json", "pretty:target/cucumber-pretty.txt",
        "usage:target/cucumber-usage.json", "junit:target/cucumber-results.xml"},
		glue = "org.acceptance.steps",
		features = "classpath:features/demo.feature")
public class CukesRunnerTest  {

}
