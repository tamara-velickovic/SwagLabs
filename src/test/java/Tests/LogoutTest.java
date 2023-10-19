package Tests;

import Base.BaseTest;
import org.testng.annotations.BeforeMethod;

public class LogoutTest extends BaseTest {

    @BeforeMethod
    public void pageSetUp (){
        driver.navigate().to(baseURL);
    }



}
