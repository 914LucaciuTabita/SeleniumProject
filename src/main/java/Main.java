import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Main {


    public static void main(String[] args) {
        System.setProperty("webdriver.chrome.driver","resources/chromedriver.exe");

//        LoginTest loginTest = new LoginTest();
//        loginTest.validLoginTest();
//
//        RegisterTest registerTest = new RegisterTest();
//        registerTest.validRegisterTest();
//
//        WishlistTest wishlistTest = new WishlistTest();
//        wishlistTest.validAddToWishlistTest();

        Cart cart = new Cart();
//        cart.addConfigurableProductToCartTest();
        cart.deleteConfigurableProductFromCartTest();
    }
}
