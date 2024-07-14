package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class HomeShopPage {

    WebDriver driver;


    //constructors
    public HomeShopPage(WebDriver driver) {
        this.driver = driver;
    }


    //locators
    By accessoriesImgLinkLocator = By.cssSelector("img[title=accessories]");
    By lightingCategoryLinkLocator = By.xpath("//*[@id=\"multi-9-teaser1_item_6\"]/div/a/div[2]/h3");
    By kitchenRoomLinkLocator = By.linkText("Kitchen");


    //methods
//method to click on the accessories img
    public void clickOnAccessoriesImg() {
        driver.findElement(accessoriesImgLinkLocator).click();
    }

    //method to click on the lighting category
    public void clickOnLightingCategory() {
        driver.findElement(lightingCategoryLinkLocator).click();
    }

    //method to click on the kitchen room link
    public void clickOnKitchenRoomLink() {
        driver.findElement(kitchenRoomLinkLocator).click();
    }


}


