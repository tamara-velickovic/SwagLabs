package Tests;

import Base.BaseTest;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.ArrayList;

public class NavigationTests extends BaseTest {

    @BeforeMethod
    public void pageSetUp (){
        driver.navigate().to(baseURL);
        logIn();
    }


    // Hamburger Menu Test: Verify navigation to About, Logout, All Items, and Reset App State
    //Hamburger menu is hidden and hamburger menu has expected items
    //Social media, T&c, Privacy policy

    //Cart Page Navigation Test: Test navigating to the cart from different

    //Open items in new tab (bug)

    @Test
    public void verifyProductPageCanBeOpenedInNewTab() {

        WebElement productLink= driver.findElement(By.id("item_4_title_link"));

        JavascriptExecutor jsExecutor = (JavascriptExecutor) driver;
        String script = "window.open(arguments[0], '_blank');";
        jsExecutor.executeScript(script, productLink.getAttribute("href"));

        ArrayList<String> tabList = new ArrayList<>(driver.getWindowHandles());
        driver.switchTo().window(tabList.get(1));

        Assert.assertEquals(driver.getCurrentUrl(), productOneDetailsURL );
        //Fails, products page did not open
    }


    @Test
    public void verifyRandomNagivation() throws InterruptedException {


        //Go to cart page

        globalElements.clickOnCartButton();
        Assert.assertEquals(driver.getCurrentUrl(), cartPageURL);

        //Go back to homepage


        cartPage.clickOnContinueShopping();
        Assert.assertEquals(driver.getCurrentUrl(), homePageURL);

        //Go to first checkout page

        globalElements.clickOnCartButton();
        cartPage.clickOnCheckoutButton();
        Assert.assertEquals(driver.getCurrentUrl(), checkoutOnePageURL);

        //Go Back To Cart

        checkoutPage1.clickOnCancelButton();
        Assert.assertEquals(driver.getCurrentUrl(), cartPageURL);


        //Go to second checkout page

        cartPage.clickOnCheckoutButton();
        //Make a base method out of this
        checkoutPage1.inputFirstName("Tamara");
        checkoutPage1.inputLastName("Velickovic");
        checkoutPage1.inputpostalCode("11040");
        checkoutPage1.clickOnContinueButton();
        Assert.assertEquals(driver.getCurrentUrl(), checkoutTwoPageURL);

        //Go back to homepage

        checkoutPage2.clickOnCancelButton();
        Assert.assertEquals(driver.getCurrentUrl(), homePageURL);

        //Go to finish checkout page

        Thread.sleep(1500);
        globalElements.clickOnCartButton();
        cartPage.clickOnCheckoutButton();

        //Make a base method out of this
        checkoutPage1.inputFirstName("Tamara");
        checkoutPage1.inputLastName("Velickovic");
        checkoutPage1.inputpostalCode("11040");
        checkoutPage1.clickOnContinueButton();

        Assert.assertEquals(driver.getCurrentUrl(), checkoutTwoPageURL);

        checkoutPage2.clickOnFinishButton();

        Assert.assertEquals(driver.getCurrentUrl(), checkoutCompleteURL);

        //Back to homepage

        checkoutCompletePage.clickOnBackToProductsButton();
        Assert.assertEquals(driver.getCurrentUrl(), homePageURL);

        //Go to product details page

        //Hardcoded for now, change later

       /* homePage.clickOnProductName("Sauce Labs Backpack");

        Assert.assertEquals(driver.getCurrentUrl(), productOneDetailsURL); */

    }










}





