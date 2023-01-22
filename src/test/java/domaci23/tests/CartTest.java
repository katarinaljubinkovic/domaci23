package domaci23.tests;

import org.testng.Assert;
import org.testng.annotations.*;
import domaci23.pages.InventoryPage;

public class CartTest extends BaseTest {
    InventoryPage inventoryPage;

    @BeforeClass
    public void beforeClass() {
        super.beforeClass();
        inventoryPage = new InventoryPage(driver, driverWait);
    }
    @BeforeMethod
    public void beforeMethod() {
        super.beforeMethod();
        loginPage.login("standard_user", "secret_sauce");
    }
    @Test
    public void AddToCartTest() {
        inventoryPage.addToCart();

        String actualResult = inventoryPage.cartNumber();

        Assert.assertTrue(actualResult.contains("1"));
    }
    @Test
    public void RemoveFromCartTest() {
        inventoryPage.removeFromCart();

        String actualResult = inventoryPage.emptyCart();

        Assert.assertTrue(actualResult.contains(""));  // true (null vrednost)
    }

}

