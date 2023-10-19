package Tests;

import Base.BaseTest;
import org.testng.annotations.BeforeMethod;

public class Test extends BaseTest {


    @BeforeMethod
    public void pageSetUp (){
    driver.navigate().to(baseURL);
    }


    @org.testng.annotations.Test
    public void test() throws InterruptedException {

        loginPage.inputUsername("standard_user");
        loginPage.inputPassword("secret_sauce");
        loginPage.clickOnLoginButton();
        //homePage.clickProductByName("Sauce Labs Backpack");




       /* productsPage.clickOnCartButton();
        cartPage.clickOnContinueShopping();
        productsPage.clickOnCartButton();
        cartPage.clickOnCheckoutButton();

        checkoutPage1.clickOnCancelButton();
        cartPage.clickOnCheckoutButton();

        checkoutPage1.inputFirstName("Tamara");
        checkoutPage1.inputLastName("Velickovic");
        checkoutPage1.inputpostalCode("11040");
        checkoutPage1.clickOnContinueButton();

        checkoutPage2.clickOnCancelButton();
        productsPage.clickOnCartButton();
        cartPage.clickOnCheckoutButton();


        checkoutPage1.inputFirstName("Tamara");
        checkoutPage1.inputLastName("Velickovic");
        checkoutPage1.inputpostalCode("11040");
        checkoutPage1.clickOnContinueButton();
        checkoutPage2.clickOnFinishButton();

        checkoutCompletePage.clickOnBackToProductsButton(); */


       // productsPage.clickOnAddToCart(0);
        homePage.addAllToCart();
        globalElements.clickOnCartButton();
       // cartPage.removeAllfromCart();
        cartPage.clickOnRemoveButton();
    }



}
