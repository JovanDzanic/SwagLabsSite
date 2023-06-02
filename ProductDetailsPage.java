package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ProductDetailsPage extends BasePage{
    
    public ProductDetailsPage (WebDriver driver){
        super(driver);
    }

    By backToProductsButtonBy = By.id("back-to-products");
    
    public ProductDetailsPage verifyUserAtProductDetailsPage (String expectedText){
        String actualText = readText(backToProductsButtonBy);
        assertTextEquals(expectedText, actualText);
        return this;
    }

    public ProductDetailsPage buttonBackToProducts (){
        click(backToProductsButtonBy);
        return this;
    }

   


}
