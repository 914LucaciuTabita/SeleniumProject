package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;

public class HeaderPage extends BasePage {

    Actions actions = new Actions(driver);

    @FindBy(css = ".nav-4.parent > a")
    private WebElement homeDecorLink;

    @FindBy(css = ".nav-4-1.first > a")
    private WebElement booksMusicLink;

    @FindBy(id = "search")
    private WebElement searchInput;

    @FindBy(css = "button[title='Search']")
    private WebElement searchButton;

    public HeaderPage(WebDriver driver){
        super(driver);
    }

    public void hoverHomeDecorLink(){
        actions.moveToElement(driver.findElement(By.cssSelector(".nav-4.parent > a"))).build().perform();
    }

    public void clickBooksMusicLink(){
        booksMusicLink.click();
    }

    public void setSearchInput(String text){
        searchInput.sendKeys(text);
    }

    public void clickSearchButton(){
        searchButton.click();
    }

    public void sendSearchInput(){
        searchInput.sendKeys(Keys.ENTER);
    }
}
