package co.com.test.service.buyonline.steps;

import co.com.test.service.buyonline.pages.DemoblazeHomePage;
import co.com.test.service.buyonline.pages.FormPlaceOrderPage;
import net.thucydides.core.annotations.Step;
import org.fluentlenium.core.annotation.Page;
import org.hamcrest.MatcherAssert;

import java.util.List;
import java.util.Map;

public class DemoblazeStep {

    @Page
    DemoblazeHomePage demoblazeHomePage;

    @Page
    FormPlaceOrderPage formPlaceOrderPage;

    @Step
    public void openHomePage() {
        demoblazeHomePage.open();
    }

    @Step
    public void selectProduct(String category, String reference) {
        demoblazeHomePage.open();
        demoblazeHomePage.selectCategory(category);
        demoblazeHomePage.selectReferenceProduct(reference);
    }

    @Step
    public void addProductAShoppingCart(List<Map<String, String>> listDataOrder) {
        demoblazeHomePage.addToCart();
        demoblazeHomePage.acceptAlert();
        demoblazeHomePage.selectMenuCart();
        demoblazeHomePage.selectPlaceOrder();
        fillOutPlacerOrder(listDataOrder);
    }

    private void fillOutPlacerOrder(List<Map<String, String>> listDataOrder) {
        for (Map <String, String> dataOrder : listDataOrder) {
            formPlaceOrderPage.fillOutName(dataOrder.get("name"));
            formPlaceOrderPage.fillOutCountry(dataOrder.get("country"));
            formPlaceOrderPage.fillOutCity(dataOrder.get("city"));
            formPlaceOrderPage.fillOutCreditCard(dataOrder.get("credit card"));
            formPlaceOrderPage.fillOutMonth(dataOrder.get("month"));
            formPlaceOrderPage.fillOutYear(dataOrder.get("year"));
        }
        formPlaceOrderPage.selectPurchase();
    }

    public void validateMessageSuccessfulPurchase(String shoppingMessage) {
        MatcherAssert.assertThat("The purchase was not successful",
                formPlaceOrderPage.getTextSuccessfulPurchase().equals(shoppingMessage));
    }
}
