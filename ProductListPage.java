package Pages;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class ProductListPage extends BasePage{
    
    public ProductListPage (WebDriver driver){
        super(driver);
    }

    By productListPageTitleBy = By.className("title");
    By numberOfProductsBy = By.className("inventory_item_description");
    By productNameSauceLabsBackpackBy = By.xpath("//*[@id='item_4_title_link']/div");
    By productNameSauceLabsBikeLightkBy = By.xpath("//*[@id='item_0_title_link']/div"); 
    By productPictureSauceLabsBackpackBy = By.xpath("//*[@id='item_4_img_link']/img");
    By productButtonAddToCartSauceLabsBackpackBy = By.id("add-to-cart-sauce-labs-backpack");
    By productButtonRemoveSauceLabsBackpackBy = By.id("remove-sauce-labs-backpack");
    By productButtonAddToCartSauceLabsBikeLightBy = By.id("add-to-cart-sauce-labs-bike-light");
    By productButtonRemoveSauceLabsBikeLightBy = By.id("remove-sauce-labs-bike-light");
    //Dropdown Menu
    By sortButtonBy = By.className("product_sort_container");
    By itemNameBy = By.className("inventory_item_name");
    By priceOfItemsBy = By.className("inventory_item_price");


    public ProductListPage verifyUserAtHomepage(String expectedText){
        String actualText = readText(productListPageTitleBy);
        assertTextEquals(expectedText, actualText);
        return this;
    }

    public ProductListPage verifyNumberOfProdcuts(int expectedNumber){
        int actualNumber = countProducts(numberOfProductsBy);
        assertNumberEquals(expectedNumber, actualNumber);
        return this;
    }

    public ProductListPage productNameSauceLabsBackpack(){
        click(productNameSauceLabsBackpackBy);
        return this;
    }

    public ProductListPage productNameSauceLabsBikeLight(){
        click(productNameSauceLabsBikeLightkBy);
        return this;
    }

    public ProductListPage productPictureSauceLabsBackpack (){
        click(productPictureSauceLabsBackpackBy);
        return this;
    }

    public ProductListPage addProductSauceLabsBackpackToCart (){
        click(productButtonAddToCartSauceLabsBackpackBy);
        waitVisibility(productButtonRemoveSauceLabsBackpackBy);
        return this;
    }

    public ProductListPage addProductSauceLabsBikeLightToCart(){
        click(productButtonAddToCartSauceLabsBikeLightBy);
        waitVisibility(productButtonRemoveSauceLabsBikeLightBy);
        return this;
    }

    public ProductListPage removeProductSauceLabsBikeLightFromCart(){
        click(productButtonRemoveSauceLabsBikeLightBy);
        waitVisibility(productButtonAddToCartSauceLabsBikeLightBy);
        return this;
    }

    public ProductListPage removeProductSauceLabsBackpackFromCart(){
        click(productButtonRemoveSauceLabsBackpackBy);
        waitVisibility(productButtonAddToCartSauceLabsBackpackBy);
        return this;
    }

    public ProductListPage dropdownMenuLowToHigh (){
        List<WebElement> beforeFilterPrice = driver.findElements(priceOfItemsBy);
        List<Double> beforeFilterPriceList = new ArrayList<>();
        
        for(WebElement we : beforeFilterPrice){
            beforeFilterPriceList.add(Double.parseDouble(we.getText().substring(1)));
        }

        select(sortButtonBy, "Price (low to high)");

        List<WebElement> afterFilterPrice = driver.findElements(priceOfItemsBy);
        List<Double> afterFilterPriceList = new ArrayList<>();
        for(WebElement we : afterFilterPrice){
            afterFilterPriceList.add(Double.parseDouble(we.getText().substring(1)));
        }

        Collections.sort(beforeFilterPriceList);

        Assert.assertEquals(beforeFilterPriceList, afterFilterPriceList);
        return this;
    }

    public ProductListPage dropdownMenuHighToLow (){
        List<WebElement> beforeFilterPrice = driver.findElements(priceOfItemsBy);
        List<Double> beforeFilterPriceList = new ArrayList<>();
        
        for(WebElement we : beforeFilterPrice){
            beforeFilterPriceList.add(Double.parseDouble(we.getText().substring(1)));
        }

        select(sortButtonBy, "Price (high to low)");

        List<WebElement> afterFilterPrice = driver.findElements(priceOfItemsBy);
        List<Double> afterFilterPriceList = new ArrayList<>();
        for(WebElement we : afterFilterPrice){
            afterFilterPriceList.add(Double.parseDouble(we.getText().substring(1)));
        }

        Collections.sort(beforeFilterPriceList, Collections.reverseOrder());

        Assert.assertEquals(beforeFilterPriceList, afterFilterPriceList);
        return this;
    }

    public ProductListPage dropdownMenuZtoA(){
        List<WebElement> beforeFilterText = driver.findElements(itemNameBy);
        List<String> beforeFilterTextList = new ArrayList<>();

        for(WebElement we : beforeFilterText){
            beforeFilterTextList.add(we.getText());
        }

        select(sortButtonBy, "Name (Z to A)");

        List<WebElement> afterFilterText = driver.findElements(itemNameBy);
        List<String> afterFilterTextList = new ArrayList<>();

        for(WebElement we : afterFilterText){
            afterFilterTextList.add(we.getText());
        }

        Collections.sort(beforeFilterTextList, Collections.reverseOrder());

        Assert.assertEquals(beforeFilterTextList, afterFilterTextList);
        return this;
    }

    public ProductListPage dropdownMenuAtoZ(){
        select(sortButtonBy, "Price (low to high)");
        List<WebElement> beforeFilterText = driver.findElements(itemNameBy);
        List<String> beforeFilterTextList = new ArrayList<>();

        for(WebElement we : beforeFilterText){
            beforeFilterTextList.add(we.getText());
        }

        select(sortButtonBy, "Name (A to Z)");

        List<WebElement> afterFilterText = driver.findElements(itemNameBy);
        List<String> afterFilterTextList = new ArrayList<>();

        for(WebElement we : afterFilterText){
            afterFilterTextList.add(we.getText());
        }

        Collections.sort(beforeFilterTextList);

        Assert.assertEquals(beforeFilterTextList, afterFilterTextList);
        return this;
    }    
    
}

