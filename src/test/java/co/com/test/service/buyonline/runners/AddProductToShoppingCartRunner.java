package co.com.test.service.buyonline.runners;

import cucumber.api.CucumberOptions;
import cucumber.api.SnippetType;
import net.serenitybdd.cucumber.CucumberWithSerenity;
import org.junit.runner.RunWith;

@RunWith(CucumberWithSerenity.class)
@CucumberOptions(
        features = "src/test/resources/features/add_product_to_shopping_cart.feature",
        glue = "co.com.test.service.buyonline.stepdefinitions",
        snippets = SnippetType.CAMELCASE
)
public class AddProductToShoppingCartRunner { }
