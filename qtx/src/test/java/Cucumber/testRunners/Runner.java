package Cucumber.testRunners;
import org.junit.runner.RunWith;		
import cucumber.api.CucumberOptions;		
import cucumber.api.junit.Cucumber;		

@RunWith(Cucumber.class)				
@CucumberOptions(features="src\\test\\java\\Cucumber\\Features",glue={"Cucumber.stepDefinitions"},strict = true)
public class Runner {

}
