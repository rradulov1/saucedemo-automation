package saucedemo.tests;

import org.testng.annotations.Test;
import saucedemo.base.BaseTest;
import saucedemo.pages.ProductsPO;
import saucedemo.pages.YourCartPO;

public class ProductsTest extends BaseTest {

    @Test
    void productsPageAtributes() {
        login();
        ProductsPO productsPO = new ProductsPO(driver);
        softAssert.assertTrue(productsPO.isBurgerMenuDisplayed(), "Burger menu displayed");
        softAssert.assertTrue(productsPO.isAppLogoDisplayed(), "App logo displayed");
        softAssert.assertEquals(productsPO.getAppLogoText(), "Swag Labs", "App logo text");
        softAssert.assertTrue(productsPO.isTitleDisplayed(), "Title products displayed");
        softAssert.assertEquals(productsPO.getTitleText(), "Products", "Products text");
        softAssert.assertTrue(productsPO.isShoppingCartDisplayed(), "Cart icon displayed");
        softAssert.assertTrue(productsPO.isSortMenuDisplayed(), "Sort menu displayed");
    }

    @Test
    void hamburgerMenu() {
        login();
        ProductsPO productsPO = new ProductsPO(driver);
        productsPO.clickHamburgerMenuButton();
        productsPO.waitForCrossButton();
        softAssert.assertTrue(productsPO.isAllItemsLinkDisplayed(), "All Items displayed");
        softAssert.assertEquals(productsPO.getAllItemsLinkText(), "All Items", "All Item text");
        softAssert.assertTrue(productsPO.isAboutLinkDisplayed(), "About displayed");
        softAssert.assertEquals(productsPO.getAboutLinkText(), "About", "About text");
        softAssert.assertTrue(productsPO.isLogoutLinkDisplayed(), "Logout displayed");
        softAssert.assertEquals(productsPO.getLogoutLinkText(), "Logout", "Logout text");
        softAssert.assertTrue(productsPO.isResetAppStateLinkDisplayed(), "Reset App State displayed");
        softAssert.assertEquals(productsPO.getResetAppStateLinkText(), "Reset App State", "Reset App State text");
    }

    @Test
    void addItemToCartByGivenName() {
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
        softAssert.assertTrue(yourCartPO.isProductNameDisplayed(firstRandomProductName), "First added product displayed in cart");
        softAssert.assertTrue(yourCartPO.isProductNameDisplayed(secondRandomProductName), "Second added product displayed in cart");
    }
}
