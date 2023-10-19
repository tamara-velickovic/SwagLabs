package Tests;

import Base.BaseTest;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.Random;

public class CartTests extends BaseTest {

    @BeforeMethod
    public void pageSetUp (){
        driver.navigate().to(baseURL);
        logIn();
    }


    //Remove from Cart Test: Verify that products can be removed from the cart

    @Test
    public void verifyProductCanBeRemovedFromCart() throws InterruptedException { //when a cart has an item



        Random random = new Random();
        int randomIndex = random.nextInt(homePage.addButtons.size());

        homePage.clickOnAddToCart(randomIndex);

        String actualNumberOfItems = globalElements.cartAfterAdding.getText();
        String expectedNumberOfItems = "1";

        Assert.assertEquals(actualNumberOfItems, expectedNumberOfItems);

        int nextRandomIndex =+1;


        homePage.clickOnAddToCart(nextRandomIndex);

        String actualNumberOfItemsAfterAdding = globalElements.cartAfterAdding.getText();
        String expectedNumberOfItemsAfterAdding = "2";

        Assert.assertEquals(actualNumberOfItemsAfterAdding, expectedNumberOfItemsAfterAdding);

        globalElements.clickOnCartButton();
        cartPage.clickOnRemoveButton();

        String actualNumberOfItemsAfterRemoving = globalElements.cartAfterAdding.getText();
        String expectedNumberOfItemsAfterRemoving = "1";

        Assert.assertEquals(actualNumberOfItemsAfterRemoving, expectedNumberOfItemsAfterRemoving);

        Thread.sleep(1500);
        //wait.until(ExpectedConditions.visibilityOf(globalElements.resetAppState));
        globalElements.clickOnResetAppState();

    }

    //RemoveAll from Cart

    @Test
    public void verifyAllItemsCanBeRemoved () {

        homePage.addAllToCart();

        String actualNumberOfItemsAfterAdding = globalElements.cartAfterAdding.getText();
        String expectedNumberOfItemsAfterAdding = "6";

        Assert.assertEquals(actualNumberOfItemsAfterAdding, expectedNumberOfItemsAfterAdding);

        globalElements.clickOnCartButton();
        cartPage.removeAllfromCart();

        Assert.assertTrue(cartPage.cartItems.isEmpty());


    }


    //Empty Cart Test: Verify behavior when attempting to proceed with an empty cart

    @Test
    public void verifyUserCannotProceedWithEmptyCart() {

        homePage.addAllToCart();

        String actualNumberOfItemsAfterAdding = globalElements.cartAfterAdding.getText();
        String expectedNumberOfItemsAfterAdding = "6";

        Assert.assertEquals(actualNumberOfItemsAfterAdding, expectedNumberOfItemsAfterAdding);

        globalElements.clickOnCartButton();
        cartPage.removeAllfromCart();

        Assert.assertTrue(cartPage.cartItems.isEmpty());

        Assert.assertFalse(cartPage.checkoutButton.isEnabled());

        //Fails, because user should not be able to proceed with an empty cart

        //cartPage.clickOnCheckoutButton();

    }












}
