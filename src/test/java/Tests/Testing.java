package Tests;

import Base.BaseTest;
import org.testng.annotations.BeforeMethod;

public class Testing extends BaseTest {


    @BeforeMethod
    public void pageSetUp() {
        driver.navigate().to(baseURL);
    }


    @org.testng.annotations.Test
    public void test() throws InterruptedException {

        loginPage.inputUsername("standard_user");
        loginPage.inputPassword("secret_sauce");
        loginPage.clickOnLoginButton();





    }
}