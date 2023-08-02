import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class RegisterTest {
    String greenColorCode = "\u001B[32m";
    String resetColorCode = "\u001B[0m";

    public void validRegisterTest() {
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("http://qa3magento.dev.evozon.com/");

        driver.findElement(By.cssSelector("#header > div > div.skip-links > div > a > span.label")).click();
        driver.findElement(By.cssSelector("#header-account > div > ul > li:nth-child(5) > a")).click();
        driver.findElement(By.id("firstname")).sendKeys("Tabita");
        driver.findElement(By.id("lastname")).sendKeys("Lucaciu");
        driver.findElement(By.id("email_address")).sendKeys("tabylucaciu3@yahoo.com");
        // increment the value after "tabylucaciu" with 1 everytime
        driver.findElement(By.id("password")).sendKeys("password");
        driver.findElement(By.id("confirmation")).sendKeys("password");
        driver.findElement(By.id("is_subscribed")).click();
        driver.findElement(By.cssSelector("#form-validate > div.buttons-set > button > span > span")).click();

        String welcomeText = driver.findElement(By.cssSelector("body > div > div > div.main-container.col2-left-layout > div > div.col-main > div.my-account > div > div.welcome-msg > p.hello > strong")).getText();
        if (welcomeText.equalsIgnoreCase("Hello, Tabita Lucaciu!"))
            System.out.println(greenColorCode + "Successfully registered!" + resetColorCode);
        else
            System.err.println("NOT REGISTERED");

        driver.close();
    }
}
