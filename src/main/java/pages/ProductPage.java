package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ProductPage extends BasePage {

    @FindBy(id = "links_21")
    private WebElement linksCheckbox;

    @FindBy(css = "div.add-to-cart-buttons > button")
    private WebElement addToCartButton;

    @FindBy(css = ".option-pink")
    private WebElement pinkColor;

    @FindBy(css = "a[name='m'] .swatch-label")
    private WebElement sizeM;

    public ProductPage(WebDriver driver){
        super(driver);
    }

    public void clickLinksCheckbox(){
        linksCheckbox.click();
    }

    public void clickAddToCartButton(){
        addToCartButton.click();
    }

    public void selectPinkColor(){
        pinkColor.click();
    }

    public void selectSizeM(){
        sizeM.click();
    }
}
