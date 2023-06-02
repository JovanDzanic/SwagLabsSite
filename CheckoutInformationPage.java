package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class CheckoutInformationPage extends BasePage {
    
    public CheckoutInformationPage(WebDriver driver){
        super(driver);
    }

    By checkoutInformationPageTitleBy = By.xpath("//*[@id='header_container']/div[2]/span");
    By firstNameFieldBy = By.id("first-name");
    By lastNameFieldBy = By.id("last-name");
    By zipCodeFieldBy = By.id("postal-code");
    By cancelButtonBy = By.id("cancel");
    By continueButtonBy = By.id("continue");
    By errorContainerBy = By.xpath("//*[@id='checkout_info_container']/div/form/div[1]/div[4]/h3");


    public CheckoutInformationPage verifyUserAtCheckoutInformationPage(String expectedText){
        String actualText = readText(checkoutInformationPageTitleBy);
        assertTextEquals(expectedText, actualText);
        return this;
    }

    public CheckoutInformationPage continueButton(String firstName, String lastName, String zipCode){
        writeText(firstNameFieldBy, firstName);
        writeText(lastNameFieldBy, lastName);
        writeText(zipCodeFieldBy, zipCode);
        click(continueButtonBy);
        return this;
    }

    public CheckoutInformationPage verifyUserIsUnableToProceed(String expectedText){
        String actualText = readText(errorContainerBy);
        assertTextEquals(expectedText, actualText);
        return this;
    }

    public CheckoutInformationPage cancelButton(){
        click(cancelButtonBy);
        return this;
    }

}
