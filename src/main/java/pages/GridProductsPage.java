package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class GridProductsPage extends BasePage {

    @FindBy(css = "a[title='View Details']")
    private WebElement viewDetailsButton;

    @FindBy(css = "a[title='Ribbed racerback tank top - Tabita']+div .add-to-links a.link-wishlist")
    private WebElement addToWishlistLink;

    public GridProductsPage(WebDriver driver){
        super(driver);
    }

    public void clickViewDetailsButton(){
        viewDetailsButton.click();
    }

    public void clickAddToWishlistLink(){
        addToWishlistLink.click();
    }
}
