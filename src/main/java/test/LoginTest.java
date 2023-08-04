package test;

import org.junit.Assert;
import org.junit.Test;
import utils.Constants;

public class LoginTest extends BaseTest {

    @Test
    public void validLoginTest(){
        homepage.clickAccountLink();
        homepage.clickLoginLink();

        loginPage.setEmailField(Constants.USER_EMAIL);
        loginPage.setPasswordField(Constants.USER_PASSWORD);
        loginPage.clickLoginButton();

        Assert.assertEquals("Hello, " + Constants.USERNAME + "!", accountPage.getWelcomeText());
    }

}
