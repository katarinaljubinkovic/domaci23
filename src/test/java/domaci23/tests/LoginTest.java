package domaci23.tests;

import org.testng.Assert;
import org.testng.annotations.*;

public class LoginTest extends BaseTest {

    @Test
    public void loginValidDateTest() {
        loginPage.login("standard_user", "secret_sauce");

        String actualUrl = driver.getCurrentUrl();

        Assert.assertTrue(actualUrl.contains("/inventory.html"));
        driver.navigate().refresh();
        Assert.assertTrue(actualUrl.contains("/inventory.html"));
    }

    @Test
    public void loginInvalidPasswordTest() {
        loginPage.login("standard_user", "123");

        String actualUrl = driver.getCurrentUrl();
        String expectedUrl = "https://www.saucedemo.com/";

        Assert.assertEquals(actualUrl, expectedUrl);
        driver.navigate().refresh();
        Assert.assertEquals(actualUrl, expectedUrl);


        loginPage.login("standard_user", "123");

        String actualResult = loginPage.errorMassage();

        Assert.assertTrue(actualResult.contains("Username and password do not match"));
        driver.navigate().refresh();
        Assert.assertTrue(actualResult.contains("Username and password do not match"));
    }

    @Test
    public void loginInvalidDateTest() {
        loginPage.login("locked_out_user", "secret_sauce");

        String actualResult = loginPage.errorMassage();

        Assert.assertTrue(actualResult.contains("Sorry, this user has been locked out"));
        driver.navigate().refresh();
        Assert.assertTrue(actualResult.contains("Sorry, this user has been locked out"));
    }

}