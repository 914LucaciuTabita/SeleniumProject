package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class AccountPage extends BasePage {

    @FindBy(css = ".hello strong")
    private WebElement welcomeTextParagraph;

    public AccountPage(WebDriver driver) {
        super(driver);
    }

    public String getWelcomeText(){
        return welcomeTextParagraph.getText();
    }
}
