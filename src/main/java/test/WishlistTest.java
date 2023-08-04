package test;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import utils.Constants;

public class WishlistTest extends BaseTest {

    @Before
    public void login(){
        homepage.clickAccountLink();
        homepage.clickLoginLink();

        loginPage.setEmailField(Constants.USER_EMAIL);
        loginPage.setPasswordField(Constants.USER_PASSWORD);
        loginPage.clickLoginButton();
    }

    @Test
    public void validAddToWishlistTest() {
        String text = "TABITA";
        headerPage.setSearchInput(text);
        headerPage.clickSearchButton();

        gridProductsPage.clickAddToWishlistLink();

        Assert.assertEquals("MY WISHLIST", wishlistPage.getWishlistText());
        Assert.assertEquals("RIBBED RACERBACK TANK TOP - TABITA", wishlistPage.getTitleProduct());
    }
}
