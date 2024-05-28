package saucedemo.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ConfirmationPO extends HeaderPO {

    private WebDriver driver;

    @FindBy(xpath = "//*[contains(@class,'btn_action')]")
    private WebElement confirmationButton;

    @FindBy(xpath = "//*[contains(@class,'btn_secondary')]")
    private WebElement secondaryButton;

    public ConfirmationPO(WebDriver driver) {
        super(driver);
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public boolean isConfirmationButtonDisplayed() {
        return confirmationButton.isDisplayed();
    }

    public String getConfirmationButtonText() {
        return confirmationButton.getText();
    }

    public void clickConfirmationButton() {
        confirmationButton.click();
    }

    public boolean isSecondaryButtonDisplayed() {
        return secondaryButton.isDisplayed();
    }

    public String getSecondaryButtonText() {
        return secondaryButton.getText();
    }

    public void clickSecondaryButton() {
        secondaryButton.click();
    }
}
