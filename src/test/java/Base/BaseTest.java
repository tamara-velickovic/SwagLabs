
package Base;


import Pages.*;
import Pages.Products.Product;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;

import java.io.IOException;
import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class BaseTest {

   public static WebDriver driver;
   public WebDriverWait wait;

   public ExcelReader excelReader;

   //Pages

    public LoginPage loginPage;
    public HomePage homePage;
    public GlobalElements globalElements;
    public CartPage cartPage;
    public CheckoutPage1 checkoutPage1;
    public CheckoutPage2 checkoutPage2;
    public CheckoutCompletePage checkoutCompletePage;

    public List<Product> products;

    //URLS

    public static String baseURL =  "https://www.saucedemo.com/";
    public static String homePageURL =  baseURL+"inventory.html";

    public static String cartPageURL = baseURL +"cart.html";
    public static String checkoutOnePageURL =  baseURL+"checkout-step-one.html";

    public static String checkoutTwoPageURL =  baseURL+"checkout-step-two.html";

    public static String checkoutCompleteURL =  baseURL+"checkout-complete.html";

    public static String productOneDetailsURL =  baseURL+"inventory-item.html?id=4";





    //Other data

    public static String[] validUsernames = {"standard_user", "locked_out_user", "problem_user", "performance_glitch_user", "error_user", "visual_user"};

    public static String[] mixedUsernames = {"standard_user", "invalidUser", "user", "visual_user"}; // half valid, half invalid

    public static String[] mixedPasswords = {"secret_sauce", "InvalidPass"}; // half valid, half invalid

    public static String validPassword = "secret_sauce";

    public static String validUsername = "standard_user";

    //Error messages

    public static String invalidCredentialsError = "Epic sadface: Username and password do not match any user in this service";
    public static String usernameBlankError = "Epic sadface: Username is required";

    public static String passwordBlankError = "Epic sadface: Password is required";

    public static String blankCredentialsError = "Epic sadface: Username and password are required";

    public static String usernameNotExists = "Epic sadface: Username and password do not match any user in this service";






    @BeforeClass
    public void setUp() throws IOException {

        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();

        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));

        //excelReader = new ExcelReader("C:\\Users\\mik\\Desktop\\TestData.xlsx");
        excelReader = new ExcelReader("src/test/java/TestData.xlsx");

        loginPage = new LoginPage();
        homePage = new HomePage();
        globalElements = new GlobalElements();
        cartPage = new CartPage();
        checkoutPage1= new CheckoutPage1();
        checkoutPage2= new CheckoutPage2();
        checkoutCompletePage = new CheckoutCompletePage();

        products = new ArrayList<>();

    }


    @AfterClass
    public void tearDown(){

       // driver.quit();
    }


    //-----------------------------------------------------

    @DataProvider(name = "selectRandomUsername")
    public Object[][] selectRandomUsername() {
        Random random = new Random();
        int randomIndex = random.nextInt(validUsernames.length);
        String randomUsername = validUsernames[randomIndex];
        return new Object[][]{{randomUsername}};
    }

    public void logIn() {

        loginPage.inputUsername(validUsername);
        loginPage.inputPassword(validPassword);
        loginPage.clickOnLoginButton();



    }


}
