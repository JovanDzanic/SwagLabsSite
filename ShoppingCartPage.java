package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ShoppingCartPage extends BasePage {
    
    public ShoppingCartPage (WebDriver driver){
        super(driver);
    }

    By shoppingCartPageTitleBy = By.className("title");
    By productNameSauceLabsBackpackBy = By.xpath("//*[@id='item_4_title_link']/div");
    By productNameSauceLabsBikeLightkBy = By.xpath("//*[@id='item_0_title_link']/div");
    By buttonContinueShoppingBy = By.id("continue-shopping");
    By buttonCheckoutBy = By.id("checkout");
    By productButtonRemoveSauceLabsBackpackBy = By.id("remove-sauce-labs-backpack");

    public ShoppingCartPage verifyUserAtShoppingCartPage(String expectedText){
        String actualText = readText(shoppingCartPageTitleBy);
        assertTextEquals(expectedText, actualText);
        return this;
    }

    public ShoppingCartPage verifyFirstProductVisibleInCart(String expectedText){
        String actualText = readText(productNameSauceLabsBackpackBy);
        assertTextEquals(expectedText, actualText);
        return this;
    }
    public ShoppingCartPage verifySecondProductVisibleInCArt(String expectedText){
        String actualText = readText(productNameSauceLabsBikeLightkBy);
        assertTextEquals(expectedText, actualText);    
        return this;
    }

    public ShoppingCartPage buttonContinueShopping(){
        click(buttonContinueShoppingBy);
        return this;
    }

    public ShoppingCartPage buttonCheckout(){
        click(buttonCheckoutBy);
        return this;
    }

    public ShoppingCartPage removeProductSauceLabsBackpackFromCart(){
        click(productButtonRemoveSauceLabsBackpackBy);
        return this;
    }
}
