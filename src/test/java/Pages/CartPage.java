package Pages;

import Base.BaseTest;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class CartPage extends BaseTest {

    public CartPage() {
        PageFactory.initElements(driver, this);
    }

  //Elements
    @FindBy(id="checkout")
    public WebElement checkoutButton;
    @FindBy(id="continue-shopping")
    public WebElement continueShoppingButton;
    @FindBy(css= ".btn.btn_secondary.btn_small.cart_button")
    public WebElement removeButton;

  @FindBy(css= ".btn.btn_secondary.btn_small.cart_button")
  public List<WebElement> removeButtons;

  @FindBy (className = "inventory_item_name")
  public List<WebElement> cartItems;

    @FindBy (className = "cart_list")
    public List<WebElement> cartList;




//-----------------------------------------------------------------------------

    public void clickOnCheckoutButton () {
    checkoutButton.click();
    }
    public void clickOnContinueShopping() {
    continueShoppingButton.click();
    }

    //Remove specific item
    public void clickOnRemoveButton() {
        removeButton.click();
    }

    public void removeAllfromCart () {

      for (WebElement removeButton : removeButtons)
           removeButton.click();}



















}