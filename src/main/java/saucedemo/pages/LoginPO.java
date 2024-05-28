package saucedemo.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPO {
    private WebDriver driver;

    @FindBy(xpath = "//*[@class='login_logo']")
    private WebElement loginLogo;

    @FindBy(xpath = "//*[@data-test='username']")
    private WebElement usernameInputField;

    @FindBy(xpath = "//*[@data-test='password']")
    private WebElement passwordInputField;

    @FindBy(xpath = "//input[@type='submit']")
    private WebElement loginButton;

    @FindBy(xpath = "//*[@data-test='error']")
    private WebElement errorMassage;

    public LoginPO(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public boolean isLoginLogoDisplayed() {
        return loginLogo.isDisplayed();
    }

    public String getLoginLogoText() {
        return loginLogo.getText();
    }

    public void enterUsernameInputFieldText(String usernameText) {
        usernameInputField.sendKeys(usernameText);
    }

    public boolean isUsernameInputFieldDisplayed() {
        return usernameInputField.isDisplayed();
    }

    public String getUsernameInputFieldPlaceholder() {
        return usernameInputField.getAttribute("placeholder");
    }

    public void enterPasswordInputFieldText(String passwordText) {
        passwordInputField.sendKeys(passwordText);
    }

    public boolean isPasswordInputFieldDisplayed() {
        return passwordInputField.isDisplayed();
    }

    public String getPasswordInputFieldPlaceholder() {
        return passwordInputField.getAttribute("placeholder");
    }

    public boolean isLoginButtonDisplayed() {
        return loginButton.isDisplayed();
    }

    public String getLoginButtonText() {
        return loginButton.getAttribute("value");
    }

    public void clickLoginButton() {
        loginButton.click();
    }

    public boolean isErrorMassageDisplayed() {
        return errorMassage.isDisplayed();
    }

    public String getErrorMassageText() {
        return errorMassage.getText();
    }
}
