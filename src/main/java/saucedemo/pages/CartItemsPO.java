package saucedemo.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CartItemsPO extends ConfirmationPO {

    private WebDriver driver;

    @FindBy(xpath = "//*[@class='cart_quantity_label']")
    private WebElement qtyLabel;

    @FindBy(xpath = "//*[@class='cart_desc_label']")
    private WebElement description;

    public CartItemsPO(WebDriver driver) {
        super(driver);
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public boolean isQtyLabelDisplayed() {
        return qtyLabel.isDisplayed();
    }

    public String getQtyLabelText() {
        return qtyLabel.getText();
    }

    public boolean isDescriptionDisplayed() {
        return description.isDisplayed();
    }

    public String getDescriptionText() {
        return description.getText();
    }
}
