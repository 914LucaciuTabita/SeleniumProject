import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class WishlistTest {
    String greenColorCode = "\u001B[32m";
    String resetColorCode = "\u001B[0m";

    public void validAddToWishlistTest() {
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("http://qa3magento.dev.evozon.com/");

        driver.findElement(By.cssSelector("#header > div > div.skip-links > div > a > span.label")).click();
        driver.findElement(By.cssSelector("#header-account > div > ul > li.last > a")).click();
        driver.findElement(By.id("email")).sendKeys("tabylucaciu@yahoo.com");
        driver.findElement(By.id("pass")).sendKeys("password");
        driver.findElement(By.id("send2")).click();

        Actions actions = new Actions(driver);
        actions.moveToElement(driver.findElement(By.cssSelector("#nav > ol > li.level0.nav-4.parent > a"))).build().perform();

        driver.findElement(By.cssSelector("#nav > ol > li.level0.nav-4.parent > ul > li.level1.nav-4-1.first > a")).click();
        driver.findElement(By.cssSelector("body > div > div > div.main-container.col2-right-layout > div.main > div.col-main > div.category-products > ul > li:nth-child(2) > div > div.actions > ul > li:nth-child(1) > a")).click();

        String myWishlist = driver.findElement(By.cssSelector("body > div > div > div.main-container.col2-left-layout > div > div.col-main > div.my-account > div.my-wishlist > div > h1")).getText();
        if (myWishlist.equalsIgnoreCase("MY WISHLIST"))
            System.out.println(greenColorCode + "Successfully added to Wishlist" + resetColorCode);
        else
            System.err.println("!Success when trying to add to Wishlist");

        driver.close();
    }
}
