package Pages;

import Base.BaseTest;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CheckoutCompletePage extends BaseTest {

    public CheckoutCompletePage() {
        PageFactory.initElements(driver, this);
    }

    //Elements
   @FindBy(id="back-to-products")
    public WebElement backToProductsButton;

    @FindBy(className="complete-header")
    public WebElement thankYoumessage;



//-----------------------------------------------------------------------------

   public void clickOnBackToProductsButton() {
     backToProductsButton.click();
   }

   public String getThankYouMessage () {
      return  thankYoumessage.getText();}










}
