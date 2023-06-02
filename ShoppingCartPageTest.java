package Tests;

import org.junit.Test;

import Pages.CheckoutInformationPage;
import Pages.Header;
import Pages.LoginPage;
import Pages.ProductDetailsPage;
import Pages.ProductListPage;
import Pages.ShoppingCartPage;

public class ShoppingCartPageTest extends BaseTest{
    
    LoginPage loginPage;
    ShoppingCartPage shoppingCartPage;
    Header header;
    ProductListPage productListPage;
    ProductDetailsPage productDetailsPage;
    CheckoutInformationPage checkoutInformationPage;
    String username = "standard_user";
    String password = "secret_sauce";
    String shoppingCartPageTitle = "Your Cart";
    String homeTitle = "Products";
    String shoppingCartBadgeText = "1";
    String cartBadgeTextOfTwoAddedProducts = "2";
    String pdpTitle = "Back to products";
    String checkoutInformationPageTitle = "Checkout: Your Information";

@Test
public void validateNavigationFromShoppingCartToPLP(){
    LoginPage loginPage = new LoginPage(driver);
    Header header = new Header(driver);
    ShoppingCartPage shoppingCartPage = new ShoppingCartPage(driver);
    ProductListPage productListPage = new ProductListPage(driver);
    loginPage.basePage();
    loginPage.login(username, password);
    header.shoppingCartIcon();
    shoppingCartPage.verifyUserAtShoppingCartPage(shoppingCartPageTitle);
    shoppingCartPage.buttonContinueShopping();
    productListPage.verifyUserAtHomepage(homeTitle);
    
    try{
        Thread.sleep(2000);
    }catch(InterruptedException e){
        e.printStackTrace();
    }
}

@Test
public void validateProductRemoveButtonOnShoppingCartPage(){
    LoginPage loginPage = new LoginPage(driver);
    Header header = new Header(driver);
    ShoppingCartPage shoppingCartPage = new ShoppingCartPage(driver);
    ProductListPage productListPage = new ProductListPage(driver);
    loginPage.basePage();
    loginPage.login(username, password);
    productListPage.addProductSauceLabsBackpackToCart();
    productListPage.addProductSauceLabsBikeLightToCart();
    header.verifyProductAddedToCart(cartBadgeTextOfTwoAddedProducts);
    header.shoppingCartIcon();
    shoppingCartPage.verifyUserAtShoppingCartPage(shoppingCartPageTitle);
    shoppingCartPage.removeProductSauceLabsBackpackFromCart();
    header.verifyProductAddedToCart(shoppingCartBadgeText);

    try{
        Thread.sleep(2000);
    }catch(InterruptedException e){
        e.printStackTrace();
    }
}

@Test
public void validateNavigationFromShoppingCartToPDP(){
    LoginPage loginPage = new LoginPage(driver);
    Header header = new Header(driver);
    ShoppingCartPage shoppingCartPage = new ShoppingCartPage(driver);
    ProductListPage productListPage = new ProductListPage(driver);
    ProductDetailsPage productDetailsPage = new ProductDetailsPage(driver);
    loginPage.basePage();
    loginPage.login(username, password);
    productListPage.addProductSauceLabsBackpackToCart();
    header.shoppingCartIcon();
    shoppingCartPage.verifyUserAtShoppingCartPage(shoppingCartPageTitle);
    productListPage.productNameSauceLabsBackpack();
    productDetailsPage.verifyUserAtProductDetailsPage(pdpTitle);

    try{
        Thread.sleep(2000);
    }catch(InterruptedException e){
        e.printStackTrace();
    }
}

@Test
public void validateUserIsAbleToProceedToCheckoutInformationPage(){
    LoginPage loginPage = new LoginPage(driver);
    Header header = new Header(driver);
    ShoppingCartPage shoppingCartPage = new ShoppingCartPage(driver);
    CheckoutInformationPage checkoutInformationPage = new CheckoutInformationPage(driver);
    loginPage.basePage();
    loginPage.login(username, password);
    header.shoppingCartIcon();
    shoppingCartPage.buttonCheckout();
    checkoutInformationPage.verifyUserAtCheckoutInformationPage(checkoutInformationPageTitle);

    try{
        Thread.sleep(2000);
    }catch(InterruptedException e){
        e.printStackTrace();
    }
}

}
