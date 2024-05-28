package saucedemo.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CheckoutOverviewPO extends CartItemsPO {

    private WebDriver driver;

    @FindBy(xpath = "//*[@data-test='payment-info-label']")
    private WebElement paymentInfoLabel;

    @FindBy(xpath = "//*[@data-test='payment-info-value']")
    private WebElement paymentInfoValue;

    @FindBy(xpath = "//*[@data-test='shipping-info-label']")
    private WebElement shippingInfoLabel;

    @FindBy(xpath = "//*[@data-test='shipping-info-value']")
    private WebElement shippingInfoValue;

    @FindBy(xpath = "//*[@data-test='total-info-label']")
    private WebElement totalPriceInfoLabel;

    @FindBy(xpath = "//*[@data-test='subtotal-label']")
    private WebElement subtotalLabel;

    @FindBy(xpath = "//*[@data-test='tax-label']")
    private WebElement taxLabel;

    @FindBy(xpath = "//*[@data-test='total-label']")
    private WebElement totalLabel;

    public CheckoutOverviewPO(WebDriver driver) {
        super(driver);
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public boolean isPaymentInfoLabelDisplayed() {
        return paymentInfoLabel.isDisplayed();
    }

    public String getPaymentInfoLabelText() {
        return paymentInfoLabel.getText();
    }

    public boolean isPaymentInfoValueDisplayed() {
        return paymentInfoValue.isDisplayed();
    }

    public String getPaymentInfoValueText() {
        return paymentInfoValue.getText();
    }

    public boolean isShippingInfoLabelDisplayed() {
        return shippingInfoLabel.isDisplayed();
    }

    public String getShippingInfoLabelText() {
        return shippingInfoLabel.getText();
    }

    public boolean isShippingInfoValueDisplayed() {
        return shippingInfoValue.isDisplayed();
    }

    public String getShippingInfoValueText() {
        return shippingInfoValue.getText();
    }

    public boolean isTotalPriceInfoLabelDisplayed() {
        return totalPriceInfoLabel.isDisplayed();
    }

    public String getTotalPriceInfoLabelText() {
        return totalPriceInfoLabel.getText();
    }

    public boolean isSubtotalLabelDisplayed() {
        return subtotalLabel.isDisplayed();
    }

    public String getSubtotalLabelText() {
        return subtotalLabel.getText();
    }

    public boolean isTaxLabelDisplayed() {
        return taxLabel.isDisplayed();
    }

    public String getTaxLabelText() {
        return taxLabel.getText();
    }

    public boolean isTotalLabelDisplayed() {
        return totalLabel.isDisplayed();
    }

    public String getTotalLabelText() {
        return totalLabel.getText();
    }
}
