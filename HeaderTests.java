package Tests;

import org.junit.Test;

import Pages.Header;
import Pages.LoginPage;
import Pages.ProductListPage;
import Pages.ShoppingCartPage;

public class HeaderTests extends BaseTest{
    
    public LoginPage loginPage;
    public Header header;
    public ShoppingCartPage shoppingCartPage;
    public ProductListPage productListPage;
    String username = "standard_user";
    String password = "secret_sauce";
    String shoppingCartPageTitle = "Your Cart";  
    String homeTitle = "Products";  
    String expectedURL = "https://saucelabs.com/";
    String loginPageTitle = "Swag Labs";



@Test
public void menuNavigationTest(){
    LoginPage loginPage = new LoginPage(driver);
    Header header = new Header(driver);
    loginPage.basePage();
    loginPage.login(username, password);
    header.openMenu();
    header.closeMenu();  
    
    try{
        Thread.sleep(2000);
    }catch(InterruptedException e){
        e.printStackTrace();
    }
}

@Test
public void shoppingCartNavigation(){
    LoginPage loginPage = new LoginPage(driver);
    Header header = new Header(driver);
    ShoppingCartPage shoppingCartPage = new ShoppingCartPage(driver);
    loginPage.basePage();
    loginPage.login(username, password);
    header.shoppingCartIcon();
    shoppingCartPage.verifyUserAtShoppingCartPage(shoppingCartPageTitle);

    try{
        Thread.sleep(2000);
    }catch(InterruptedException e){
        e.printStackTrace();
    }
}

@Test
public void menuFirstOptionAllItems(){
    LoginPage loginPage = new LoginPage(driver);
    Header header = new Header(driver);
    ShoppingCartPage shoppingCartPage = new ShoppingCartPage(driver);
    ProductListPage productListPage = new ProductListPage(driver);
    loginPage.basePage();
    loginPage.login(username, password);
    header.shoppingCartIcon();
    shoppingCartPage.verifyUserAtShoppingCartPage(shoppingCartPageTitle);
    header.openMenu();
    header.menuOptionAllItems();
    productListPage.verifyUserAtHomepage(homeTitle);

    try{
        Thread.sleep(2000);
    }catch(InterruptedException e){
        e.printStackTrace();
    }
}


@Test
public void menuSecondOptionAbout(){
    LoginPage loginPage = new LoginPage(driver);
    Header header = new Header(driver);
    loginPage.basePage();
    loginPage.login(username, password);
    header.openMenu();
    header.menuOptionAbout();
    header.sauceLabsSite(expectedURL);

    try{
        Thread.sleep(2000);
    }catch(InterruptedException e){
        e.printStackTrace();
    }
}

@Test
public void menuThirdOptionLogout(){
    LoginPage loginPage = new LoginPage(driver);
    Header header = new Header(driver);
    loginPage.basePage();
    loginPage.login(username, password);
    header.openMenu();
    header.menuOptionLogout();
    loginPage.verifyUserIsOnLoginPage(loginPageTitle);

    try{
        Thread.sleep(2000);
    }catch(InterruptedException e){
        e.printStackTrace();
    }
}

@Test    //(Test pada zbog bug-a na sajtu)
public void menuFourthOptionResetAppState(){
    LoginPage loginPage = new LoginPage(driver);
    Header header = new Header(driver);
    ProductListPage productListPage = new ProductListPage(driver);
    loginPage.basePage();
    loginPage.login(username, password);
    productListPage.addProductSauceLabsBackpackToCart();
    header.openMenu();
    header.menuOptionResetAppState();

    try{
        Thread.sleep(2000);
    }catch(InterruptedException e){
        e.printStackTrace();
    }
}

}
