package Tests;

import org.junit.Test;

import Pages.Header;
import Pages.LoginPage;
import Pages.ProductDetailsPage;
import Pages.ProductListPage;
import Pages.ShoppingCartPage;

public class ProductDetailsPageTests extends BaseTest{
    
    LoginPage loginPage;
    ProductListPage productListPage;
    ProductDetailsPage productDetailsPage;
    Header header;
    String username = "standard_user";
    String password = "secret_sauce";
    String homeTitle = "Products";
    String pdpTitle = "Back to products";
    String shoppingCartBadgeText = "1";
    String cartBadgeTextOfTwoAddedProducts = "2";
    String firstCartProductName = "Sauce Labs Backpack";
    String secondCartProductName = "Sauce Labs Bike Light";
 
@Test
public void validateNavigationFromPDPtoPLP(){
    LoginPage loginPage = new LoginPage(driver);
    ProductListPage productListPage = new ProductListPage(driver);
    ProductDetailsPage productDetailsPage = new ProductDetailsPage(driver);
    loginPage.basePage();
    loginPage.login(username, password);
    productListPage.productNameSauceLabsBackpack();
    productDetailsPage.buttonBackToProducts();
    productListPage.verifyUserAtHomepage(homeTitle);

    try{
        Thread.sleep(2000);
    }catch(InterruptedException e){
        e.printStackTrace();
    }
}

@Test
public void validateProductAddToCartButtonOnPDP(){
    LoginPage loginPage = new LoginPage(driver);
    ProductListPage productListPage = new ProductListPage(driver);
    ProductDetailsPage productDetailsPage = new ProductDetailsPage(driver);
    Header header = new Header(driver);
    ShoppingCartPage shoppingCartPage = new ShoppingCartPage(driver);
    loginPage.basePage();
    loginPage.login(username, password);
    productListPage.productNameSauceLabsBackpack();
    productDetailsPage.verifyUserAtProductDetailsPage(pdpTitle);
    productListPage.addProductSauceLabsBackpackToCart();
    header.verifyProductAddedToCart(shoppingCartBadgeText);
    header.shoppingCartIcon();
    shoppingCartPage.verifyFirstProductVisibleInCart(firstCartProductName);
    
    try{
        Thread.sleep(2000);
    }catch(InterruptedException e){
        e.printStackTrace();
    }
}

@Test
public void validateProductRemoveButtonOnPDP(){
    LoginPage loginPage = new LoginPage(driver);
    ProductListPage productListPage = new ProductListPage(driver);
    ProductDetailsPage productDetailsPage = new ProductDetailsPage(driver);
    Header header = new Header(driver);
    ShoppingCartPage shoppingCartPage = new ShoppingCartPage(driver);
    loginPage.basePage();
    loginPage.login(username, password);
    productListPage.addProductSauceLabsBackpackToCart();
    productListPage.addProductSauceLabsBikeLightToCart();
    header.verifyProductAddedToCart(cartBadgeTextOfTwoAddedProducts);
    header.shoppingCartIcon();
    shoppingCartPage.verifyFirstProductVisibleInCart(firstCartProductName);
    shoppingCartPage.verifySecondProductVisibleInCArt(secondCartProductName);
    productListPage.productNameSauceLabsBikeLight();
    productDetailsPage.verifyUserAtProductDetailsPage(pdpTitle);
    productListPage.removeProductSauceLabsBikeLightFromCart();
    header.verifyProductAddedToCart(shoppingCartBadgeText);
    header.shoppingCartIcon();
    shoppingCartPage.verifyFirstProductVisibleInCart(firstCartProductName);
    
    try{
        Thread.sleep(2000);
    }catch(InterruptedException e){
        e.printStackTrace();
    }

}

}
