import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class WishlistTest {
    WebDriver driver = new ChromeDriver();

    @Before
    public void prepareData(){
        driver.manage().window().maximize();
        driver.get("http://qa3magento.dev.evozon.com/");

        driver.findElement(By.cssSelector(".skip-link.skip-account span.label")).click();
        driver.findElement(By.cssSelector("#header-account.skip-content .last a")).click();
        driver.findElement(By.id("email")).sendKeys("tabylucaciu@yahoo.com");
        driver.findElement(By.id("pass")).sendKeys("password");
        driver.findElement(By.id("send2")).click();
    }

    @Test
    public void validAddToWishlistTest() {
        Actions actions = new Actions(driver);
        actions.moveToElement(driver.findElement(By.cssSelector(".nav-4.parent > a"))).build().perform();

        driver.findElement(By.cssSelector(".nav-4-1.first > a")).click();
        driver.findElement(By.cssSelector("a[title='Alice in Wonderland']+div .add-to-links a.link-wishlist")).click();

        String myWishlist = driver.findElement(By.cssSelector(".page-title h1")).getText().toUpperCase();
        Assert.assertEquals("MY WISHLIST", myWishlist);
    }

    @After
    public void closeWindow(){
        driver.close();
    }
}
