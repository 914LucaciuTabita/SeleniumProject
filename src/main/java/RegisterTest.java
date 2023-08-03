import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class RegisterTest {
    String greenColorCode = "\u001B[32m";
    String resetColorCode = "\u001B[0m";
    WebDriver driver = new ChromeDriver();

    @Before
    public void prepareData(){
        driver.manage().window().maximize();
        driver.get("http://qa3magento.dev.evozon.com/");
        driver.findElement(By.cssSelector(".skip-link.skip-account span.label")).click();
        driver.findElement(By.cssSelector("a[title=Register]")).click();
    }

    @Test
    public void validRegisterTest() {
        driver.findElement(By.id("firstname")).sendKeys("Tabita");
        driver.findElement(By.id("lastname")).sendKeys("Lucaciu");
        driver.findElement(By.id("email_address")).sendKeys("tabylucaciu5@yahoo.com");
        // increment the value after "tabylucaciu" with 1 everytime
        driver.findElement(By.id("password")).sendKeys("password");
        driver.findElement(By.id("confirmation")).sendKeys("password");
        driver.findElement(By.id("is_subscribed")).click();
        driver.findElement(By.cssSelector("button[title=Register] > span > span")).click();

        String welcomeText = driver.findElement(By.cssSelector(".hello > strong")).getText();
        Assert.assertEquals("Hello, Tabita Lucaciu!", welcomeText);
    }

    @After
    public void closeWindow(){
        driver.close();
    }
}
