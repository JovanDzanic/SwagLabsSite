package Tests;

import org.junit.Test;

import Pages.LoginPage;
import Pages.ProductListPage;

public class LoginPageTests extends BaseTest{
    
    public LoginPage loginPage;
    public ProductListPage productListPage;
    String username = "standard_user";
    String password = "secret_sauce";
    String emptyUsername ="";
    String emptyUsernameError = "Epic sadface: Username is required";
    String emptyPassword = "";
    String emptyPasswordError = "Epic sadface: Password is required";
    String invalidUsername = "username";
    String invalidCredentialsError = "Epic sadface: Username and password do not match any user in this service";
    String invalidPassword = "password";
    String suspendedUsername = "locked_out_user";
    String suspendedUserError = "Epic sadface: Sorry, this user has been locked out.";
    String homeTitle = "Products";


@Test
public void verifyUnsuccessfulEmptyUsernameField(){
    LoginPage loginPage = new LoginPage(driver);
    loginPage.basePage();
    loginPage.login(emptyUsername, password);
    loginPage.verifyUnsuccessfulLogin(emptyUsernameError);

    try{
        Thread.sleep(2000);
    }catch(InterruptedException e){
        e.printStackTrace();
    }
}

@Test
public void verifyUnsuccessfulEmptyPasswordField(){
    LoginPage loginPage = new LoginPage(driver);
    loginPage.basePage();
    loginPage.login(username, emptyPassword);
    loginPage.verifyUnsuccessfulLogin(emptyPasswordError);

    try{
        Thread.sleep(2000);
    }catch(InterruptedException e){
        e.printStackTrace();
    }
}

@Test
public void verifyUnsuccessfulInvalidUsernameField(){
    LoginPage loginPage = new LoginPage(driver);
    loginPage.basePage();
    loginPage.login(invalidUsername, password);
    loginPage.verifyUnsuccessfulLogin(invalidCredentialsError);

    try{
        Thread.sleep(2000);
    }catch(InterruptedException e){
        e.printStackTrace();
    }
}

@Test
public void verifyUnsuccessfulInvalidpasswordField(){
    LoginPage loginPage = new LoginPage(driver);
    loginPage.basePage();
    loginPage.login(username, invalidPassword);
    loginPage.verifyUnsuccessfulLogin(invalidCredentialsError);

    try{
        Thread.sleep(2000);
    }catch(InterruptedException e){
        e.printStackTrace();
    }
}

@Test
public void verifySuspendedUserLogin(){
    LoginPage loginPage = new LoginPage(driver);
    loginPage.basePage();
    loginPage.login(suspendedUsername, password);
    loginPage.verifyUnsuccessfulLogin(suspendedUserError);

    try{
        Thread.sleep(2000);
    }catch(InterruptedException e){
        e.printStackTrace();
    }
}

@Test
public void verifySuccessfulLogin(){
    LoginPage loginPage = new LoginPage(driver);
    ProductListPage productListPage = new ProductListPage(driver);
    loginPage.basePage();
    loginPage.login(username, password);
    productListPage.verifyUserAtHomepage(homeTitle);

    try{
        Thread.sleep(2000);
    }catch(InterruptedException e){
        e.printStackTrace();
    }
}

}
