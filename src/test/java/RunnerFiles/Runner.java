package RunnerFiles;

import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;


@RunWith(Cucumber.class)
@CucumberOptions(features="src/test/resources/Features/Scripts.feature",glue= {"StepDef"},
				 monochrome = true,plugin={"pretty","html:target/HTMLReports/report.html"}
				 //,tags="{@Test}" 
						 )

public class Runner {

}


//plugin={"pretty","json:target/Report.json"}
//plugin={"pretty","html:target/HTMLReports/report.html"}
//plugin={"pretty","junit:target/Report.xml"}