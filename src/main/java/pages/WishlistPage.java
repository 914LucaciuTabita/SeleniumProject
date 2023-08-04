package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class WishlistPage extends BasePage {

    @FindBy(css = ".page-title h1")
    private WebElement wishlistText;

    @FindBy(css = ".product-name [title='Ribbed racerback tank top - Tabita']:last-child")
    private WebElement titleProduct;

    public WishlistPage(WebDriver driver){
        super(driver);
    }

    public String getWishlistText(){
        return wishlistText.getText();
    }

    public String getTitleProduct(){
        return titleProduct.getText();
    }
}
