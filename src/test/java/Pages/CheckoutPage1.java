package Pages;

import Base.BaseTest;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CheckoutPage1 extends BaseTest {

    public CheckoutPage1 () {
        PageFactory.initElements(driver, this);
    }

   //Elements
    @FindBy(id="first-name")
    public WebElement firstNameField;

    @FindBy(id="last-name")
    public WebElement lastNameField;
    @FindBy(id="postal-code")
    public WebElement postalCodeField;

    @FindBy(id="continue")
    public WebElement continueButton;

    @FindBy(id="cancel")
    public WebElement cancelButton;

    @FindBy(css=".error-message-container.error")
    public WebElement errorMessage;


//-----------------------------------------------------------------------

   public void inputFirstName (String firstName) {
    firstNameField.clear();
    firstNameField.sendKeys(firstName);
   }

    public void inputLastName (String lastName) {
        lastNameField.clear();
        lastNameField.sendKeys(lastName);
    }

    public void inputpostalCode (String postalCode) {
        postalCodeField.clear();
        postalCodeField.sendKeys(postalCode);
    }

    public void clickOnContinueButton () {
     continueButton.click();
    }

    public void clickOnCancelButton () {
        cancelButton.click();
    }


    public String getErrorMessageText () {

      return errorMessage.getText();
    }









}
