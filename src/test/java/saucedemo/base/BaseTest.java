package saucedemo.base;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.asserts.SoftAssert;
import saucedemo.pages.LoginPO;

import java.util.Properties;

public class BaseTest {
    public WebDriver driver;
    protected SoftAssert softAssert;

    protected Properties configProperties = ConfigLoader.loadConfigProperties();

    @BeforeMethod
    public void setUp() {
        String browser = configProperties.getProperty("browser");
        switch (browser) {
            case "chrome":
                WebDriverManager.chromedriver().setup();
                driver = new ChromeDriver();
                break;
            case "firefox":
                WebDriverManager.firefoxdriver().setup();
                driver = new FirefoxDriver();
                break;
            default:
                break;
        }

        driver.manage().window().maximize();
        driver.manage().deleteAllCookies();
//        driver.manage().timeouts().implicitlyWait(Duration.ofMillis(500));
        driver.get("https://www.saucedemo.com/");

        softAssert = new SoftAssert();
    }

    @AfterMethod
    public void quitTest() {
        softAssert.assertAll();
        driver.quit();
    }

    protected void login() {
        loginWithUserNameAndPassword("standard_user", "secret_sauce");
    }

    protected void loginWithUserNameAndPassword(String userName, String password) {
        LoginPO loginPO = new LoginPO(driver);
        loginPO.enterUsernameInputFieldText(userName);
        loginPO.enterPasswordInputFieldText(password);
        loginPO.clickLoginButton();
    }
}
