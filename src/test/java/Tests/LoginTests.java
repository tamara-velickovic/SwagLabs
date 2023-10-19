package Tests;

import Base.BaseTest;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.Random;

public class LoginTests extends BaseTest {

    @BeforeMethod
    public void pageSetUp (){
        driver.navigate().to(baseURL);
    }


    //Test if all elements are displayed
    //(and/or clickable, can anything can be typed in, can fields be cleared, are error messages adequate...)

    @Test (priority = 10)
    public void verifyLogInElementsAreDisplayed () {
        loginPage.usernameField.isDisplayed();
        loginPage.passwordField.isDisplayed();
        loginPage.loginButton.isDisplayed();

    }


    //Positive LogIn Tests

    @Test(dataProvider = "selectRandomUsername")
    public void RandomUserLogin(String username) {

        loginPage.inputUsername(username);
        loginPage.inputPassword(validPassword);
        loginPage.clickOnLoginButton();


        //Assertions

        wait.until(ExpectedConditions.urlToBe(homePageURL));
        globalElements.logOutButton.isDisplayed();

    }


    //Negative LogIn Tests

    @Test
    public void userCannotLoginWithInvalidCredentials () {

        Random random = new Random();
        int randomIndex = random.nextInt(excelReader.getLastRow("Login"));

        String invalidUsername = excelReader.getStringData("Login",randomIndex, 0 );
        String invalidPassword = excelReader.getStringData("Login",randomIndex, 1 );

        loginPage.inputUsername(invalidUsername);
        loginPage.inputPassword(invalidPassword);
        loginPage.clickOnLoginButton();

        //Assertions

        Assert.assertNotEquals(driver.getCurrentUrl(), homePageURL);
        Assert.assertEquals(loginPage.errorMessage.getText(), invalidCredentialsError);

    }

    @Test
    public void userCannotLoginWithBlankUsername () {

       //The password will sometimes be valid, sometimes not

        Random random = new Random();
        int randomIndexPass = random.nextInt(mixedPasswords.length);
        String randomPass = mixedPasswords[randomIndexPass];


        loginPage.inputUsername("");
        loginPage.inputPassword(randomPass);
        loginPage.clickOnLoginButton();

        //Assertions

        Assert.assertNotEquals(driver.getCurrentUrl(), homePageURL);
        Assert.assertEquals(loginPage.errorMessage.getText(), usernameBlankError);

    }

    @Test
    public void userCannotLoginWithBlankPassword () {

        //The password will sometimes be valid, sometimes not

        Random random = new Random();
        int randomIndexPass = random.nextInt(mixedUsernames.length);
        String randomUsername = mixedUsernames[randomIndexPass];


        loginPage.inputUsername(randomUsername);
        loginPage.inputPassword("");
        loginPage.clickOnLoginButton();

        //Assertions

        Assert.assertNotEquals(driver.getCurrentUrl(), homePageURL);
        Assert.assertEquals(loginPage.errorMessage.getText(), passwordBlankError);

    }

    @Test
    public void userCannotLoginWithBlankCredentials () {


        loginPage.inputUsername("");
        loginPage.inputPassword("");
        loginPage.clickOnLoginButton();

        //Assertions

        Assert.assertNotEquals(driver.getCurrentUrl(), homePageURL);
        Assert.assertEquals(loginPage.errorMessage.getText(), blankCredentialsError);
        //Fails, error message should be that both fields are required
    }


    @Test(dataProvider = "selectRandomUsername")
    public void userCannotLoginWithInvalidPassword (String username) {


        Random random = new Random();
        int randomIndex = random.nextInt(excelReader.getLastRow("Login"));
        String invalidPassword= excelReader.getStringData("Login",randomIndex, 1 );


        loginPage.inputUsername(username);
        loginPage.inputPassword(invalidPassword);
        loginPage.clickOnLoginButton();

        //Assertions

        Assert.assertNotEquals(driver.getCurrentUrl(), homePageURL);
        Assert.assertEquals(loginPage.errorMessage.getText(), passwordBlankError);
        //Fails, error message says "Username and password do not match any user in this service", but the username is always correct

    }


    @Test
    public void userCannotLoginWithInvalidUsername () {


        Random random = new Random();
        int randomIndex = random.nextInt(excelReader.getLastRow("Login"));
        String InvalidUsername= excelReader.getStringData("Login",randomIndex, 0 );


        loginPage.inputUsername(InvalidUsername);
        loginPage.inputPassword(validPassword);
        loginPage.clickOnLoginButton();

        //Assertions

        Assert.assertNotEquals(driver.getCurrentUrl(), homePageURL);
        Assert.assertEquals(loginPage.errorMessage.getText(), usernameNotExists);
        //Error message can be better, but acceptable

    }




}
