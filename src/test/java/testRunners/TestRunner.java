package testRunners;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        features = {"src/test/resources/features/SearchProduct.feature"},
        glue = {"stepDefs","hooks"},
        plugin = {"pretty"}
)
public class TestRunner {

}
