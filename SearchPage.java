package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class SearchPage {

    WebDriver driver;


    //constructor
    public SearchPage(WebDriver driver) {
        this.driver = driver;
    }

    //locators
    By chooseBlueChinoTrousersLocator = By.xpath("//*[@id=\"platform_modernisation_product_summary_M28255\"]/div/div[1]/div[1]/div/div/div[1]/a/img");
//


    //methods

    //method to choose a specific product after searching
    public void chooseSpecificProduct() {
        driver.findElement(chooseBlueChinoTrousersLocator).click();
    }

}
