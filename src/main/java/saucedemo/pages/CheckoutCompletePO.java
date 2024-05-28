package saucedemo.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CheckoutCompletePO extends HeaderPO {

    private WebDriver driver;

    @FindBy(xpath = "//*[@class='pony_express']")
    private WebElement ponyExpressImage;

    @FindBy(xpath = "//*[@data-test='complete-header']")
    private WebElement completeHeader;

    @FindBy(xpath = "//*[@data-test='complete-text']")
    private WebElement completeText;

    @FindBy(xpath = "//*[contains(@class,'btn_primary')]")
    private WebElement backHomesButton;

    public CheckoutCompletePO(WebDriver driver) {
        super(driver);
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public boolean isPonyExpressImageDisplayed() {
        return ponyExpressImage.isDisplayed();
    }

    public boolean isCompleteHeaderDisplayed() {
        return completeHeader.isDisplayed();
    }

    public String getCompleteHeaderText() {
        return completeHeader.getText();
    }

    public boolean isCompleteTextDisplayed() {
        return completeText.isDisplayed();
    }

    public String getCompleteText() {
        return completeText.getText();
    }

    public boolean isBackHomeButtonDisplayed() {
        return backHomesButton.isDisplayed();
    }

    public String getBackHomeButtonText() {
        return backHomesButton.getText();
    }

    public void clickBackHomeButton() {
        backHomesButton.click();
    }
}


