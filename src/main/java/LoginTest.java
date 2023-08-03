import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class LoginTest {
    String greenColorCode = "\u001B[32m";
    String resetColorCode = "\u001B[0m";
    WebDriver driver = new ChromeDriver();

    @Before
    public void prepareData(){
        driver.manage().window().maximize();
        driver.get("http://qa3magento.dev.evozon.com/");
        driver.findElement(By.cssSelector(".skip-link.skip-account span.label")).click();
        driver.findElement(By.cssSelector("#header-account.skip-content .last a")).click();
    }

    @Test
    public void validLoginTest(){
        driver.findElement(By.id("email")).sendKeys("tabylucaciu@yahoo.com");
        driver.findElement(By.id("pass")).sendKeys("password");
        driver.findElement(By.id("send2")).click();

        String welcomeText = driver.findElement(By.cssSelector(".hello strong")).getText();
        Assert.assertEquals("Hello, Tabita Semida Lucaciu!", welcomeText);
    }

    @After
    public void closeWindow(){
        driver.close();
    }
}
