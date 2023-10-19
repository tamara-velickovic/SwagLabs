package Tests;

import Base.BaseTest;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class NavigationTests extends BaseTest {

    @BeforeMethod
    public void pageSetUp (){
        driver.navigate().to(baseURL);
        logIn();
    }


    @Test
    public void verifyCartAccessFromRandomPages () throws InterruptedException {

        globalElements.clickOnCartButton();
        Assert.assertEquals(driver.getCurrentUrl(), cartPageURL);


        cartPage.clickOnContinueShopping();
        Assert.assertEquals(driver.getCurrentUrl(), homePageURL);


        globalElements.clickOnCartButton();
        cartPage.clickOnCheckoutButton();
        Assert.assertEquals(driver.getCurrentUrl(), checkoutOnePageURL);

        checkoutPage1.clickOnCancelButton();
        Assert.assertEquals(driver.getCurrentUrl(), cartPageURL);


        //globalElements.clickOnCartButton();
        cartPage.clickOnCheckoutButton();
        //Make a base method out of this
        checkoutPage1.inputFirstName("Tamara");
        checkoutPage1.inputLastName("Velickovic");
        checkoutPage1.inputpostalCode("11040");
        checkoutPage1.clickOnContinueButton();
        Assert.assertEquals(driver.getCurrentUrl(), checkoutTwoPageURL);


        checkoutPage2.clickOnCancelButton();
        //globalElements.clickOnCartButton();
        Thread.sleep(1500);
        cartPage.clickOnCheckoutButton();

        //Make a base method out of this
        checkoutPage1.inputFirstName("Tamara");
        checkoutPage1.inputLastName("Velickovic");
        checkoutPage1.inputpostalCode("11040");
        checkoutPage1.clickOnContinueButton();

        Assert.assertEquals(driver.getCurrentUrl(), checkoutTwoPageURL);

        checkoutPage2.clickOnFinishButton();

        Assert.assertEquals(driver.getCurrentUrl(), checkoutCompleteURL);


        checkoutCompletePage.clickOnBackToProductsButton();

        Assert.assertEquals(driver.getCurrentUrl(), homePageURL);



    }


    //Hamburger menu is hidden and hamburger menu has expected items


   // Hamburger Menu Test: Verify navigation to About, Logout, All Items, and Reset App State.
   //Cart Page Navigation Test: Test navigating to the cart from different pages.


    //Social media

    //Navigate around

    //Open item in new tab

}
