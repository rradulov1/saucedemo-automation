package saucedemo.tests;

import org.testng.annotations.Test;
import saucedemo.base.BaseTest;
import saucedemo.pages.*;

public class CheckoutOverviewTest extends BaseTest {

    @Test
    public void checkoutOverviewAtributes() {
        login();
        ProductsPO productsPO = new ProductsPO(driver);
        YourCartPO yourCartPO = productsPO.clickCartMenuButton();
        yourCartPO.clickConfirmationButton();
        CheckoutPO checkoutPO = new CheckoutPO(driver);
        checkoutPO.enterFirstNameInputFieldText("Ivan");
        checkoutPO.enterLastNameInputFieldText("Ivanov");
        checkoutPO.enterZipCodeInputFieldText("1000");
        checkoutPO.clickConfirmationButton();
        CheckoutOverviewPO checkoutOverviewPO = new CheckoutOverviewPO(driver);
        softAssert.assertTrue(checkoutOverviewPO.isBurgerMenuDisplayed(), "Hamburger menu displayed");
        softAssert.assertTrue(checkoutOverviewPO.isAppLogoDisplayed(), "App logo displayed");
        softAssert.assertEquals(checkoutOverviewPO.getAppLogoText(), "Swag Labs", "App logo text");
        softAssert.assertTrue(checkoutOverviewPO.isShoppingCartDisplayed(), "Cart icon displayed");
        softAssert.assertTrue(checkoutOverviewPO.isTitleDisplayed(), "Checkout: Overview displayed");
        softAssert.assertEquals(checkoutOverviewPO.getTitleText(), "Checkout: Overview", "Checkout: Overview displayed text");
        softAssert.assertTrue(checkoutOverviewPO.isQtyLabelDisplayed(), "QTY displayed");
        softAssert.assertEquals(checkoutOverviewPO.getQtyLabelText(), "QTY", "QTY text");
        softAssert.assertTrue(checkoutOverviewPO.isDescriptionDisplayed(), "Description displayed");
        softAssert.assertEquals(checkoutOverviewPO.getDescriptionText(), "Description", "Description text");
        softAssert.assertTrue(checkoutOverviewPO.isPaymentInfoLabelDisplayed(), "Payment Information displayed");
        softAssert.assertEquals(checkoutOverviewPO.getPaymentInfoLabelText(), "Payment Information:", "Payment Information text");
        softAssert.assertTrue(checkoutOverviewPO.isPaymentInfoValueDisplayed(), "SauceCard #31337 displayed");
        softAssert.assertEquals(checkoutOverviewPO.getPaymentInfoValueText(), "SauceCard #31337", "SauceCard #31337 text");
        softAssert.assertTrue(checkoutOverviewPO.isShippingInfoLabelDisplayed(), "Shipping Information displayed");
        softAssert.assertEquals(checkoutOverviewPO.getShippingInfoLabelText(), "Shipping Information:", "Shipping Information text");
        softAssert.assertTrue(checkoutOverviewPO.isShippingInfoValueDisplayed(), "Free Pony Express Delivery! displayed");
        softAssert.assertEquals(checkoutOverviewPO.getShippingInfoValueText(), "Free Pony Express Delivery!", "Free Pony Express Delivery! text");
        softAssert.assertTrue(checkoutOverviewPO.isTotalPriceInfoLabelDisplayed(), "Price Total displayed");
        softAssert.assertEquals(checkoutOverviewPO.getTotalPriceInfoLabelText(), "Price Total", "Price Total text");
        softAssert.assertTrue(checkoutOverviewPO.isSubtotalLabelDisplayed(), "Item total: $0 displayed");
        softAssert.assertEquals(checkoutOverviewPO.getSubtotalLabelText(), "Item total: $0", "Item total: $0 text");
        softAssert.assertTrue(checkoutOverviewPO.isTaxLabelDisplayed(), "Tax: $0.00 displayed");
        softAssert.assertEquals(checkoutOverviewPO.getTaxLabelText(), "Tax: $0.00", "Tax: $0.00 text");
        softAssert.assertTrue(checkoutOverviewPO.isTotalLabelDisplayed(), "Total: $0.00 displayed");
        softAssert.assertEquals(checkoutOverviewPO.getTotalLabelText(), "Total: $0.00", "Total: $0.00 text");
        softAssert.assertTrue(checkoutOverviewPO.isSecondaryButtonDisplayed(), "Cancel displayed");
        softAssert.assertEquals(checkoutOverviewPO.getSecondaryButtonText(), "Cancel", "Cancel text");
        softAssert.assertTrue(checkoutOverviewPO.isConfirmationButtonDisplayed(), "Finish displayed");
        softAssert.assertEquals(checkoutOverviewPO.getConfirmationButtonText(), "Finish", "Finish text");
    }

    @Test
    public void enterCheckoutComplete() {
        login();
        ProductsPO productsPO = new ProductsPO(driver);
        YourCartPO yourCartPO = productsPO.clickCartMenuButton();
        yourCartPO.clickConfirmationButton();
        CheckoutPO checkoutPO = new CheckoutPO(driver);
        checkoutPO.enterFirstNameInputFieldText("Ivan");
        checkoutPO.enterLastNameInputFieldText("Ivanov");
        checkoutPO.enterZipCodeInputFieldText("1000");
        checkoutPO.clickConfirmationButton();
        CheckoutOverviewPO checkoutOverviewPO = new CheckoutOverviewPO(driver);
        checkoutOverviewPO.clickConfirmationButton();
        CheckoutCompletePO checkoutCompletePO = new CheckoutCompletePO(driver);
        softAssert.assertTrue(checkoutCompletePO.isTitleDisplayed(), "Checkout: Complete!");
        softAssert.assertEquals(checkoutCompletePO.getTitleText(), "Checkout: Complete!", "Checkout: Complete! displayed text");
    }
}
