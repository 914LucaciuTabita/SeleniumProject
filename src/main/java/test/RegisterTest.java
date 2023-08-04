package test;

import com.github.javafaker.Faker;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class RegisterTest extends BaseTest {

    @Test
    public void validRegisterTest() {
        String firstname = "Tabita";
        String lastname = "Lucaciu";
        String password = "password";

        homepage.clickAccountLink();
        homepage.clickRegisterLink();

        registerPage.setFirstnameField(firstname);
        registerPage.setLastnameField(lastname);
        registerPage.setRandomEmailAddressField();
        registerPage.setPasswordField(password);
        registerPage.setConfirmationPasswordField(password);
        registerPage.setIsSubscribedCheckbox();
        registerPage.clickRegisterButton();

        Assert.assertEquals("Hello, " + firstname + " " + lastname + "!", accountPage.getWelcomeText());
    }

}
