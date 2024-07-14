package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class HomePage {

    WebDriver driver;


    //constructor
    public HomePage(WebDriver driver) {
        this.driver = driver;
    }


    //locators

    By searchBoxLocator = By.id("header-big-screen-search-box");
    By searchIconLocator = By.xpath("//*[@id=\"header-search-form\"]/button/img");
    By homeLinkLocator = By.xpath("//*[@id=\"meganav-link-7\"]/div");
    By selectChosenShopBtnLocator = By.xpath("//*[@id=\"sec-nav-content\"]/div/div/div/section[2]/div/a/span");
    By babyLinkLocator = By.xpath("//*[@id=\"meganav-link-2\"]/div");
    By languageIconLocator = By.xpath("//*[@id=\"platform_modernisation_header\"]/header/div[1]/nav/div[2]/div[6]/button/img");
    By hebrewLanguageBtnLocator = By.xpath("//*[@id=\"header-country-selector-wrapper\"]/div/div[3]/div/div[4]/div/button[1]");
    By englishLanguageBtnLocator = By.xpath("//*[@id=\"header-country-selector-wrapper\"]/div/div[3]/div/div[4]/div/button[2]");
    By buyAfterChangeLanguageBtnLocator = By.xpath("//*[@id=\"header-country-selector-wrapper\"]/div/div[3]/div/div[5]/button");


    //methods


    //method to navigate to "home shop" page
    public void clickOnHomePage() throws InterruptedException {
        driver.findElement(homeLinkLocator).click();
        Thread.sleep(1500);
        driver.findElement(selectChosenShopBtnLocator).click();
        Thread.sleep(1500);
    }

    //method to navigate to "baby shop" page
    public void clickOnBabyPage() throws InterruptedException {
        driver.findElement(babyLinkLocator).click();
        Thread.sleep(1500);
        driver.findElement(selectChosenShopBtnLocator).click();
        Thread.sleep(1500);
    }

    //method to choose the hebrew language
    public void chooseHebrewLanguage() throws InterruptedException {
        driver.findElement(languageIconLocator).click();
        Thread.sleep(1500);
        driver.findElement(hebrewLanguageBtnLocator).click();
        Thread.sleep(1500);
        driver.findElement(buyAfterChangeLanguageBtnLocator).click();
        Thread.sleep(1500);
    }

    //method to choose the english language
    public void chooseEnglishLanguage() throws InterruptedException {
        driver.findElement(languageIconLocator).click();
        Thread.sleep(1500);
        driver.findElement(englishLanguageBtnLocator).click();
        Thread.sleep(1500);
        driver.findElement(buyAfterChangeLanguageBtnLocator).click();
        Thread.sleep(1500);
    }

    //method to type a product name in the search-box and clicking on the search icon to apply the searching
    public void searchProduct() throws InterruptedException {
        driver.findElement(searchBoxLocator).sendKeys(Constants.PRODUCT_NAME);
        Thread.sleep(1500);
        driver.findElement(searchIconLocator).click();
        Thread.sleep(1500);
    }


}
