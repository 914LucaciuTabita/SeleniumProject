import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class LoginTest {
    String greenColorCode = "\u001B[32m";
    String resetColorCode = "\u001B[0m";

    public void validLoginTest(){
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("http://qa3magento.dev.evozon.com/");

        driver.findElement(By.cssSelector("#header > div > div.skip-links > div > a > span.label")).click();
        driver.findElement(By.cssSelector("#header-account > div > ul > li.last > a")).click();
        driver.findElement(By.id("email")).sendKeys("tabylucaciu@yahoo.com");
        driver.findElement(By.id("pass")).sendKeys("password");
        driver.findElement(By.id("send2")).click();
        String welcomeText = driver.findElement(By.cssSelector("body > div > div.page > div.main-container.col2-left-layout > div > div.col-main > div.my-account > div > div.welcome-msg > p.hello > strong")).getText();

        if (welcomeText.equalsIgnoreCase("Hello, Tabita Semida Lucaciu!"))
            System.out.println(greenColorCode + "Success!" + resetColorCode);
        else
            System.err.println("!Success");

        driver.close();
    }
}
