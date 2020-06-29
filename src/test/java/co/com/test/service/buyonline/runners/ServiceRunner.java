package co.com.test.service.buyonline.runners;

import cucumber.api.CucumberOptions;
import net.serenitybdd.cucumber.CucumberWithSerenity;
import org.junit.runner.RunWith;

@RunWith(CucumberWithSerenity.class)
@CucumberOptions(
        features = "src/test/resources/features/managing_users.feature",
        glue = {"co.com.test.service.buyonline.stepdefinitions"}
        )
public class ServiceRunner {}
