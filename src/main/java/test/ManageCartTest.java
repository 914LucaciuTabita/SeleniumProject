package test;

import org.junit.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class ManageCartTest extends BaseTest{

    @Before
    public void validAddConfigurableProductToCart(){
        String text = "TABITA";
        headerPage.setSearchInput(text);
        headerPage.sendSearchInput();

        gridProductsPage.clickViewDetailsButton();
        productPage.selectPinkColor();
        productPage.selectSizeM();
        productPage.clickAddToCartButton();
    } 



    @Test
    public void validDeleteConfigurableProductFromCartTest() {
        cartPage.getShoppingCartTitle();
        cartPage.getAddedProductTitle();
        cartPage.clickRemoveButton();
        Assert.assertEquals("SHOPPING CART IS EMPTY", cartPage.getShoppingCartTitle());
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
//        List<WebElement> addButtons = driver.findElement(By.cssSelector(".product-info .actions button[title='Add to test.Cart']"));
//        in progress
//        Assert.assertEquals("YOUR ORDER HAS BEEN RECEIVED.", confirmation);
    }
}