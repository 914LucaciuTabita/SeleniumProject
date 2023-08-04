package test;

import org.junit.Assert;
import org.junit.Test;

public class AddToCartTest extends BaseTest {

    @Test
    public void validAddConfigurableProductToCartTest() {
        String text = "TABITA";
        headerPage.setSearchInput(text);
        headerPage.sendSearchInput();

        gridProductsPage.clickViewDetailsButton();
        productPage.selectPinkColor();
        productPage.selectSizeM();
        productPage.clickAddToCartButton();

        Assert.assertEquals("SHOPPING CART", cartPage.getShoppingCartTitle());
        Assert.assertEquals("RIBBED RACERBACK TANK TOP - TABITA", cartPage.getAddedProductTitle());
    }
}
