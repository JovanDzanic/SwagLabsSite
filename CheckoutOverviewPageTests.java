package Tests;

import org.junit.Test;

import Pages.CheckoutCompletePage;
import Pages.CheckoutInformationPage;
import Pages.CheckoutOverviewPage;
import Pages.Header;
import Pages.LoginPage;
import Pages.ProductDetailsPage;
import Pages.ProductListPage;
import Pages.ShoppingCartPage;

public class CheckoutOverviewPageTests extends BaseTest{
    
    LoginPage loginPage;
    ProductListPage productListPage;
    Header header;
    ShoppingCartPage shoppingCartPage;
    CheckoutInformationPage checkoutInformationPage;
    CheckoutOverviewPage checkoutOverviewPage;
    ProductDetailsPage productDetailsPage;
    CheckoutCompletePage checkoutCompletePage;
    String username = "standard_user";
    String password = "secret_sauce";
    String firstName = "Petar";
    String lastName = "Peric";
    String zipCode = "37000";
    String checkoutOverviewPageTitle = "Checkout: Overview";
    String pdpTitle = "Back to products";
    String homeTitle = "Products";
    String checkoutCompletePageTitle = "Checkout: Complete!";

@Test
public void validateNavigationFromCheckoutOverviewToPDP(){
    LoginPage loginPage = new LoginPage(driver);
    ProductListPage productListPage = new ProductListPage(driver);
    Header header = new Header(driver);
    ShoppingCartPage shoppingCartPage = new ShoppingCartPage(driver);
    CheckoutInformationPage checkoutInformationPage = new CheckoutInformationPage(driver);
    CheckoutOverviewPage checkoutOverviewPage = new CheckoutOverviewPage(driver);
    ProductDetailsPage productDetailsPage = new ProductDetailsPage(driver);
    loginPage.basePage();
    loginPage.login(username, password);
    productListPage.addProductSauceLabsBackpackToCart();
    header.shoppingCartIcon();
    shoppingCartPage.buttonCheckout();
    checkoutInformationPage.continueButton(firstName, lastName, zipCode);
    checkoutOverviewPage.verifyUserAtCheckoutOverviewPage(checkoutOverviewPageTitle);
    productListPage.productNameSauceLabsBackpack();
    productDetailsPage.verifyUserAtProductDetailsPage(pdpTitle);

    try{
        Thread.sleep(2000);
    }catch(InterruptedException e){
        e.printStackTrace();
    }          
} 

@Test
public void validateNavigationFromCheckoutOverviewToPLP(){
    LoginPage loginPage = new LoginPage(driver);
    ProductListPage productListPage = new ProductListPage(driver);
    Header header = new Header(driver);
    ShoppingCartPage shoppingCartPage = new ShoppingCartPage(driver);
    CheckoutInformationPage checkoutInformationPage = new CheckoutInformationPage(driver);
    CheckoutOverviewPage checkoutOverviewPage = new CheckoutOverviewPage(driver);
    loginPage.basePage();
    loginPage.login(username, password);
    header.shoppingCartIcon();
    shoppingCartPage.buttonCheckout();
    checkoutInformationPage.continueButton(firstName, lastName, zipCode);
    checkoutOverviewPage.verifyUserAtCheckoutOverviewPage(checkoutOverviewPageTitle);
    checkoutOverviewPage.cancelButton();
    productListPage.verifyUserAtHomepage(homeTitle);

    try{
        Thread.sleep(2000);
    }catch(InterruptedException e){
        e.printStackTrace();
    }          
} 

@Test
public void verifyUserIsAbleToFinishTheOrder(){
    LoginPage loginPage = new LoginPage(driver);
    Header header = new Header(driver);
    ShoppingCartPage shoppingCartPage = new ShoppingCartPage(driver);
    CheckoutInformationPage checkoutInformationPage = new CheckoutInformationPage(driver);
    CheckoutOverviewPage checkoutOverviewPage = new CheckoutOverviewPage(driver);
    CheckoutCompletePage checkoutCompletePage = new CheckoutCompletePage(driver);
    loginPage.basePage();
    loginPage.login(username, password);
    header.shoppingCartIcon();
    shoppingCartPage.buttonCheckout();
    checkoutInformationPage.continueButton(firstName, lastName, zipCode);
    checkoutOverviewPage.finishButton();
    checkoutCompletePage.verifyUserAtCheckoutCompletePage(checkoutCompletePageTitle);


    try{
        Thread.sleep(2000);
    }catch(InterruptedException e){
        e.printStackTrace();
    }          
} 


@Test
public void checkTotalPriceShowedCorrectly(){
    LoginPage loginPage = new LoginPage(driver);
    Header header = new Header(driver);
    ShoppingCartPage shoppingCartPage = new ShoppingCartPage(driver);
    CheckoutInformationPage checkoutInformationPage = new CheckoutInformationPage(driver);
    CheckoutOverviewPage checkoutOverviewPage = new CheckoutOverviewPage(driver);
    ProductListPage productListPage = new ProductListPage(driver);
    loginPage.basePage();
    loginPage.login(username, password);
    productListPage.addProductSauceLabsBackpackToCart();
    productListPage.addProductSauceLabsBikeLightToCart();
    header.shoppingCartIcon();
    shoppingCartPage.buttonCheckout();
    checkoutInformationPage.continueButton(firstName, lastName, zipCode);
    checkoutOverviewPage.verifyTotalPriceWithTaxShowedCorrectly();

    try{
        Thread.sleep(2000);
    }catch(InterruptedException e){
        e.printStackTrace();
    } 
}

}
