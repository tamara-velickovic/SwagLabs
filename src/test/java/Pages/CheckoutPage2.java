package Pages;

import Base.BaseTest;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CheckoutPage2 extends BaseTest {

    public CheckoutPage2 () {
        PageFactory.initElements(driver, this);
    }



    //Element
    @FindBy(className="summary_subtotal_label")
    public WebElement subTotalPrice;
    @FindBy(id="finish")
    public WebElement finishButton;
    @FindBy(id="cancel")
    public WebElement cancelButton;

//-----------------------------------------------------------------------------

    public void clickOnFinishButton () {
    finishButton.click();
    }

    public void clickOnCancelButton () {
     cancelButton.click();
    }


   //Popravi ovo
    public String getSubtotalPrice () {


        return subTotalPrice.getText();
    }












}