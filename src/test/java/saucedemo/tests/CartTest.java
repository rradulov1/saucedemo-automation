package saucedemo.tests;

import org.testng.annotations.Test;
import saucedemo.base.BaseTest;
import saucedemo.pages.CheckoutPO;
import saucedemo.pages.ProductsPO;
import saucedemo.pages.YourCartPO;

public class CartTest extends BaseTest {

    @Test
    void cartMenu() {
        login();
        ProductsPO productsPO = new ProductsPO(driver);
        YourCartPO yourCartPO = productsPO.clickCartMenuButton();
        softAssert.assertTrue(yourCartPO.isBurgerMenuDisplayed(), "Burger menu displayed");
        softAssert.assertTrue(yourCartPO.isAppLogoDisplayed(), "App logo displayed");
        softAssert.assertEquals(yourCartPO.getAppLogoText(), "Swag Labs", "Swag labs text");
        softAssert.assertTrue(yourCartPO.isShoppingCartDisplayed(), "Shopping cart displayed");
        softAssert.assertTrue(yourCartPO.isTitleDisplayed(), "Your Cart displayed");
        softAssert.assertEquals(yourCartPO.getTitleText(), "Your Cart", "Your Cart text");
        softAssert.assertTrue(yourCartPO.isQtyLabelDisplayed(), "QTY displayed");
        softAssert.assertEquals(yourCartPO.getQtyLabelText(), "QTY", "QTY text");
        softAssert.assertTrue(yourCartPO.isDescriptionDisplayed(), "Description displayed");
        softAssert.assertEquals(yourCartPO.getDescriptionText(), "Description", "Description text");
        softAssert.assertTrue(yourCartPO.isConfirmationButtonDisplayed(), "Checkout displayed");
        softAssert.assertEquals(yourCartPO.getConfirmationButtonText(), "Checkout", "Checkout text");
        softAssert.assertTrue(yourCartPO.isConfirmationButtonDisplayed(), "Checkout displayed");
        softAssert.assertEquals(yourCartPO.getConfirmationButtonText(), "Checkout", "Checkout text");

    }

    @Test
    void backToProducts() {
        login();
        ProductsPO productsPO = new ProductsPO(driver);
        YourCartPO yourCartPO = productsPO.clickCartMenuButton();
        yourCartPO.clickSecondaryButton();
        softAssert.assertEquals(productsPO.getTitleText(), "Products", "Products text");
    }

    @Test
    void checkoutButton() {
        login();
        ProductsPO productsPO = new ProductsPO(driver);
        YourCartPO yourCartPO = productsPO.clickCartMenuButton();
        yourCartPO.clickConfirmationButton();
        CheckoutPO checkoutPO = new CheckoutPO(driver);
        softAssert.assertEquals(checkoutPO.getTitleText(), "Checkout: Your Information", "Checkout text");
    }
}
