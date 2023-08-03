import org.junit.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import java.util.List;

public class Cart {
    WebDriver driver = new ChromeDriver();

    @Before
    public void prepareData(){
        driver.manage().window().maximize();
        driver.get("http://qa3magento.dev.evozon.com/");

        Actions actions = new Actions(driver);
        actions.moveToElement(driver.findElement(By.cssSelector(".nav-4.parent > a"))).build().perform();

        driver.findElement(By.cssSelector(".nav-4-1.first > a")).click();
        driver.findElement(By.cssSelector("a[title='Alice in Wonderland']+div > div.actions > a")).click();
        driver.findElement(By.cssSelector("#links_21")).click();
        driver.findElement(By.cssSelector("div.add-to-cart-buttons > button")).click();
    } 

    @Test
    public void validAddConfigurableProductToCartTest() {
        String shoppingCart = driver.findElement(By.cssSelector("h1")).getText().toUpperCase();
        String itemAdded = driver.findElement(By.cssSelector("h2 > a")).getText().toUpperCase();
        Assert.assertEquals("SHOPPING CART", shoppingCart);
        Assert.assertEquals("ALICE IN WONDERLAND", itemAdded);
    }

    @Test
    public void validDeleteConfigurableProductFromCartTest() {
        String shoppingCart = driver.findElement(By.cssSelector("h1")).getText();
        String itemToBeDeleted = driver.findElement(By.cssSelector("h2 > a")).getText();

        driver.findElement(By.cssSelector(".product-cart-remove.last > a")).click();
        String emptyShoppingCart = driver.findElement(By.cssSelector("h1")).getText().toUpperCase();
        Assert.assertEquals("SHOPPING CART IS EMPTY", emptyShoppingCart);
    }

    @Test
    public void validUpdateConfigurableProductInCartTest() {
        driver.findElement(By.cssSelector(".product-cart-actions > input")).clear();
        driver.findElement(By.cssSelector(".product-cart-actions > input")).sendKeys("3");
        driver.findElement(By.cssSelector(".product-cart-actions > button > span > span")).click();

        String updatedQty = driver.findElement(By.cssSelector(".product-cart-actions > input")).getAttribute("value");
        Assert.assertEquals("3", updatedQty);
    }

    //TODO
    @Ignore
    @Test
    public void validCheckout() {
        Actions actions = new Actions(driver);
        actions.moveToElement(driver.findElement(By.cssSelector(".nav-4.parent > a"))).build().perform();

        driver.findElement(By.cssSelector(".nav-4-1.first > a")).click();
//        List<WebElement> addButtons = driver.findElement(By.cssSelector(".product-info .actions button[title='Add to Cart']"));
//        in progress
//        Assert.assertEquals("YOUR ORDER HAS BEEN RECEIVED.", confirmation);
    }

    @After
    public void closeWindow(){
        driver.close();
    }
}