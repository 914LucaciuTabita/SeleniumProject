import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class Cart {
    String greenColorCode = "\u001B[32m";
    String resetColorCode = "\u001B[0m";

    public void addConfigurableProductToCartTest() {
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("http://qa3magento.dev.evozon.com/");

        Actions actions = new Actions(driver);
        actions.moveToElement(driver.findElement(By.cssSelector("#nav > ol > li.level0.nav-4.parent > a"))).build().perform();

        driver.findElement(By.cssSelector("#nav > ol > li.level0.nav-4.parent > ul > li.level1.nav-4-1.first > a")).click();
        driver.findElement(By.cssSelector("body > div > div > div.main-container.col2-right-layout > div.main > div.col-main > div.category-products > ul > li:nth-child(2) > div > div.actions > a")).click();
        driver.findElement(By.cssSelector("#links_21")).click();
        driver.findElement(By.cssSelector("#product_addtocart_form > div.product-shop > div.product-options-bottom > div.add-to-cart > div.add-to-cart-buttons > button")).click();

        String shoppingCart = driver.findElement(By.cssSelector("body > div > div > div.main-container.col1-layout > div > div > div.cart.display-single-price > div.page-title.title-buttons > h1")).getText();
        String itemAdded = driver.findElement(By.cssSelector("#shopping-cart-table > tbody > tr > td.product-cart-info > h2 > a")).getText();
        if (shoppingCart.equalsIgnoreCase("SHOPPING CART") && itemAdded.equalsIgnoreCase("Alice in Wonderland"))
            System.out.println(greenColorCode + "Successfully added to Shopping Cart!" + resetColorCode);
        else
            System.err.println("!Success when trying to add to Shopping Cart");

        driver.close();
    }

    public void deleteConfigurableProductFromCartTest() {
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("http://qa3magento.dev.evozon.com/");

        Actions actions = new Actions(driver);
        actions.moveToElement(driver.findElement(By.cssSelector("#nav > ol > li.level0.nav-4.parent > a"))).build().perform();

        driver.findElement(By.cssSelector("#nav > ol > li.level0.nav-4.parent > ul > li.level1.nav-4-1.first > a")).click();
        driver.findElement(By.cssSelector("body > div > div > div.main-container.col2-right-layout > div.main > div.col-main > div.category-products > ul > li:nth-child(2) > div > div.actions > a")).click();
        driver.findElement(By.cssSelector("#links_21")).click();
        driver.findElement(By.cssSelector("#product_addtocart_form > div.product-shop > div.product-options-bottom > div.add-to-cart > div.add-to-cart-buttons > button")).click();

        String shoppingCart = driver.findElement(By.cssSelector("body > div > div > div.main-container.col1-layout > div > div > div.cart.display-single-price > div.page-title.title-buttons > h1")).getText();
        String itemToBeDeleted = driver.findElement(By.cssSelector("#shopping-cart-table > tbody > tr > td.product-cart-info > h2 > a")).getText();

        if (shoppingCart.equalsIgnoreCase("SHOPPING CART") && itemToBeDeleted.equalsIgnoreCase("Alice in Wonderland")) {
            System.out.println(greenColorCode + "Successfully added to Shopping Cart!" + resetColorCode);
            driver.findElement(By.cssSelector("#shopping-cart-table > tbody > tr > td.product-cart-remove.last > a")).click();
            String emptyShoppingCart = driver.findElement(By.cssSelector("body > div > div > div.main-container.col1-layout > div > div > div.page-title > h1")).getText();
            if (emptyShoppingCart.equalsIgnoreCase("SHOPPING CART IS EMPTY"))
                System.out.println(greenColorCode + "Item successfully deleted from Shopping Cart!" + resetColorCode);
            else
                System.err.println("!Success when trying to delete item from Shopping Cart");
        }
        else
            System.err.println("!Success when trying to add to Shopping Cart");

        driver.close();
    }

    public void updateConfigurableProductInCartTest() {
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("http://qa3magento.dev.evozon.com/");

        //add
        Actions actions = new Actions(driver);
        actions.moveToElement(driver.findElement(By.cssSelector("#nav > ol > li.level0.nav-4.parent > a"))).build().perform();

        driver.findElement(By.cssSelector("#nav > ol > li.level0.nav-4.parent > ul > li.level1.nav-4-1.first > a")).click();
        driver.findElement(By.cssSelector("body > div > div > div.main-container.col2-right-layout > div.main > div.col-main > div.category-products > ul > li:nth-child(2) > div > div.actions > a")).click();
        driver.findElement(By.cssSelector("#links_21")).click();
        driver.findElement(By.cssSelector("#product_addtocart_form > div.product-shop > div.product-options-bottom > div.add-to-cart > div.add-to-cart-buttons > button")).click();

        //update
        driver.findElement(By.cssSelector("#shopping-cart-table > tbody > tr > td.product-cart-actions > input")).clear();
        driver.findElement(By.cssSelector("#shopping-cart-table > tbody > tr > td.product-cart-actions > input")).sendKeys("3");
        driver.findElement(By.cssSelector("#shopping-cart-table > tbody > tr > td.product-cart-actions > button > span > span")).click();

        String updatedQty = driver.findElement(By.cssSelector("#shopping-cart-table > tbody > tr > td.product-cart-actions > input")).getAttribute("value");

        if (updatedQty.equalsIgnoreCase("3"))
            System.out.println(greenColorCode + "Qty of item successfully updated" + resetColorCode);
        else
            System.err.println("!Success when trying to update the Qty");

        driver.close();
    }
}