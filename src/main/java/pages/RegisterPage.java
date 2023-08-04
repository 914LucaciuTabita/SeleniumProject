package pages;

import com.github.javafaker.Faker;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class RegisterPage extends BasePage {
    Faker faker = new Faker();

    @FindBy(id = "firstname")
    private WebElement firstnameField;

    @FindBy(id = "lastname")
    private WebElement lastnameField;

    @FindBy(id = "email_address")
    private WebElement emailAddressField;

    @FindBy(id = "password")
    private WebElement passwordField;

    @FindBy(id = "confirmation")
    private WebElement confirmationPasswordField;

    @FindBy(id = "is_subscribed")
    private WebElement isSubscribedCheckbox;

    @FindBy(css = "button[title=Register] > span > span")
    private WebElement registerButton;

    public RegisterPage(WebDriver driver) {
        super(driver);
    }

    public void setFirstnameField(String firstname){
        firstnameField.sendKeys(firstname);
    }

    public void setLastnameField(String lastname){
        lastnameField.sendKeys(lastname);
    }

    public void setRandomEmailAddressField(){
        String randomEmailAddress = faker.bothify("??????##@gmail.com");
        emailAddressField.sendKeys(randomEmailAddress);
    }

    public void setPasswordField(String password){
        passwordField.sendKeys(password);
    }

    public void setConfirmationPasswordField(String confirmationPassword) {
        confirmationPasswordField.sendKeys(confirmationPassword);
    }

    public void setIsSubscribedCheckbox(){
        isSubscribedCheckbox.click();
    }

    public void clickRegisterButton(){
        registerButton.click();
    }
}
