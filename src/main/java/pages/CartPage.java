package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class CartPage extends BasePage {

    String titleConfigurableAddedProduct = "RIBBED RACERBACK TANK TOP - TABITA";

    @FindBy(css = "h1")
    private WebElement shoppingCartTitle;

    @FindBy(css = "h2 > a")
    private WebElement addedProductTitle;

    @FindBy(css = ".product-cart-remove .btn-remove")
    private WebElement removeButton;

    public CartPage(WebDriver driver){
        super(driver);
    }

    public String getShoppingCartTitle(){
        return shoppingCartTitle.getText();
    }

    public String getAddedProductTitle(){
        return addedProductTitle.getText();
    }

    public void clickRemoveButton(){
        removeButton.click();
    }
}
