package Tests;

import org.junit.Test;

import Pages.CheckoutInformationPage;
import Pages.CheckoutOverviewPage;
import Pages.Header;
import Pages.LoginPage;
import Pages.ShoppingCartPage;

public class CheckoutInformationPageTests extends BaseTest {
    
    LoginPage loginPage;
    Header header;
    ShoppingCartPage shoppingCartPage;
    CheckoutInformationPage checkoutInformationPage;
    CheckoutOverviewPage checkoutOverviewPage;
    String username = "standard_user";
    String password = "secret_sauce";
    String firstName = "Petar";
    String lastName = "Peric";
    String zipCode = "37000";
    String emptyFirstName = "";
    String emptyLastName = "";
    String emptyZipCode = "";
    String errorEmptyFirstName = "Error: First Name is required";
    String errorEmptyLastName = "Error: Last Name is required";
    String errorEmptyZipCode = "Error: Postal Code is required";
    String checkoutOverviewPageTitle = "Checkout: Overview";
    String shoppingCartPageTitle = "Your Cart";
    

@Test
public void verifyUnsuccessfulEmptyFirstName(){
    LoginPage loginPage = new LoginPage(driver);
    Header header = new Header(driver);
    ShoppingCartPage shoppingCartPage = new ShoppingCartPage(driver);
    CheckoutInformationPage checkoutInformationPage = new CheckoutInformationPage(driver);
    loginPage.basePage();
    loginPage.login(username, password);
    header.shoppingCartIcon();
    shoppingCartPage.buttonCheckout();
    checkoutInformationPage.continueButton(emptyFirstName, lastName, zipCode);
    checkoutInformationPage.verifyUserIsUnableToProceed(errorEmptyFirstName);

    try{
        Thread.sleep(2000);
    }catch(InterruptedException e){
        e.printStackTrace();
    }
}

@Test
public void verifyUnsuccessfulEmptyLastName(){
    LoginPage loginPage = new LoginPage(driver);
    Header header = new Header(driver);
    ShoppingCartPage shoppingCartPage = new ShoppingCartPage(driver);
    CheckoutInformationPage checkoutInformationPage = new CheckoutInformationPage(driver);
    loginPage.basePage();
    loginPage.login(username, password);
    header.shoppingCartIcon();
    shoppingCartPage.buttonCheckout();
    checkoutInformationPage.continueButton(firstName, emptyLastName, zipCode);
    checkoutInformationPage.verifyUserIsUnableToProceed(errorEmptyLastName);  
    
    try{
        Thread.sleep(2000);
    }catch(InterruptedException e){
        e.printStackTrace();
    }
}

@Test
public void verifyUnsuccessfulEmptyZipCode(){
    LoginPage loginPage = new LoginPage(driver);
    Header header = new Header(driver);
    ShoppingCartPage shoppingCartPage = new ShoppingCartPage(driver);
    CheckoutInformationPage checkoutInformationPage = new CheckoutInformationPage(driver);
    loginPage.basePage();
    loginPage.login(username, password);
    header.shoppingCartIcon();
    shoppingCartPage.buttonCheckout();
    checkoutInformationPage.continueButton(firstName, lastName, emptyZipCode);
    checkoutInformationPage.verifyUserIsUnableToProceed(errorEmptyZipCode);  
    
    try{
        Thread.sleep(2000);
    }catch(InterruptedException e){
        e.printStackTrace();
    }
}

@Test
public void verifyUserIsAbleToProceedToCheckoutOverview(){
    LoginPage loginPage = new LoginPage(driver);
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
    
    try{
        Thread.sleep(2000);
    }catch(InterruptedException e){
        e.printStackTrace();
    }
}

@Test
public void validateUserIsAbleToCancelCheckoutAndReturnToShoppingCartPage(){
    LoginPage loginPage = new LoginPage(driver);
    Header header = new Header(driver);
    ShoppingCartPage shoppingCartPage = new ShoppingCartPage(driver);
    CheckoutInformationPage checkoutInformationPage = new CheckoutInformationPage(driver);  
    loginPage.basePage();
    loginPage.login(username, password);
    header.shoppingCartIcon();
    shoppingCartPage.buttonCheckout();
    checkoutInformationPage.cancelButton();
    shoppingCartPage.verifyUserAtShoppingCartPage(shoppingCartPageTitle);

    try{
        Thread.sleep(2000);
    }catch(InterruptedException e){
        e.printStackTrace();
    }
}

}