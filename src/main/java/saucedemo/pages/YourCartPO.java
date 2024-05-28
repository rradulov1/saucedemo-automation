package saucedemo.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class YourCartPO extends CartItemsPO {

    private WebDriver driver;

    @FindBy(xpath = "//*[@class='inventory_item_name']")
    private List<WebElement> addedProductsNames;

    public YourCartPO(WebDriver driver) {
        super(driver);
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public boolean isProductNameDisplayed(String givenProductName) {
        for (WebElement addedProductName : addedProductsNames) {
            if (addedProductName.getText().equals(givenProductName)) {
                return true;
            }
        }
        return false;
    }
}
