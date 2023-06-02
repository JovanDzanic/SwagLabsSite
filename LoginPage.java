package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage extends BasePage {
    
    public LoginPage (WebDriver driver){
        super(driver);
    }

    String baseURL = "https://www.saucedemo.com/";
    By usernameBy = By.id("user-name");
    By passwordBy = By.id("password");
    By loginButtonBy = By.id("login-button");
    By errorContainerBy = By.xpath("//*[@id='login_button_container']/div/form/div[3]/h3");
    By loginPageTitleBy = By.className("login_logo");

    public LoginPage basePage(){
        driver.get(baseURL);;
        return this;
    }

    public LoginPage login(String username, String password){
        writeText(usernameBy, username);
        writeText(passwordBy, password);
        click(loginButtonBy);
        return this;
    }

    public LoginPage verifyUnsuccessfulLogin(String expectedText){
        String actualText = readText(errorContainerBy);
        assertTextEquals(expectedText, actualText);
        return this;

    }

    public LoginPage verifyUserIsOnLoginPage(String expectedText){
        String actualText = readText(loginPageTitleBy);
        assertTextEquals(expectedText, actualText);
        return this;
    }


}
