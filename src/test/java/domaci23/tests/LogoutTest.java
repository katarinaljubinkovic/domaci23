package domaci23.tests;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.annotations.*;
import domaci23.pages.SidebarPage;

public class LogoutTest extends BaseTest {
    SidebarPage sidebarPage;

    @BeforeClass
    public void beforeClass() {
        super.beforeClass();
        sidebarPage = new SidebarPage(driver, driverWait);
    }

    @BeforeMethod
    public void beforeMethod() {
        super.beforeMethod();
        loginPage.login("standard_user", "secret_sauce");
    }

    @Test
    public void logoutTest() {
        sidebarPage.sidebar();
        driverWait.until(ExpectedConditions.textToBePresentInElementLocated(By.id("logout_sidebar_link"), "LOGOUT"));
        sidebarPage.logOut();

        String expectedResult = "https://www.saucedemo.com/";
        String actualResult = driver.getCurrentUrl();

        Assert.assertEquals(actualResult, expectedResult);

        driver.get("https://www.saucedemo.com/inventory.html");

        String actualMassage = loginPage.errorMassage();

        Assert.assertTrue(actualMassage.contains("You can only access '/inventory.html' when you are logged in."));

    }
}
