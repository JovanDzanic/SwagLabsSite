package Pages;

import java.time.Duration;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class BasePage {
    
    WebDriver driver;
    WebDriverWait wait;

    public BasePage (WebDriver driver){
        this.driver = driver;
        wait = new WebDriverWait(driver, Duration.ofSeconds(20));

    }

    public void waitVisibility(By elementBy){
        wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(elementBy));
    }

    public void writeText(By elemenBy, String text){
        waitVisibility(elemenBy);
        driver.findElement(elemenBy).clear();
        driver.findElement(elemenBy).sendKeys(text);
    }

    public void click(By elementBy){
        waitVisibility(elementBy);
        driver.findElement(elementBy).click();
    }

    public String readText(By elementBy){
        waitVisibility(elementBy);
        return driver.findElement(elementBy).getText();
    }

    public void assertTextEquals(String expectedText, String actualText){
        Assert.assertEquals(expectedText, actualText);
    }

    public int countProducts(By elementBy){
        waitVisibility(elementBy);
        return driver.findElements(elementBy).size();
    }

    public void assertNumberEquals(int expectedNumber, int actualNumber){
        Assert.assertEquals(expectedNumber, actualNumber);
    }

    public String readLink(By elementBy){
        waitVisibility(elementBy);
        return driver.findElement(elementBy).getAttribute("href");
    }

    public void select(By elementBy , String text){
        Select dropdown = new Select(driver.findElement(elementBy));
        dropdown.selectByVisibleText(text);
    }
 
}
