package saucedemo.tests;

import org.testng.annotations.Test;
import saucedemo.base.BaseTest;
import saucedemo.pages.LoginPO;
import saucedemo.pages.ProductsPO;

public class LoginTest extends BaseTest {

    @Test
    void successfulLogin() {
        login();
        ProductsPO productsPO = new ProductsPO(driver);
        softAssert.assertTrue(productsPO.isTitleDisplayed(), "Products title displayed");
    }

    @Test
    void loginAttributes() {
        LoginPO loginPO = new LoginPO(driver);
        softAssert.assertTrue(loginPO.isLoginLogoDisplayed(), "Login logo displayed");
        softAssert.assertEquals(loginPO.getLoginLogoText(), "Swag Labs", "Login logo text");
        softAssert.assertTrue(loginPO.isUsernameInputFieldDisplayed(), "Username input field displayed");
        softAssert.assertEquals(loginPO.getUsernameInputFieldPlaceholder(), "Username", "Username placeholder text");
        softAssert.assertTrue(loginPO.isPasswordInputFieldDisplayed(), "Password input field displayed");
        softAssert.assertEquals(loginPO.getPasswordInputFieldPlaceholder(), "Password", "Password placeholder text");
        softAssert.assertTrue(loginPO.isLoginButtonDisplayed(), "Login button displayed");
        softAssert.assertEquals(loginPO.getLoginButtonText(), "Login", "Login text");
    }

    @Test
    void loginWithInvalidUser() {
        loginWithUserNameAndPassword("Wrong user", "Pass");
        LoginPO loginPO = new LoginPO(driver);
        softAssert.assertTrue(loginPO.isErrorMassageDisplayed(), "Error massage displayed");
        softAssert.assertEquals(loginPO.getErrorMassageText(), "Epic sadface: Username and password do not match any user in this service", "Error text");
    }

    @Test
    void loginWithLockedOutUser() {
        loginWithUserNameAndPassword("locked_out_user", "secret_sauce");
        LoginPO loginPO = new LoginPO(driver);
        softAssert.assertTrue(loginPO.isErrorMassageDisplayed(), "Error massage displayed");
        softAssert.assertEquals(loginPO.getErrorMassageText(), "Epic sadface: Sorry, this user has been locked out.", "Error text");
    }

}
