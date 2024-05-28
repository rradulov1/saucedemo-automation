package saucedemo.tests;

import org.testng.annotations.Test;
import saucedemo.base.BaseTest;
import saucedemo.pages.CheckoutPO;
import saucedemo.pages.CheckoutOverviewPO;
import saucedemo.pages.ProductsPO;
import saucedemo.pages.YourCartPO;

public class CheckoutTest extends BaseTest {

    @Test
    public void checkoutHeaderAtributes() {
        login();
        ProductsPO productsPO = new ProductsPO(driver);
        YourCartPO yourCartPO = productsPO.clickCartMenuButton();
        yourCartPO.clickConfirmationButton();
        CheckoutPO checkoutPO = new CheckoutPO(driver);
        softAssert.assertTrue(checkoutPO.isBurgerMenuDisplayed(), "Burger menu displayed");
        softAssert.assertTrue(checkoutPO.isAppLogoDisplayed(), "App logo displayed");
        softAssert.assertEquals(checkoutPO.getAppLogoText(), "Swag Labs", "App logo text");
        softAssert.assertTrue(checkoutPO.isTitleDisplayed(), "Checkout: Your Information displayed");
        softAssert.assertEquals(checkoutPO.getTitleText(), "Checkout: Your Information", "Checkout: Your Information text");
        softAssert.assertTrue(checkoutPO.isShoppingCartDisplayed(), "Cart icon displayed");
    }

    @Test
    public void checkOutAtributes() {
        login();
        ProductsPO productsPO = new ProductsPO(driver);
        YourCartPO yourCartPO = productsPO.clickCartMenuButton();
        yourCartPO.clickConfirmationButton();
        CheckoutPO checkoutPO = new CheckoutPO(driver);
        softAssert.assertTrue(checkoutPO.isFirstNameInputFieldDisplayed(), "First Name displayed");
        softAssert.assertEquals(checkoutPO.getFirstNameInputFieldPlaceholder(), "First Name", "First Name text");
        softAssert.assertTrue(checkoutPO.isLastNameInputFieldDisplayed(), "Last Name displayed");
        softAssert.assertEquals(checkoutPO.getLastNameInputFieldPlaceholder(), "Last Name", "Last Name text");
        softAssert.assertTrue(checkoutPO.isZipCodeDisplayed(), "Zip Code displayed");
        softAssert.assertEquals(checkoutPO.getZipCodeInputFieldPlaceholder(), "Zip/Postal Code", "Zip/Postal Code text");
        softAssert.assertTrue(checkoutPO.isSecondaryButtonDisplayed(), "Cancel Displayed");
        softAssert.assertEquals(checkoutPO.getSecondaryButtonText(), "Cancel", "Cancel Displayed");
    }

    @Test
    public void cancelCheckout() {
        login();
        ProductsPO productsPO = new ProductsPO(driver);
        YourCartPO yourCartPO = productsPO.clickCartMenuButton();
        yourCartPO.clickConfirmationButton();
        CheckoutPO checkoutPO = new CheckoutPO(driver);
        checkoutPO.clickSecondaryButton();
        yourCartPO = new YourCartPO(driver);
        softAssert.assertEquals(yourCartPO.getTitleText(), "Your Cart", "Your Cart text");
    }

    @Test
    public void enterCheckoutOverview() {
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
        softAssert.assertEquals(checkoutOverviewPO.getTitleText(), "Checkout: Overview", "Checkout: Overview text");
    }
}
