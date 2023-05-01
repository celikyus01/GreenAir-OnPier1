package com.Onpier.runners;
import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;


@RunWith(Cucumber.class)

@CucumberOptions(
        plugin = {"html:target/cucumber-report.html",
                "json:target/cucumber.json",
                "rerun:target/rerun.txt"

        },
        features = "src/test/resources/features",
        glue = "com/Onpier/stepDefinitions",
        dryRun = false,
        tags = "@wip"
)
public class CukesRunner {
}



