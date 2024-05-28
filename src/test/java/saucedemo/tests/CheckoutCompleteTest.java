package saucedemo.tests;

import org.testng.annotations.Test;
import saucedemo.base.BaseTest;
import saucedemo.pages.*;

public class CheckoutCompleteTest extends BaseTest {

    @Test
    public void backToHome() {
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
        checkoutCompletePO.clickBackHomeButton();
        softAssert.assertEquals(productsPO.getTitleText(), "Products", "Products text");
    }

    @Test
    void completeOrder() {
        login();
        ProductsPO productsPO = new ProductsPO(driver);
        String firstRandomProductName = productsPO.getRandomProductName();
        productsPO.addItemByGivenName(firstRandomProductName);
        String secondRandomProductName;
        do {
            secondRandomProductName = productsPO.getRandomProductName();
        }
        while (firstRandomProductName.equals(secondRandomProductName));
        productsPO.addItemByGivenName(secondRandomProductName);
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
        softAssert.assertTrue(checkoutCompletePO.isBurgerMenuDisplayed(), "Hamburger menu displayed");
        softAssert.assertTrue(checkoutCompletePO.isAppLogoDisplayed(), "App logo displayed");
        softAssert.assertEquals(checkoutCompletePO.getAppLogoText(), "Swag Labs", "App logo text");
        softAssert.assertTrue(checkoutCompletePO.isShoppingCartDisplayed(), "Cart icon displayed");
        softAssert.assertTrue(checkoutCompletePO.isTitleDisplayed(), "Checkout: Complete! displayed");
        softAssert.assertEquals(checkoutCompletePO.getTitleText(), "Checkout: Complete!", "Checkout: Complete!displayed text");
        softAssert.assertTrue(checkoutCompletePO.isPonyExpressImageDisplayed(), "Pony Express Image displayed");
        softAssert.assertTrue(checkoutCompletePO.isCompleteHeaderDisplayed(), "Thank you for your order! displayed");
        softAssert.assertEquals(checkoutCompletePO.getCompleteHeaderText(), "Thank you for your order!", "Thank you for your order! text");
        softAssert.assertTrue(checkoutCompletePO.isCompleteTextDisplayed(), "Your order has been dispatched, and will arrive just as fast as the pony can get there! displayed");
        softAssert.assertEquals(checkoutCompletePO.getCompleteText(), "Your order has been dispatched, and will arrive just as fast as the pony can get there!", "Your order has been dispatched, and will arrive just as fast as the pony can get there! text");
        softAssert.assertTrue(checkoutCompletePO.isBackHomeButtonDisplayed(), "Back Home displayed");
        softAssert.assertEquals(checkoutCompletePO.getBackHomeButtonText(), "Back Home", "Back Home text");
    }
}
