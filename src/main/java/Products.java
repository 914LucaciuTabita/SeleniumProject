import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Products {
    WebDriver driver = new ChromeDriver();

    @Before
    public void  prepareData() {
        driver.manage().window().maximize();
        driver.get("http://qa3magento.dev.evozon.com/");
    }

    @Test
    public void validAscendingSortProducts() {
        Actions actions = new Actions(driver);
        actions.moveToElement(driver.findElement(By.cssSelector(".nav-4.parent > a"))).build().perform();
        driver.findElement(By.cssSelector(".nav-4-1.first > a")).click();

        driver.findElement(By.cssSelector(".category-products > div:not(.toolbar-bottom) .sort-by select")).click();

        Select select = new Select(driver.findElement(By.cssSelector(".category-products > div:not(.toolbar-bottom) .sort-by select")));
        select.selectByVisibleText("Name");

        List<WebElement> productElements = driver.findElements(By.cssSelector(".products-grid .item .product-name a[title]"));

        List<String> products = new ArrayList<>();
        for (WebElement productElement : productElements) {
            products.add(productElement.getAttribute("title"));
        }

        List<String> sortedProducts = new ArrayList<>(products);

        Collections.sort(sortedProducts, String.CASE_INSENSITIVE_ORDER);

        assert products.equals(sortedProducts) : "Products are not sorted by name.";
    }

    @Test
    public void validDescendingSortProducts() {
        Actions actions = new Actions(driver);
        actions.moveToElement(driver.findElement(By.cssSelector(".nav-4.parent > a"))).build().perform();
        driver.findElement(By.cssSelector(".nav-4-1.first > a")).click();

        driver.findElement(By.cssSelector(".category-products > div:not(.toolbar-bottom) .sort-by select")).click();

        Select select = new Select(driver.findElement(By.cssSelector(".category-products > div:not(.toolbar-bottom) .sort-by select")));
        select.selectByVisibleText("Name");

        driver.findElement(By.cssSelector(".category-products > div:not(.toolbar-bottom) .sort-by-switcher")).click();

        List<WebElement> productElements = driver.findElements(By.cssSelector(".products-grid .item .product-name a[title]"));

        List<String> products = new ArrayList<>();
        for (WebElement productElement : productElements) {
            products.add(productElement.getAttribute("title"));
        }

        List<String> sortedProducts = new ArrayList<>(products);

        Collections.sort(sortedProducts, Collections.reverseOrder());
///edfrdtgfhj
        assert products.equals(sortedProducts) : "Products are not sorted by name.";
    }

    @After
    public void closeWindow(){
        driver.close();
    }
}
