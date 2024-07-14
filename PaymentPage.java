package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class PaymentPage {

    WebDriver driver;

    public PaymentPage(WebDriver driver) {
        this.driver = driver;
    }


    //Locators
    By creditCardOptionLocator = By.id("card_option");
    By cardNumberFieldLocator = By.id("cardNumber");
    By expiryMonthFieldLocator = By.id("expiryMonth");
    By expiryYearFieldLocator = By.id("expiryYear");
    By securityCodeFieldLocator = By.id("securityCode");
    By payNowBtnLocator = By.id("submitButton");
    By validationNoteLocator = By.id("cardNumber-hint");


    //methods

    //method to click on the credit card payment option
    public void clickOnCreditCartOption() {
        driver.findElement(creditCardOptionLocator).click();
    }

    //method to validate if the credit card payment option is selected
    public boolean isCreditCardSelected() {
        driver.findElement(creditCardOptionLocator).isSelected();
        return true;
    }

    //method to enter a credit card number
    public void enterCreditCardNumber(String creditCardNumber) {
        driver.findElement(cardNumberFieldLocator).sendKeys(creditCardNumber);
    }

    //method to enter the expiration month
    public void enterExpiryMonth(String expiryMonth) {
        driver.findElement(expiryMonthFieldLocator).sendKeys(expiryMonth);
    }

    //method to enter the expiration year
    public void enterExpiryYear(String expiryYear) {
        driver.findElement(expiryYearFieldLocator).sendKeys(expiryYear);
    }

    //method to enter the security code
    public void enterSecurityCode(String securityCode) {
        driver.findElement(securityCodeFieldLocator).sendKeys(securityCode);
    }

    //method to click on the "pay now" button
    public void clickOnPayNowBtn() {
        driver.findElement(payNowBtnLocator).click();
    }

    public String getValidationNoteCardNumber() {
        return driver.findElement(validationNoteLocator).getText();
    }

}
