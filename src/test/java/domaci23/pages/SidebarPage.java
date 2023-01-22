package domaci23.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.WebDriverWait;

public class SidebarPage extends BasePage{

    @FindBy(id = "react-burger-menu-btn")
    private WebElement sidebar;

    @FindBy(id = "logout_sidebar_link")
    private WebElement logOut;

    public SidebarPage(WebDriver driver, WebDriverWait driverWait) {
        super(driver, driverWait);
    }

    public void sidebar() {
        sidebar.click();
    }
    public void logOut() {
        logOut.click();
    }


}