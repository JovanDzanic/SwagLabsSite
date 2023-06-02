package Tests;

import org.junit.Test;

import Pages.Header;
import Pages.LoginPage;
import Pages.ProductDetailsPage;
import Pages.ProductListPage;
import Pages.ShoppingCartPage;

public class ProductListPageTests extends BaseTest{
    
    LoginPage loginPage; 
    Header header; 
    ProductListPage productListPage; 
    ProductDetailsPage productDetailsPage;
    ShoppingCartPage shoppingCartPage;
    String username = "standard_user";
    String password = "secret_sauce";
    String pdpTitle = "Back to products";
    String homeTitle = "Products";
    String shoppingCartBadgeText = "1";
    String cartBadgeTextOfTwoAddedProducts = "2";
    int numberOfProducts = 6;
    String firstAddedToCartProductName = "Sauce Labs Backpack";
    String secondAddedToCartProductName = "Sauce Labs Bike Light";

@Test
public void verifyNumberOfProductsAtPLP(){
    LoginPage loginPage = new LoginPage(driver);
    ProductListPage productListPage = new ProductListPage(driver);
    loginPage.basePage();
    loginPage.login(username, password);
    productListPage.verifyNumberOfProdcuts(numberOfProducts);
    
    try{
        Thread.sleep(2000);
    }catch(InterruptedException e){
        e.printStackTrace();
    }
}

@Test
public void validateNavigationFromPLPtoPDPUsingProductName (){
    LoginPage loginPage = new LoginPage(driver);
    ProductListPage productListPage = new ProductListPage(driver);
    ProductDetailsPage productDetailsPage = new ProductDetailsPage(driver);
    loginPage.basePage();
    loginPage.login(username, password);
    productListPage.productNameSauceLabsBackpack();
    productDetailsPage.verifyUserAtProductDetailsPage(pdpTitle); 

    try{
        Thread.sleep(2000);
    }catch(InterruptedException e){
        e.printStackTrace();
    }
}

@Test
public void validateNavigationFromPLPtoPDPUsingProductPicture (){
    LoginPage loginPage = new LoginPage(driver);
    ProductListPage productListPage = new ProductListPage(driver);
    ProductDetailsPage productDetailsPage = new ProductDetailsPage(driver);
    loginPage.basePage();
    loginPage.login(username, password);
    productListPage.productPictureSauceLabsBackpack();
    productDetailsPage.verifyUserAtProductDetailsPage(pdpTitle);

    try{
        Thread.sleep(2000);
    }catch(InterruptedException e){
        e.printStackTrace();
    }
}

@Test
public void validateProductAddToCartButtonOnPLP(){
    LoginPage loginPage = new LoginPage(driver);
    ProductListPage productListPage = new ProductListPage(driver);
    Header header = new Header(driver);
    ShoppingCartPage shoppingCartPage = new ShoppingCartPage(driver);
    loginPage.basePage();
    loginPage.login(username, password);
    productListPage.addProductSauceLabsBackpackToCart();
    productListPage.addProductSauceLabsBikeLightToCart();
    header.verifyProductAddedToCart(cartBadgeTextOfTwoAddedProducts);
    header.shoppingCartIcon();
    shoppingCartPage.verifyFirstProductVisibleInCart(firstAddedToCartProductName);
    shoppingCartPage.verifySecondProductVisibleInCArt(secondAddedToCartProductName);

    try{
        Thread.sleep(2000);
    }catch(InterruptedException e){
        e.printStackTrace();
    }
}

@Test
public void validateProductRemoveButtonOnPLP(){
    LoginPage loginPage = new LoginPage(driver);
    ProductListPage productListPage = new ProductListPage(driver);
    Header header = new Header(driver);
    ShoppingCartPage shoppingCartPage = new ShoppingCartPage(driver);
    loginPage.basePage();
    loginPage.login(username, password);
    productListPage.addProductSauceLabsBackpackToCart();
    productListPage.addProductSauceLabsBikeLightToCart();
    header.verifyProductAddedToCart(cartBadgeTextOfTwoAddedProducts);
    header.shoppingCartIcon();
    shoppingCartPage.verifyFirstProductVisibleInCart(firstAddedToCartProductName);
    shoppingCartPage.verifySecondProductVisibleInCArt(secondAddedToCartProductName);
    header.openMenu();
    header.menuOptionAllItems();
    productListPage.removeProductSauceLabsBikeLightFromCart();
    header.verifyProductAddedToCart(shoppingCartBadgeText);
    header.shoppingCartIcon();
    shoppingCartPage.verifyFirstProductVisibleInCart(firstAddedToCartProductName);

    try{
        Thread.sleep(2000);
    }catch(InterruptedException e){
        e.printStackTrace();
    }
}

//Dropdown Menu

@Test
public void verifyDropdownMenuPriceLowToHigh(){
    LoginPage loginPage = new LoginPage(driver);
    ProductListPage productListPage = new ProductListPage(driver);
    loginPage.basePage();
    loginPage.login(username, password);
    productListPage.dropdownMenuLowToHigh();

    

    try{
        Thread.sleep(5000);
    }catch(InterruptedException e){
        e.printStackTrace();
    }

}

@Test
public void verifyDropdownMenuPriceHighToLow(){
    LoginPage loginPage = new LoginPage(driver);
    ProductListPage productListPage = new ProductListPage(driver);
    loginPage.basePage();
    loginPage.login(username, password);
    productListPage.dropdownMenuHighToLow();
    

    try{
        Thread.sleep(5000);
    }catch(InterruptedException e){
        e.printStackTrace();
    }

}

@Test
public void verifyDropdownMenuNameFromZtoA(){
    LoginPage loginPage = new LoginPage(driver);
    ProductListPage productListPage = new ProductListPage(driver);
    loginPage.basePage();
    loginPage.login(username, password);
    productListPage.dropdownMenuZtoA();


    try{
        Thread.sleep(5000);
    }catch(InterruptedException e){
        e.printStackTrace();
    }

}

@Test
public void verifyDropdownMenuNameFromAtoZ(){
    LoginPage loginPage = new LoginPage(driver);
    ProductListPage productListPage = new ProductListPage(driver);
    loginPage.basePage();
    loginPage.login(username, password);
    productListPage.dropdownMenuAtoZ();

    try{
        Thread.sleep(5000);
    }catch(InterruptedException e){
        e.printStackTrace();
    }

}

}
