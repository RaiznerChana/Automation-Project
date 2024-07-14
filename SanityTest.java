package testCases;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;
import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.xml.sax.SAXException;
import pages.*;
import utilities.Utilities;

import javax.xml.parsers.ParserConfigurationException;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

import static utilities.Utilities.getData;


public class SanityTest {

    private static WebDriver driver;
    Actions actions = new Actions(driver);
    String currentTime = String.valueOf(System.currentTimeMillis());

    //object for extent reports
    static ExtentSparkReporter extentSparkReporter = new ExtentSparkReporter("spark.html");
    static ExtentReports extentReports = new ExtentReports();


    //objects to allow access to all pages and their methods
    Utilities utilities = new Utilities(driver);
    HomePage homePage = new HomePage(driver);
    SigninToNextPage signinToNextPage = new SigninToNextPage(driver);
    HomeShopPage homeShopPage = new HomeShopPage((driver));
    SearchPage searchPage = new SearchPage(driver);
    ProductPage productPage = new ProductPage(driver);
    PaymentPage paymentPage = new PaymentPage(driver);


    @BeforeClass
    public static void beforeClass() throws ParserConfigurationException, IOException, SAXException {
        System.out.println("**********beforeClass**********");
        ChromeOptions options = new ChromeOptions();
        options.addArguments("-incognito");
        driver = new ChromeDriver(options);
        driver.manage().window().maximize();
        driver.get(getData("URL"));
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        extentReports.attachReporter(extentSparkReporter);
        extentSparkReporter.config().setTheme(Theme.DARK);
        extentSparkReporter.config().setReportName("report- sanity on NEXT");

    }


    //in this test we  sign in to a user account.
    @Test
    public void loginToMyAccountTest() throws InterruptedException, ParserConfigurationException, IOException, SAXException {
        ExtentTest loginTest = extentReports.createTest("Test 1", "Login To my Account");
        loginTest.info("Test 1 started");
        //open the account page to enter the account details
        signinToNextPage.clickOnMyAccountLink();
        Thread.sleep(1500);
        try {
            Assert.assertEquals(Constants.EXPECTED_LOGIN_PAGE_URL, driver.getCurrentUrl());
            loginTest.pass("Step 1 passed: you reached the login page.");
        } catch (AssertionError e) {
            loginTest.fail("Step 1 fail: you doesn't reached the login page.", MediaEntityBuilder.createScreenCaptureFromPath(utilities.takeScreenShot("pictures\\" + "Step1" + currentTime)).build());
        }
        //enter the account details
        signinToNextPage.enterEmailAddress(getData("EMAIL_ADDRESS"));
        signinToNextPage.enterPassword(getData("PASSWORD"));
        signinToNextPage.clickOnSignInBtn();
        Thread.sleep(1500);
        if (driver.getCurrentUrl().equals(Constants.EXPECTED_LOGIN_TO_MY_ACCOUNT_PASS_URL)) {
            loginTest.pass("Step 2 pass: you reached your account.");
        } else {
            loginTest.fail("Step 2 fail. you doesn't reached your account.", MediaEntityBuilder.createScreenCaptureFromPath(utilities.takeScreenShot("pictures\\" + "Step2" + currentTime)).build());
        }
        loginTest.info("Test 1 finished");
    }

    //in this test we navigate between pages in the home shop
    @Test
    public void navigateBetweenPagesTest() throws InterruptedException, ParserConfigurationException, IOException, SAXException {
        ExtentTest navigateTest = extentReports.createTest("Test 2", "Navigate between pages in the NEXT shop");
        navigateTest.info("Test 2 started");
        //open the main next page and click on home to open the home shop page
        driver.get(getData("URL"));
        Thread.sleep(1000);
        //click on home page link and verify you reached to expected page
        homePage.clickOnHomePage();
        Thread.sleep(1000);
        if (driver.getCurrentUrl().equals(Constants.HOME_PAGE_URL))
            navigateTest.pass("Step 1 passed: you reached the login page.");
        else
            navigateTest.fail("Step 1 fail: you  doesn't reached the login page.", MediaEntityBuilder.createScreenCaptureFromPath(utilities.takeScreenShot("pictures\\" + "Step1" + currentTime)).build());
        //open a page by clicking on a left link and verify yue reached to the expected page
        homeShopPage.clickOnKitchenRoomLink();
        Thread.sleep(1000);
        if (driver.getCurrentUrl().equals(Constants.EXPECTED_KITCHEN_URL))
            navigateTest.pass("Step 2 pass: you reached the kitchen page.");
        else
            navigateTest.fail("Step 2 fail: you doesn't reached the kitchen page.", MediaEntityBuilder.createScreenCaptureFromPath(utilities.takeScreenShot("pictures\\" + "Step2" + currentTime)).build());
        //return to home shop page
        driver.navigate().to(Constants.HOME_PAGE_URL);
        Thread.sleep(1000);
        //open a page by clicking on category link and verify you reached to the expected page
        homeShopPage.clickOnLightingCategory();
        Thread.sleep(1000);
        if (driver.getCurrentUrl().equals(Constants.EXPECTED_LIGHTING_URL))
            navigateTest.pass("Step 3 pass: you reached the lighting page.");
        else
            navigateTest.fail("Step 3 fail: you doesn't reached the lighting page.", MediaEntityBuilder.createScreenCaptureFromPath(utilities.takeScreenShot("pictures\\" + "Step3" + currentTime)).build());
        //return to home shop page
        driver.navigate().to(Constants.HOME_PAGE_URL);
        Thread.sleep(1000);
        //open a page by clicking on img link and verify you reached to the expected page
        homeShopPage.clickOnAccessoriesImg();
        Thread.sleep(1000);
        if (driver.getCurrentUrl().equals(Constants.EXPECTED_ACCESSORIES_URL))
            navigateTest.pass("Step 4 pass: you reached the accessories page.");
        else
            navigateTest.fail("Step 4 fail: you doesn't reached the accessories page.", MediaEntityBuilder.createScreenCaptureFromPath(utilities.takeScreenShot("pictures\\" + "Step4" + currentTime)).build());
        //return to home shop page
        driver.navigate().to(Constants.HOME_PAGE_URL);
        //navigate to baby shop page and verify you reached to the expected page.
        homePage.clickOnBabyPage();
        if (driver.getCurrentUrl().equals(Constants.EXPECTED_BABY_SHOP_URL))
            navigateTest.pass("Step 5 pass: you reached the baby shop page.");
        else
            navigateTest.fail("Step 5 fail: you doesn't reached the baby shop page.", MediaEntityBuilder.createScreenCaptureFromPath(utilities.takeScreenShot("pictures\\" + "Step5" + currentTime)).build());
        //change the language to hebrew and verify the language was changed.
        homePage.chooseHebrewLanguage();
        Thread.sleep(3000);
        String currentLanguageUrl = driver.getCurrentUrl();
        if (currentLanguageUrl.contains(Constants.HEBREW_URL))
            navigateTest.pass("Step 6 pass: the language changed successfully.");
        else
            navigateTest.fail("Step 6 fail: language doesn't changed as expected.the current URL is: " + currentLanguageUrl, MediaEntityBuilder.createScreenCaptureFromPath(utilities.takeScreenShot("pictures\\" + "Step6" + currentTime)).build());
        //change to english language back
        homePage.chooseEnglishLanguage();
        Thread.sleep(1000);
        navigateTest.info("Test 2 finished");
    }


    //in this test we select a specific product in the searching page
    @Test
    public void searchProduct() throws InterruptedException, IOException {
        ExtentTest searchProductTest = extentReports.createTest("Test 3", "Search product");
        searchProductTest.info("Test 3 started");
        //open the home page
        driver.get(Constants.HOME_PAGE_URL);
        Thread.sleep(1500);
        //search a product by typing a product name in the search-box.
        homePage.searchProduct();  //this method is typing a product name, and clicking on the search icon to apply the searching
        searchPage.chooseSpecificProduct();    //this method is to choose a specific product after searching
        Thread.sleep(1000);
        try {
            Assert.assertEquals(Constants.BLUE_CHINO_TROUSERS_URL, driver.getCurrentUrl());
            searchProductTest.pass("Step 1 pass: you reached to the expected product.");
        } catch (AssertionError e) {
            searchProductTest.fail("Step 1 fail: you doesn't reached to the expected product.", MediaEntityBuilder.createScreenCaptureFromPath(utilities.takeScreenShot("pictures\\" + "Step1" + currentTime)).build());
        }
        searchProductTest.info("Test 3 finished");

    }


    //in this page we choose the product details: waist, colour, size.  and after that, add the product to the bag
    @Test
    public void productPageTest() throws InterruptedException, IOException {
        ExtentTest productPageTest = extentReports.createTest("Test 4", "Product page");
        productPageTest.info("Test 4 started");
        //open the product page
        driver.get(Constants.BLUE_CHINO_TROUSERS_URL);
        Thread.sleep(1000);
        //choose product details
        //choose waist and verify the expected waist is selected
        productPage.chooseWaist();
        Thread.sleep(1500);
        String currentWaist = productPage.getCurrentWaist();
        if (currentWaist.equals(Constants.EXPECTED_WAIST))
            productPageTest.pass("Step 1 pass: the expected waist is selected.");
        else
            productPageTest.fail("Step 1 fail.  the expected waist is " + Constants.EXPECTED_WAIST + ". the actual waist is " + currentWaist + ".", MediaEntityBuilder.createScreenCaptureFromPath(utilities.takeScreenShot("pictures\\" + "Step1" + currentTime)).build());
        //choose colour and verify the expected colour is selected
        productPage.chooseColour();
        Thread.sleep(1500);
        String currentColour = productPage.getCurrentColour();
        if (currentColour.equals(Constants.EXPECTED_COLOUR))
            productPageTest.pass("Step 2 pass: the expected colour is selected.");
        else
            productPageTest.fail("Step 2 fail.  the expected colour is " + Constants.EXPECTED_COLOUR + ". the actual colour is " + currentColour + ".", MediaEntityBuilder.createScreenCaptureFromPath(utilities.takeScreenShot("pictures\\" + "Step2" + currentTime)).build());
        //choose size and verify the expected size is selected
        productPage.chooseSize();
        Thread.sleep(1500);
        String currentSize = productPage.getCurrentSize();
        if (currentSize.equals(Constants.EXPECTED_SIZE))
            productPageTest.pass("Step 3 pass: the expected size is selected.");
        else
            productPageTest.fail("Step 3 fail.  the expected size is " + Constants.EXPECTED_SIZE + ". the actual size is " + currentSize + ".", MediaEntityBuilder.createScreenCaptureFromPath(utilities.takeScreenShot("pictures\\" + "Step3" + currentTime)).build());
        //add one item to bag
        productPage.addToBag();
        Thread.sleep(1500);
        //add second item to bag
        productPage.addToBag();
        Thread.sleep(3000);
        //check if the bag contain  2 items
        String shoppingBagHeader = productPage.getShoppingBagHeader();
        try {
            Assert.assertEquals(Constants.EXPECTED_SHOPPING_BAG_HEADER, shoppingBagHeader);
            productPageTest.pass("Step 4 pass: Your bag contain 2 product as expected.");
        } catch (AssertionError e) {
            productPageTest.fail("Step 4 fail: Your bag doesn't contain 2 product as expected.", MediaEntityBuilder.createScreenCaptureFromPath(utilities.takeScreenShot("pictures\\" + "Step4" + currentTime)).build());
        }
        Thread.sleep(1500);
        //go to the checkout
        productPage.clickOnCheckout();
        Thread.sleep(3000);
        if (driver.getCurrentUrl().equals(Constants.CHECKOUT_URL))
            productPageTest.pass("Step 5 pass: you reached to the payment page.");
        else
            productPageTest.fail("Step 5 fail: you doesn't reached to the payment page.", MediaEntityBuilder.createScreenCaptureFromPath(utilities.takeScreenShot("pictures\\" + "Step5" + currentTime)).build());
        productPageTest.info("Test 4 finished");

    }


    @Test
    public void paymentPageTest() throws InterruptedException, ParserConfigurationException, IOException, SAXException {
        ExtentTest paymentTest = extentReports.createTest("Test 5", "Payment page");
        paymentTest.info("Test 5 started");
        //open the payment page
        driver.get(Constants.CHECKOUT_URL);
        if (driver.getCurrentUrl().equals(Constants.EXPECTED_LOGIN_PAGE_URL)) {
            signinToNextPage.enterEmailAddress(getData("EMAIL_ADDRESS"));
            signinToNextPage.enterPassword(getData("PASSWORD"));
        }
        Thread.sleep(2000);
        try {
            Assert.assertEquals(Constants.CHECKOUT_URL, driver.getCurrentUrl());
            paymentTest.pass("Step 1 pass: the payment page opens as expected.");
        } catch (AssertionError e) {
            paymentTest.fail("Step 2 fail: the payment page doesn't opens as expected.", MediaEntityBuilder.createScreenCaptureFromPath(utilities.takeScreenShot("pictures\\" + "Step1" + currentTime)).build());
        }
        //choose the credit card payment option
        paymentPage.clickOnCreditCartOption();
        Thread.sleep(2000);
        if (paymentPage.isCreditCardSelected())
            paymentTest.pass("Step 2 pass: the credit card payment option is selected.");
        else
            paymentTest.fail("Step 2 fail: the credit card payment option is not selected.", MediaEntityBuilder.createScreenCaptureFromPath(utilities.takeScreenShot("pictures\\" + "Step2" + currentTime)).build());
        //enter the credit card details
        paymentPage.enterCreditCardNumber(getData("CREDIT_CARD_NUMBER"));
        Thread.sleep(2000);
        paymentPage.enterExpiryMonth(getData("EXPIRY_MONTH"));
        Thread.sleep(2000);
        paymentPage.enterExpiryYear(getData("EXPIRY_YEAR"));
        Thread.sleep(2000);
        paymentPage.enterSecurityCode(getData("SECURITY_CODE"));
        Thread.sleep(2000);
        //click on "pay now" to complete the payment
        paymentPage.clickOnPayNowBtn();
        try {
            Assert.assertEquals(Constants.EXPECTED_VALIDATION_NOTE_CURD_NUMBER, paymentPage.getValidationNoteCardNumber());
            {
                paymentTest.pass("Step 3 pass. validation note display as expected.");
            }
        } catch (AssertionError e) {
            paymentTest.fail("Step 3 fail: validation note doesn't display as expected.", MediaEntityBuilder.createScreenCaptureFromPath(utilities.takeScreenShot("pictures\\" + "Step3" + currentTime)).build());
        }
        paymentTest.info("Test 5 finished");

    }


    @AfterClass
    public static void afterClass() throws InterruptedException {
        System.out.println("************afterClass**********");
        Thread.sleep(1000);
        driver.quit();
        Thread.sleep(2000);
        extentReports.flush();
    }


}
