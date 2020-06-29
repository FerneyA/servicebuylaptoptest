package co.com.test.service.buyonline.pages;

import net.serenitybdd.core.annotations.findby.FindBy;
import net.serenitybdd.core.pages.WebElementFacade;
import net.thucydides.core.pages.PageObject;
import org.openqa.selenium.WebDriver;

public class FormPlaceOrderPage extends PageObject {

    @FindBy(id = "name")
    private WebElementFacade txtName;

    @FindBy(id = "country")
    private WebElementFacade txtCountry;

    @FindBy(id = "city")
    private WebElementFacade txtCity;

    @FindBy(id = "card")
    private WebElementFacade txtCreditCard;

    @FindBy(id = "month")
    private WebElementFacade txtMonth;

    @FindBy(id = "year")
    private WebElementFacade txtYear;

    @FindBy(xpath = ".//button[contains(text(), 'Purchase')]")
    private WebElementFacade btnPurchase;

    @FindBy(xpath = ".//h2[contains(text(),'Thank you for your purchase!')]")
    private WebElementFacade lblSuccessfulPurchase;

    public FormPlaceOrderPage (WebDriver driver) {
        super(driver);
    }

    public void fillOutName(String name) {
        typeInto(txtName, name);
    }

    public void fillOutCountry(String country) {
        typeInto(txtCountry, country);
    }

    public void fillOutCity(String city) {
        typeInto(txtCity, city);
    }

    public void fillOutCreditCard(String creditCard) {
        typeInto(txtCreditCard, creditCard);
    }

    public void fillOutMonth(String month) {
        typeInto(txtMonth, month);
    }

    public void fillOutYear(String year) {
        typeInto(txtYear, year);
    }

    public void selectPurchase() {
        btnPurchase.waitUntilClickable().click();
    }

    public String getTextSuccessfulPurchase(){
        return lblSuccessfulPurchase.waitUntilVisible()
                .getText();
    }
}
