package test;

import org.junit.After;
import org.junit.Before;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import pages.*;

@RunWith(JUnit4.class)
public class BaseTest {
    protected WebDriver driver;
    protected Homepage homepage;
    protected LoginPage loginPage;
    protected AccountPage accountPage;
    protected RegisterPage registerPage;
    protected HeaderPage headerPage;
    protected GridProductsPage gridProductsPage;
    protected ProductPage productPage;
    protected WishlistPage wishlistPage;
    protected CartPage cartPage;

    @Before
    public void initDriver() {
        System.setProperty("webdriver.chrome.driver", "resources/chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        homepage = new Homepage(driver);
        loginPage = new LoginPage(driver);
        accountPage = new AccountPage(driver);
        registerPage = new RegisterPage(driver);
        headerPage = new HeaderPage(driver);
        gridProductsPage = new GridProductsPage(driver);
        productPage = new ProductPage(driver);
        wishlistPage = new WishlistPage(driver);
        cartPage = new CartPage(driver);
        homepage.open();
    }

    @After
    public void closeDriver() {
        driver.close();
    }
}
