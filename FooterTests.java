package Tests;

import org.junit.Test;

import Pages.Footer;
import Pages.LoginPage;

public class FooterTests extends BaseTest {
    
    public LoginPage loginPage;
    public Footer footer;
    String username = "standard_user";
    String password = "secret_sauce";
    String sauceLabsTwitterAccount = "https://twitter.com/saucelabs";
    String sauceLabsFacebookAccount = "https://www.facebook.com/saucelabs";
    String sauceLabsLinkedinAccount = "https://www.linkedin.com/company/sauce-labs/";

@Test
public void twitterLink(){
    LoginPage loginPage = new LoginPage(driver);
    Footer footer = new Footer(driver);
    loginPage.basePage();
    loginPage.login(username, password);
    footer.verifyTwitterLogoIconLink(sauceLabsTwitterAccount);

    try{
        Thread.sleep(2000);
    }catch(InterruptedException e){
        e.printStackTrace();
    }
}

@Test
public void facebookLink(){
    LoginPage loginPage = new LoginPage(driver);
    Footer footer = new Footer(driver);
    loginPage.basePage();
    loginPage.login(username, password);
    footer.verifyFacebookLogoIconLink(sauceLabsFacebookAccount);

    try{
        Thread.sleep(2000);
    }catch(InterruptedException e){
        e.printStackTrace();
    }
}

@Test
public void linkedinLink(){
    LoginPage loginPage = new LoginPage(driver);
    Footer footer = new Footer(driver);
    loginPage.basePage();
    loginPage.login(username, password);
    footer.verifyLinkedinLogoIconLink(sauceLabsLinkedinAccount);

    try{
        Thread.sleep(2000);
    }catch(InterruptedException e){
        e.printStackTrace();
    }
}
}
