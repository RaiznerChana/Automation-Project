package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;

import java.time.Instant;

public class ProductPage {

    WebDriver driver;
    Select select;

    public ProductPage(WebDriver driver) {
        this.driver = driver;
    }

    //locators
    By waistFieldLocator = By.cssSelector("[id*='dk_container_Fit-']");
    By regularFitLocator = By.xpath("//*[@id=\"dk_container_Fit-922590\"]/div/ul/li[2]");
    By colourFieldLocator = By.cssSelector("[id*='dk_container_Colour']");
    By charcoalGrayColourLocator = By.xpath("//*[@id=\"dk_container_Colour-922590\"]/div/ul/li[4]");
    By sizeFieldLocator = By.cssSelector("[id*='dk_container_Size']");
    By sixYearsSizeLocator = By.xpath("//*[@id=\"dk_container_Size-T55-747\"]/div/ul/li[5]/a");

    By addToBagBtnLocator = By.xpath("//*[@id=\"Style922590\"]/section/div[4]/div[6]/div[4]/div/a[1]");
    By shoppingBagHeaderLocator = By.xpath("//*[@id=\"platform_modernisation_header\"]/header/div[1]/nav/div[2]/div[4]/div[2]/div/div/div[2]/div/div/div[1]");
    By checkoutBtnLocator = By.xpath("//*[@id=\"platform_modernisation_header\"]/header/div[1]/nav/div[2]/div[5]/a");


    //methods

    //method to choose a specific product waist
    public void chooseWaist() throws InterruptedException {
        driver.findElement(waistFieldLocator).click();
        Thread.sleep(500);
        driver.findElement(regularFitLocator).click();
    }

    //method to get the current test in the waist field
    public String getCurrentWaist() {
        return driver.findElement(waistFieldLocator).getText();
    }

    //method to choose a specific product color
    public void chooseColour() throws InterruptedException {
        driver.findElement(colourFieldLocator).click();
        Thread.sleep(1000);
        driver.findElement(charcoalGrayColourLocator).click();
    }

    //method to get the current test in the colour field
    public String getCurrentColour() {
        return driver.findElement(colourFieldLocator).getText();
    }

    //method to choose a specific product size
    public void chooseSize() throws InterruptedException {
        driver.findElement(sizeFieldLocator).click();
        Thread.sleep(1500);
        driver.findElement(sixYearsSizeLocator).click();
        Thread.sleep(1000);
    }

    //method to get the current test in the size field
    public String getCurrentSize() {
        return driver.findElement(sizeFieldLocator).getText();
    }

    //method to click on "add to bag" button
    public void addToBag() {
        driver.findElement(addToBagBtnLocator).click();
    }

    //method to get the shopping bag header
    public String getShoppingBagHeader() {
        return driver.findElement(shoppingBagHeaderLocator).getText();
    }


    //method to click on "checkout" button
    public void clickOnCheckout() {
        driver.findElement(checkoutBtnLocator).click();
    }

}
