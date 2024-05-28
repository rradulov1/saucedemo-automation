package saucedemo.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CheckoutPO extends ConfirmationPO {

    private WebDriver driver;

    private static final String PLACEHOLDER_TEXT = "Placeholder";

    @FindBy(xpath = "//*[contains(@id,'first-name')]")
    private WebElement firstNameInputField;

    @FindBy(xpath = "//*[contains(@id,'last-name')]")
    private WebElement lastNameInputField;

    @FindBy(xpath = "//*[contains(@id,'postal-code')]")
    private WebElement zipCodeInputField;

    public CheckoutPO(WebDriver driver) {
        super(driver);
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public boolean isFirstNameInputFieldDisplayed() {
        return firstNameInputField.isDisplayed();
    }

    public String getFirstNameInputFieldPlaceholder() {
        return firstNameInputField.getAttribute(PLACEHOLDER_TEXT);
    }

    public boolean isLastNameInputFieldDisplayed() {
        return lastNameInputField.isDisplayed();
    }

    public String getLastNameInputFieldPlaceholder() {
        return lastNameInputField.getAttribute(PLACEHOLDER_TEXT);
    }

    public boolean isZipCodeDisplayed() {
        return zipCodeInputField.isDisplayed();
    }

    public String getZipCodeInputFieldPlaceholder() {
        return zipCodeInputField.getAttribute(PLACEHOLDER_TEXT);
    }

    public void enterFirstNameInputFieldText(String firstNameText) {
        firstNameInputField.sendKeys(firstNameText);
    }

    public void enterLastNameInputFieldText(String lastNameText) {
        lastNameInputField.sendKeys(lastNameText);
    }

    public void enterZipCodeInputFieldText(String zipCodeText) {
        zipCodeInputField.sendKeys(zipCodeText);
    }
}


