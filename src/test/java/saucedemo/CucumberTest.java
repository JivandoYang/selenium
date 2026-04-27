package saucedemo;

import org.junit.runner.RunWith;
import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions(
        features = "src/test/resources/features",
        glue = "saucedemo.stepdef",
        plugin = {"pretty"}
)

public class CucumberTest {
}