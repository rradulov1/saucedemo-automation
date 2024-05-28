package saucedemo.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HeaderPO {

    private WebDriver driver;

    @FindBy(xpath = "//*[@id='react-burger-menu-btn']")
    private WebElement hamburgerMenu;

    @FindBy(xpath = "//*[@class='app_logo']")
    private WebElement appLogo;

    @FindBy(xpath = "//*[@class='title']")
    private WebElement title;

    @FindBy(xpath = "//*[@class='shopping_cart_link']")
    private WebElement shoppingCart;

    public HeaderPO(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public boolean isBurgerMenuDisplayed() {
        return hamburgerMenu.isDisplayed();
    }

    public void clickHamburgerMenuButton() {
        hamburgerMenu.click();
    }

    public boolean isAppLogoDisplayed() {
        return appLogo.isDisplayed();
    }

    public String getAppLogoText() {
        return appLogo.getText();
    }

    public boolean isShoppingCartDisplayed() {
        return shoppingCart.isDisplayed();
    }

    public YourCartPO clickCartMenuButton() {
        shoppingCart.click();
        return new YourCartPO(driver);
    }

    public boolean isTitleDisplayed() {
        return title.isDisplayed();
    }

    public String getTitleText() {
        return title.getText();
    }
}
