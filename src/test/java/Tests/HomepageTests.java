package Tests;

import Base.BaseTest;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Random;

public class HomepageTests extends BaseTest {

    @BeforeMethod
    public void pageSetUp (){
        driver.navigate().to(baseURL);
        logIn();
    }

    //Test if all elements are displayed


    @Test
    public void verifyAllItemNamesAreDisplayed () {

    List<String> actualProductNames = homePage.getProductNames();
    List<String> expectedProductNames = Arrays.asList("Sauce Labs Backpack", "Sauce Labs Bike Light", "Sauce Labs Bolt T-Shirt", "Sauce Labs Fleece Jacket", "Sauce Labs Onesie", "Test.allTheThings() T-Shirt (Red)");
    Assert.assertEquals(actualProductNames, expectedProductNames );

    }

    @Test
    public void verifyAllItemDescriptionsAreDisplayed () {

        List<String> actualDescriptions = homePage.getProductDescriptions();
        List<String> expectedDescriptions = Arrays.asList("carry.allTheThings() with the sleek, streamlined Sly Pack that melds uncompromising style with unequaled laptop and tablet protection.",
                                                          "A red light isn't the desired state in testing but it sure helps when riding your bike at night. Water-resistant with 3 lighting modes, 1 AAA battery included.",
                                                          "Get your testing superhero on with the Sauce Labs bolt T-shirt. From American Apparel, 100% ringspun combed cotton, heather gray with red bolt.",
                                                          "It's not every day that you come across a midweight quarter-zip fleece jacket capable of handling everything from a relaxing day outdoors to a busy day at the office.",
                                                          "Rib snap infant onesie for the junior automation engineer in development. Reinforced 3-snap bottom closure, two-needle hemmed sleeved and bottom won't unravel.",
                                                          "This classic Sauce Labs t-shirt is perfect to wear when cozying up to your keyboard to automate a few tests. Super-soft and comfy ringspun combed cotton.");

        for (int i = 0; i < actualDescriptions.size(); i++) {
            Assert.assertEquals(actualDescriptions.get(i).trim(), expectedDescriptions.get(i).trim());
        }

    }


    @Test
    public void verifyAllItemPricesAreDisplayed () {

        List<Double> actualPrices = homePage.getProductPrices();
        List<Double> expectedPrices = Arrays.asList(29.99, 9.99, 15.99, 49.99, 7.99, 15.99);
        Assert.assertEquals(actualPrices, expectedPrices, "Product prices do not match.");

    }
  /*  @Test

    public void verifyAllItemImagesAreDisplayed() {
        boolean allImagesDisplayed = true;

        for (WebElement productImage : homePage.productImages) {
            String imageUrl = productImage.getAttribute("src");

            if (imageUrl == null || imageUrl.isEmpty()) {
                allImagesDisplayed = false;
                break;
            }
        } */



    //Test if products can be added to the cart from the homepage
    //Boundary Test for product count: Test the maximum number of products that can be added to the cart

    @Test
    public void verifyRandomProductCanBeAddedtoCart () throws InterruptedException {


        globalElements.clickOnResetAppState();
        wait.until(ExpectedConditions.visibilityOf(globalElements.hamMenuClose));
        globalElements.clickOnHamMenuClose();

        Random random = new Random();
        int randomIndex = random.nextInt(homePage.addButtons.size());

        homePage.clickOnAddToCart(randomIndex);

        String actualNumberOfItems = globalElements.cartAfterAdding.getText();
        String expectedNumberOfItems = "1";

        Assert.assertEquals(actualNumberOfItems, expectedNumberOfItems);

        globalElements.clickOnResetAppState();

    }

    @Test
    public void verifyAllProductCanBeAddedtoCart () throws InterruptedException {


        globalElements.clickOnResetAppState();
        wait.until(ExpectedConditions.visibilityOf(globalElements.hamMenuClose));
        globalElements.clickOnHamMenuClose();


        homePage.addAllToCart();

        String actualNumberOfItems = globalElements.cartAfterAdding.getText();
        String expectedNumberOfItems = "6";

        Assert.assertEquals(actualNumberOfItems, expectedNumberOfItems);

        Thread.sleep(1500);
        //wait.until(ExpectedConditions.visibilityOf(globalElements.resetAppState));
        globalElements.clickOnResetAppState();

    }

    @Test
    public void verifySortingAtoZ() {

    Assert.assertEquals( homePage.getActiveOptionText(), nameAtoZ);

        List<String> actualProductNames = homePage.getProductNames();
        List<String> expectedProductNames = Arrays.asList("Sauce Labs Backpack", "Sauce Labs Bike Light", "Sauce Labs Bolt T-Shirt", "Sauce Labs Fleece Jacket", "Sauce Labs Onesie", "Test.allTheThings() T-Shirt (Red)");
        Assert.assertEquals(actualProductNames, expectedProductNames);


    }

    @Test
    public void verifySortingZtoA() {

        List<String> actualProductNames = homePage.getProductNames();
        List<String> expectedProductNames = Arrays.asList("Sauce Labs Backpack", "Sauce Labs Bike Light", "Sauce Labs Bolt T-Shirt", "Sauce Labs Fleece Jacket", "Sauce Labs Onesie", "Test.allTheThings() T-Shirt (Red)");
        Assert.assertEquals(actualProductNames, expectedProductNames);

        homePage.selectSortingOption(nameZtoA);
        Collections.sort(expectedProductNames, Collections.reverseOrder());
        List<String> actualProductNamesAfterSorting = homePage.getProductNames();

        Assert.assertEquals(actualProductNamesAfterSorting, expectedProductNames);

    }

    @Test
    public void verifySortingPriceLoHi() {

        List<Double> actualPrices = homePage.getProductPrices();
        List<Double> expectedPrices = Arrays.asList(29.99, 9.99, 15.99, 49.99, 7.99, 15.99);
        Assert.assertEquals(actualPrices, expectedPrices);


        homePage.selectSortingOption(priceLoHi);
        Collections.sort(expectedPrices);
        List<Double> actualPricesAfterSorting = homePage.getProductPrices();

        Assert.assertEquals(actualPricesAfterSorting, expectedPrices );




    }

    @Test
    public void verifySortingPriceHiLo() {

        List<Double> actualPrices = homePage.getProductPrices();
        List<Double> expectedPrices = Arrays.asList(29.99, 9.99, 15.99, 49.99, 7.99, 15.99);
        Assert.assertEquals(actualPrices, expectedPrices);

        homePage.selectSortingOption(priceHiLo);
        Collections.sort(expectedPrices, Collections.reverseOrder());
        List<Double> actualPricesAfterSorting = homePage.getProductPrices();

        Assert.assertEquals(actualPricesAfterSorting, expectedPrices );


    }


}
