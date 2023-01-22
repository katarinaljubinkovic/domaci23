package domaci23.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.WebDriverWait;

public class InventoryPage extends BasePage{

    @FindBy(id="add-to-cart-sauce-labs-backpack")
    private WebElement addCartBtn;

    @FindBy(id = "remove-sauce-labs-backpack")
    private WebElement removeBtn;

    @FindBy(className = "shopping_cart_link")
    private WebElement cart;

    @FindBy(className = "shopping_cart_badge")
    private WebElement cartNumber;

    public InventoryPage(WebDriver driver, WebDriverWait driverWait) {
        super(driver, driverWait);
    }

    public void addToCart() {
        addCartBtn.click();
    }
    public String cartNumber () {
        return cartNumber.getText();
    }
    public void removeFromCart() {
        removeBtn.click();
    }
    public String emptyCart() {
        return cart.getText();
    }
}
