package Pages;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class CheckoutOverviewPage extends BasePage{
    
    public CheckoutOverviewPage(WebDriver driver){
        super(driver);
    }

    By checkoutOverviewPageTitleBy = By.xpath("//*[@id='header_container']/div[2]/span");
    By cancelButtonBy = By.id("cancel");
    By finishButtonBy = By.id("finish");
    By firstProductPriceBy = By.xpath("//*[@id='checkout_summary_container']/div/div[1]/div[3]/div[2]/div[2]/div");
    By secondProductPriceBy = By.xpath("//*[@id='checkout_summary_container']/div/div[1]/div[4]/div[2]/div[2]/div");
    By itemTotalPriceBy = By.className("summary_subtotal_label");
    By taxPriceBy = By.className("summary_tax_label");
    By totalPriceBy = By.xpath("//*[@id='checkout_summary_container']/div/div[2]/div[8]");

    public CheckoutOverviewPage verifyUserAtCheckoutOverviewPage(String expectedText){
        String actualText = readText(checkoutOverviewPageTitleBy);
        assertTextEquals(expectedText, actualText);
        return this;
    }

    public CheckoutOverviewPage cancelButton(){
        click(cancelButtonBy);
        return this;
    }

    public CheckoutOverviewPage finishButton(){
        click(finishButtonBy);
        return this;
    }

    public CheckoutOverviewPage verifyTotalPriceWithTaxShowedCorrectly(){
        double firstItemPrice = Double.parseDouble(readText(firstProductPriceBy).substring(1));
        double secondItemPrice = Double.parseDouble(readText(secondProductPriceBy).substring(1));
        double itemTotalPrice = firstItemPrice + secondItemPrice;

        Assert.assertEquals(itemTotalPrice, Double.parseDouble(readText(itemTotalPriceBy).substring(13)), 0.00001);

        double taxPrice = Double.parseDouble(readText(taxPriceBy).substring(6));
        double totalPrice = itemTotalPrice + taxPrice;

        Assert.assertEquals(totalPrice, Double.parseDouble(readText(totalPriceBy).substring(8)), 0.00001);
        return this; 
    }

}
