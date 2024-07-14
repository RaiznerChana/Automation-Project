package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class SigninToNextPage {

    WebDriver driver;

    //constructor
    public SigninToNextPage(WebDriver driver) {
        this.driver = driver;
    }


    //locators
    By emailAddressFldLocator = By.id("EmailOrAccountNumber");
    By PasswordFldLocator = By.id("Password");
    By signInBtnLocator = By.id("SignInNow");
    By myAccountLinkLocator = By.xpath("//*[@id=\"platform_modernisation_header\"]/header/div[1]/nav/div[2]/div[2]/div[2]/div/a/img");


    //method

    //method to click on "my account" link
    public void clickOnMyAccountLink() {
        driver.findElement(myAccountLinkLocator).click();
    }

    //method to enter the email address into the email address  field
    public void enterEmailAddress(String emailAddress) {
        driver.findElement(emailAddressFldLocator).sendKeys(emailAddress);
    }

    //method to enter the password into the password field
    public void enterPassword(String password) {
        driver.findElement(PasswordFldLocator).sendKeys(password);
    }

    //method to click on the sign in button
    public void clickOnSignInBtn() {
        driver.findElement(signInBtnLocator).click();
    }



}
