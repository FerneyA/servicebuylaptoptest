package co.com.test.service.buyonline.pages;

import net.serenitybdd.core.annotations.findby.FindBy;
import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.core.pages.WebElementFacade;
import net.thucydides.core.annotations.DefaultUrl;
import org.openqa.selenium.Alert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

@DefaultUrl("https://www.demoblaze.com/")
public class DemoblazeHomePage extends PageObject {

    @FindBy(xpath = ".//a[@class='btn btn-success btn-lg']")
    private WebElementFacade btnAddToCart;

    @FindBy(id = "cartur")
    private WebElementFacade linkCart;

    @FindBy(xpath = ".//button[@data-target='#orderModal']")
    private WebElementFacade btnPlaceOrder;

    private String containerCategory  = ".//div[@class='list-group']//a[contains(text(),'replace')]";

    private String containerCard  = ".//div[@class='card-block']//a[contains(text(),'replace')]";

    public DemoblazeHomePage(WebDriver webDriver) {
        super(webDriver);
    }

    public void selectCategory(String category) {
        $(containerCategory.replace("replace", category)).waitUntilClickable()
                .click();
    }

    public void selectReferenceProduct(String referenceProduct) {
        $(containerCard.replace("replace", referenceProduct)).waitUntilClickable()
                .click();
    }

    public void addToCart() {
        btnAddToCart.waitUntilClickable().click();
    }

    public void acceptAlert() {
        WebDriverWait webDriverWait= new WebDriverWait(getDriver(), 3);
        webDriverWait.until(ExpectedConditions.alertIsPresent());
        Alert alert = super.getDriver().switchTo().alert();
        alert.accept();
    }

    public void selectMenuCart() {
        linkCart.waitUntilClickable().click();
    }

    public void selectPlaceOrder() {
        btnPlaceOrder.waitUntilClickable().click();
    }
}
