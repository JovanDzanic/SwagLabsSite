package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class CheckoutCompletePage extends BasePage {
    
    public CheckoutCompletePage (WebDriver driver){
        super(driver);
    }

    By checkoutCompletePageTitleBy = By.xpath("//*[@id='header_container']/div[2]/span");
    By backHomeButtonBy = By.id("back-to-products");

    public CheckoutCompletePage verifyUserAtCheckoutCompletePage(String expectedText){
        String actualText = readText(checkoutCompletePageTitleBy);
        assertTextEquals(expectedText, actualText);
        return this;
    }

    public CheckoutCompletePage backHomeButton(){
        click(backHomeButtonBy);
        return this;
    }
    
}
