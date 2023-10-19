package Pages;

import Base.BaseTest;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class GlobalElements extends BaseTest {

   public GlobalElements() {PageFactory.initElements(driver, this);}


   @FindBy(className = "bm-item-list")
   public WebElement hamMenu;

   @FindBy(id = "react-burger-menu-btn")
   public WebElement hamMenuButton;

   @FindBy(id = "react-burger-cross-btn")
   public WebElement hamMenuClose;

   @FindBy(id="inventory_sidebar_link")
   public WebElement allItems;

   @FindBy(id="about_sidebar_link")
   public WebElement aboutButton;

   @FindBy(id="logout_sidebar_link")
   public WebElement logOutButton;

   @FindBy(id="reset_sidebar_link")
   public WebElement resetAppState;

   @FindBy(linkText = "Twitter")
   public WebElement twitterIcon;
   @FindBy(linkText = "Facebook")
   public WebElement facebookIcon;
   @FindBy(linkText = "LinkedIn")
   public WebElement linkedinIcon;
   @FindBy(className = "shopping_cart_link")
   public WebElement cartButton;

   @FindBy(className = "shopping_cart_badge")
   public WebElement cartAfterAdding;


//-----------------------------------------------------------------------------

   public void clickOnAllItems () {
      clickOnHamMenuButton();
      allItems.click();
   }

   public void clickOnAboutButton () {
      clickOnHamMenuButton();
      aboutButton.click();
   }

   public void clickOnLogOutButton () {
      clickOnHamMenuButton();
      logOutButton.click();
   }

   public void clickOnResetAppState () {
      clickOnHamMenuButton();
      resetAppState.click();}

   public void clickOnHamMenuButton () {hamMenuButton.click();}

   public void clickOnHamMenuClose () {hamMenuClose.click();}


   public void clickOnTwitterIcon() {
      twitterIcon.click();
   }

   public void clickOnFaceBookIcon() {
      facebookIcon.click();
   }

   public void clickOnLinkedInIcon() {
      linkedinIcon.click();
   }

   public void clickOnCartButton() {
      cartButton.click();
   }

   public String getNumberOfItemsInCart () {
      return cartAfterAdding.getText();
   }

}
