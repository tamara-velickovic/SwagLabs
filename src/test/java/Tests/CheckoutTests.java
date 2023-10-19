package Tests;

import Base.BaseTest;
import com.github.javafaker.Faker;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.Random;

public class CheckoutTests extends BaseTest {

    @BeforeMethod
    public void pageSetUp (){
        driver.navigate().to(baseURL);
        logIn();
    }



    @Test
    public void verifyCartSubtotalCalculation() { //All items

      homePage.addAllToCart();

      ArrayList<Double> productPrices =  homePage.getProductPrices();
      double expectedTotalPrice = 0.0;

        for (int i = 0; i < productPrices.size(); i++) {
            expectedTotalPrice += productPrices.get(i);
        }

        globalElements.clickOnCartButton();
        cartPage.clickOnCheckoutButton();

        checkoutPage1.inputFirstName("Tamara");
        checkoutPage1.inputLastName("Velickovic");
        checkoutPage1.inputpostalCode("11040");
        checkoutPage1.clickOnContinueButton();

        //String expectedTotalPriceAsString = "Item total: "+expectedTotalPrice;
        String expectedTotalPriceFormatted = String.format("Item total: $%.2f", expectedTotalPrice);
        String actualTotalPrice = checkoutPage2.getSubtotalPrice();


        Assert.assertEquals(expectedTotalPriceFormatted, actualTotalPrice);

        System.out.println("Expected: " + expectedTotalPriceFormatted);
        System.out.println("Actual: " + actualTotalPrice);






    }



    @Test
    public void verifyValidCheckoutScenario() {

        Random random = new Random();
        int randomIndex = random.nextInt(homePage.addButtons.size());

        homePage.clickOnAddToCart(randomIndex);

        Faker faker = new Faker();

        String firstName = faker.name().firstName();
        String lastName = faker.name().lastName();
        String postalCode = faker.address().zipCode();


        globalElements.clickOnCartButton();
        cartPage.clickOnCheckoutButton();

        checkoutPage1.inputFirstName(firstName);
        checkoutPage1.inputLastName(lastName);
        checkoutPage1.inputpostalCode(postalCode);
        checkoutPage1.clickOnContinueButton();
        checkoutPage2.clickOnFinishButton();

        String ActualMessage =checkoutCompletePage.getThankYouMessage();
        String ExpectedMessage = "Thank you for your order!";

        Assert.assertEquals(ExpectedMessage,ActualMessage);
        Assert.assertTrue(checkoutCompletePage.backToProductsButton.isDisplayed());


    }

    @Test
    public void verifyUserCannotCheckoutWithBlankForm() throws InterruptedException {

        Random random = new Random();
        int randomIndex = random.nextInt(homePage.addButtons.size());

        homePage.clickOnAddToCart(randomIndex);

        globalElements.clickOnCartButton();
        cartPage.clickOnCheckoutButton();
        checkoutPage1.clickOnContinueButton();


        String expectedErrorMessage = "Error: First Name is required";
        //Thread.sleep(1500);
        Assert.assertEquals(expectedErrorMessage, checkoutPage1.getErrorMessageText());

    }

    @Test
    public void verifyUserCannotCheckoutWithInvalidForm() {

        Random random = new Random();
        int randomIndex = random.nextInt(homePage.addButtons.size());

        homePage.clickOnAddToCart(randomIndex);

        globalElements.clickOnCartButton();
        cartPage.clickOnCheckoutButton();

        checkoutPage1.inputFirstName("A");
        checkoutPage1.inputLastName("B");
        checkoutPage1.inputpostalCode("C");

        Assert.assertFalse(checkoutPage1.continueButton.isEnabled());
        


    }



}
