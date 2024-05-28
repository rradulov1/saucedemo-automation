package saucedemo.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

public class ProductsPO extends HeaderPO {

    private WebDriver driver;

    @FindBy(xpath = "//*[@class='product_sort_container']")
    private WebElement productSortMenu;

    @FindBy(xpath = "//*[@id='react-burger-cross-btn']")
    private WebElement burgerCrossButton;

    @FindBy(xpath = "//*[@id='inventory_sidebar_link']")
    private WebElement allItemsLink;

    @FindBy(xpath = "//*[@id='about_sidebar_link']")
    private WebElement aboutLink;

    @FindBy(xpath = "//*[@id='logout_sidebar_link']")
    private WebElement logoutLink;

    @FindBy(xpath = "//*[@id='reset_sidebar_link']")
    private WebElement resetAppStateLink;

    @FindBy(xpath = "//*[contains(@name,'add-to-cart')]")
    private List<WebElement> addToCartButtons;

    @FindBy(xpath = "//*[contains(@class,'inventory_item_name ')]")
    private List<WebElement> itemNames;

    @FindBy(xpath = "//*[contains(@class,'inventory_item_price')]")
    private List<WebElement> itemPrices;

    public ProductsPO(WebDriver driver) {
        super(driver);
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public boolean isSortMenuDisplayed() {
        return productSortMenu.isDisplayed();
    }

    public void waitForCrossButton() {
        waitForVisibilityOfElement(burgerCrossButton);
    }

    private void waitForVisibilityOfElement(WebElement element) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(3));
        wait.until(ExpectedConditions.visibilityOf(element));
    }

    public boolean isAllItemsLinkDisplayed() {
        return allItemsLink.isDisplayed();
    }

    public String getAllItemsLinkText() {
        return allItemsLink.getText();
    }

    public boolean isAboutLinkDisplayed() {
        return aboutLink.isDisplayed();
    }

    public String getAboutLinkText() {
        return aboutLink.getText();
    }

    public boolean isLogoutLinkDisplayed() {
        return logoutLink.isDisplayed();
    }

    public String getLogoutLinkText() {
        return logoutLink.getText();
    }

    public boolean isResetAppStateLinkDisplayed() {
        return resetAppStateLink.isDisplayed();
    }

    public String getResetAppStateLinkText() {
        return resetAppStateLink.getText();
    }

    public void addItemByGivenName(String itemName) {
        WebElement addToCartButtonForGivenItemName = driver.findElement(By.xpath("//*[(text()='" + itemName + "') and (@class='inventory_item_name ')]/parent::a/parent::div/parent::*[@class='inventory_item_description']//*[contains(@id,'add-to-cart')]"));
        addToCartButtonForGivenItemName.click();
    }

    public String getRandomProductName() {
        int randomProductIndex = (int) ((Math.random() * (itemNames.size() - 1)) + 1);
        return itemNames.get(randomProductIndex).getText();
    }
}

