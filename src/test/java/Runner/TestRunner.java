package Runner;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions (
        features = "src/main/resources/Features/TaskSecnario.feature",
        glue     = "StepDefs",
        tags     = "@TestRunner",
        plugin   =
                    { "pretty",
                         "html:target/cucumber-reports/Report.html"
                    }
)

public class TestRunner extends AbstractTestNGCucumberTests {
}
