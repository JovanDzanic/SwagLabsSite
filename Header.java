package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class Header extends BasePage{
    
    public Header (WebDriver driver){
        super(driver);
    }

    By menuNavigationBy = By.id("react-burger-menu-btn");
    By shoppingCartIconBy = By.className("shopping_cart_link");
    By closeMenuNavigationBy = By.id("react-burger-cross-btn");
    By menuOptionAllItemsBy = By.id("inventory_sidebar_link");
    By menuOptionAboutBy = By.id("about_sidebar_link");
    By menuOptionLogoutBy = By.id("logout_sidebar_link");
    By menuOptionResetAppStateBy = By.id("reset_sidebar_link");
    By shoppingCartBadgeBy = By.className("shopping_cart_badge");
    By productButtonAddToCartSauceLabsBackpackBy = By.id("add-to-cart-sauce-labs-backpack");

    public Header openMenu(){
        click(menuNavigationBy);
        waitVisibility(closeMenuNavigationBy);
        return this;
    }
    
    public Header closeMenu(){
        click(closeMenuNavigationBy);
        return this;
    }

    public Header menuOptionAllItems(){
        click(menuOptionAllItemsBy);
        return this;
    }

    public Header menuOptionAbout(){
        click(menuOptionAboutBy);
        return this;
    }

    public Header menuOptionLogout(){
        click(menuOptionLogoutBy);
        return this;
    }

    public Header menuOptionResetAppState(){
        click(menuOptionResetAppStateBy);
        waitVisibility(productButtonAddToCartSauceLabsBackpackBy);
        return this;
    }

    public Header shoppingCartIcon(){
        click(shoppingCartIconBy);
        return this;
    }

    public Header sauceLabsSite(String expectedURL){
        String actualURl = driver.getCurrentUrl();
        assertTextEquals(expectedURL, actualURl);
        return this;
    }

    public Header verifyProductAddedToCart(String expectedText){
        String actualText = readText(shoppingCartBadgeBy);
        assertTextEquals(expectedText, actualText);
        return this;
    }
}
