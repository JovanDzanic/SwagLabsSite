package Tests;

import org.junit.Test;

import Pages.CheckoutCompletePage;
import Pages.CheckoutInformationPage;
import Pages.CheckoutOverviewPage;
import Pages.Header;
import Pages.LoginPage;
import Pages.ProductListPage;
import Pages.ShoppingCartPage;

public class CheckoutCompletePageTests extends BaseTest{
    
    LoginPage loginPage;
    Header header;
    ShoppingCartPage shoppingCartPage;
    CheckoutInformationPage checkoutInformationPage;
    CheckoutOverviewPage checkoutOverviewPage;
    CheckoutCompletePage checkoutCompletePage;
    ProductListPage productListPage;
    String username = "standard_user";
    String password = "secret_sauce";
    String firstName = "Petar";
    String lastName = "Peric";
    String zipCode = "37000";
    String checkoutCompletePageTitle = "Checkout: Complete!";
    String homeTitle = "Products";

@Test
public void validateNavigationFromCheckoutCompleteToPLP(){
    LoginPage loginPage = new LoginPage(driver);
    Header header = new Header(driver);
    ShoppingCartPage shoppingCartPage = new ShoppingCartPage(driver);
    CheckoutInformationPage checkoutInformationPage = new CheckoutInformationPage(driver);
    CheckoutOverviewPage checkoutOverviewPage = new CheckoutOverviewPage(driver);
    CheckoutCompletePage checkoutCompletePage = new CheckoutCompletePage(driver);
    ProductListPage productListPage = new ProductListPage(driver);
    loginPage.basePage();
    loginPage.login(username, password);
    header.shoppingCartIcon();
    shoppingCartPage.buttonCheckout();
    checkoutInformationPage.continueButton(firstName, lastName, zipCode);
    checkoutOverviewPage.finishButton();
    checkoutCompletePage.verifyUserAtCheckoutCompletePage(checkoutCompletePageTitle);
    checkoutCompletePage.backHomeButton();
    productListPage.verifyUserAtHomepage(homeTitle);


    try{
        Thread.sleep(2000);
    }catch(InterruptedException e){
        e.printStackTrace();
    }         
}   


}
