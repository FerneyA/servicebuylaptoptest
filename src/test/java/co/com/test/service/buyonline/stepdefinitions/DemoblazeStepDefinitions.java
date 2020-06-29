package co.com.test.service.buyonline.stepdefinitions;

import co.com.test.service.buyonline.steps.DemoblazeStep;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import io.cucumber.datatable.DataTable;
import net.thucydides.core.annotations.Steps;

public class DemoblazeStepDefinitions {

    @Steps
    DemoblazeStep demoblazeStep;

    @Given("^I want to find a product category (.*) and reference (.*)$")
    public void findProduct(String category, String reference) {
        demoblazeStep.openHomePage();
        demoblazeStep.selectProduct(category, reference);
    }

    @When("^he adds the product to the shopping cart with the order information$")
    public void addProductAShoppingCart(DataTable dataOrder) {
        demoblazeStep.addProductAShoppingCart(dataOrder.asMaps(String.class, String.class));
    }

    @Then("^the purchase is made and the message displayed is (.*)$")
    public void displayMessagePurchase(String shoppingMessage) {
        demoblazeStep.validateMessageSuccessfulPurchase(shoppingMessage);
    }
}
