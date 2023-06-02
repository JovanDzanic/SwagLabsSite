package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class Footer extends BasePage{
    
    public Footer (WebDriver driver){
        super(driver);
    }

    By twitterLinkBy = By.xpath("//*[@id='page_wrapper']/footer/ul/li[1]/a");
    By facebookLinkBy = By.xpath("//*[@id='page_wrapper']/footer/ul/li[2]/a");
    By linkedinLinkBy = By.xpath("//*[@id='page_wrapper']/footer/ul/li[3]/a");

    public Footer verifyTwitterLogoIconLink(String expectedText){
        String actualText = readLink(twitterLinkBy);
        assertTextEquals(expectedText, actualText);
        return this;
    }

    public Footer verifyFacebookLogoIconLink(String expectedText){
        String actualText = readLink(facebookLinkBy);
        assertTextEquals(expectedText, actualText);
        return this;
    }

    public Footer verifyLinkedinLogoIconLink(String expectedText){
        String actualText = readLink(linkedinLinkBy);
        assertTextEquals(expectedText, actualText);
        return this;
    }

    
    
}

  

