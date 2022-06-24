package org.example;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.asserts.SoftAssert;

import java.util.Iterator;
import java.util.List;
import java.util.Set;

public class HomePage extends Utils {

    LoadProp loadProp = new LoadProp();
    SoftAssert softAssert = new SoftAssert();

    private By _registerButton = By.className("ico-register");
    private By _verifyEuroSign = By.xpath("//*[@id=\"customerCurrency\"]");
    private By _verifyDollarSign = By.className("actual-price");
    private By _changeDollarToEuro = By.xpath("//*[@id=\"customerCurrency\"]/option[2]");
    private By _good = By.id("pollanswers-2");
    private By _voteButton = By.cssSelector("[id=\"vote-poll-1\"]");
    private By _actualVoteMessage = By.cssSelector("[class=\"poll-vote-error\"]");
    private By _registeredActualMessage = By.cssSelector("[class=\"poll-total-votes\"]");
    private By _buildYourOwnComputer = By.xpath("//h2/a[@href=\"/build-your-own-computer\"]");
    private By _errorMessageForVote = By.xpath("//div[@id=\"block-poll-vote-error-1\"]");
    private By _productTitles = By.xpath("//div[contains(@class,'product-grid')]//div[@class='item-box']//h2");
    private By _loginButton = By.className("ico-login");
    private By _wishlistButton = By.className("wishlist-label");
    private By _welcomeToOurStore = By.xpath("//div[@class='topic-block-title']/h2");
    private By _computerButton = By.linkText("Computers");
    private By _facebookIcon = By.className("facebook");
    private By _searchBar = By.id("small-searchterms");
    private By _searchButton = By.className("search-box-button");
    private By _detailsButton = By.xpath("/html/body/div[6]/div[3]/div/div/div/div/div[5]/div[2]/div[2]/div[3]/a");

    public void verifyIfNonRegisteredUserIsAbleToVote() {

        //community poll section, click on good
        clickOnElement(_good);

        //click vote
        clickOnElement(_voteButton);

        //Wait for registration message to be visible
        driverWaitsUntil(_actualVoteMessage, 2);

        //Expected
        String expectedMessage = "only Registered used can vote.";

        //Actual message
        String actualMessage = driver.findElement(_errorMessageForVote).getText();

        //Verify text
        Assert.assertTrue(actualMessage.contains("Only registered users can vote."),"Non registered user is able to vote");
    }

    public void verifyRegisteredUserIsAbleToVote() {
        //In community poll section, click on good
        clickOnElement(_good);

        // click vote
        clickOnElement(_voteButton);

        // Expected Message
        String expectedMessage = " vote(s)...";

        // Actual message
        String actualMessage = getTexFromElement(_registeredActualMessage).replaceAll("\\d", "");

        // Verify text
        Assert.assertEquals(actualMessage, expectedMessage, "No result for vote.");
    }

    public void clickOnRegisterButton() {

        //Click on register button
        clickOnElement(_registerButton);

    }

    public void changeDollarIntoEuroSign(){
        //Change the Dollar into Euro sign
        clickOnElement(_changeDollarToEuro);
        //driver.findElement(By.xpath("//*[@id=\"customerCurrency\"]/option[2]")).click();
    }

    public void verifyDollarSignOnHomePage(){
        //Verify if build your own computer price is display in Dollar (Assert Point)
        String actual_Message = driver.findElement(_verifyDollarSign).getText();
        Assert.assertTrue(actual_Message.startsWith("$"), "US Dollar is not the currency selected");
    }

    public void verifyEuroSignOnHomePage(){
        //Verify if build your own computer price is display in Euro (Assert Point)
        String actualMessage = driver.findElement(_verifyEuroSign).getText();
        Assert.assertTrue(actualMessage.contains("Euro"), "Euro is not the currency selected");
    }

    public void buildYourOwnComputerOnHomePage(){
        //Click on the Build your own computer
        clickOnElement(_buildYourOwnComputer);
    }

    public void getProductTitles() {
        //Verify the product titles on the home page
        List<WebElement> productTitles = driver.findElements(_productTitles);
        System.out.println(productTitles.size());
        for (WebElement titles : productTitles) {
            System.out.println(titles.getText());
        }
    }

    public void verifyHomePageContains() {
        softAssert.assertEquals(getTexFromElement(_registerButton), loadProp.getProperty("RegisterButton"));
        softAssert.assertEquals(getTexFromElement(_loginButton),loadProp.getProperty("LoginButton"));
        softAssert.assertEquals(getTexFromElement(_wishlistButton), loadProp.getProperty("WishlistButton"));
        softAssert.assertEquals(getTexFromElement(_welcomeToOurStore), loadProp.getProperty("WelcomeToOurStoreTitle"));
        softAssert.assertAll();
    }
    public void voteButton() {
        //Click on the Vote Button on the Home Page
        clickOnElement(_voteButton);
    }

    public void handleVoteAlert(){
        //Switch to Alert
        Alert alert = driver.switchTo().alert();

        //Get text for Alert
        String alertPopUp = driver.switchTo().alert().getText();
        String actualErrorMessage = loadProp.getProperty("AlertErrorMessage");
        Assert.assertEquals(actualErrorMessage, alertPopUp);

        //Click on Ok Button to close the Alert
        driver.switchTo().alert().accept();
    }

    public void computerButton(){
        //Click on computer on Home Page
        clickOnElement(_computerButton);
    }

    public void facebookPageWindowHandle(){
        //Declare that driver is on Home Page, which will be the Main Page
        String MainWindow = driver.getWindowHandle();

        //Click on Facebook Button
        clickOnElement(_facebookIcon);

        //Handle all new opened windows
        Set<String> screenOne = driver.getWindowHandles();
        Iterator<String> i1 = screenOne.iterator();

        while (i1.hasNext()) {
            String ChildWindow = i1.next();
            if (!MainWindow.equalsIgnoreCase(ChildWindow)) {
                //Switching to child window
                driver.switchTo().window(ChildWindow);
                //Verify user is on correct Facebook page
                String expectedFacebookUrl = loadProp.getProperty("FacebookPageURL");
                String actualFacebookUrl = driver.getCurrentUrl();
                Assert.assertEquals(actualFacebookUrl, expectedFacebookUrl);
                driver.close();
            }
            //Switching to Parent window
            driver.switchTo().window(MainWindow);
        }
    }

    public void verifyUserIsOnHomePage(){
        // verify user is on Home Page
        String expectedHomeURL = loadProp.getProperty("HomePageURL");
        String actualHomeURL = driver.getCurrentUrl();
        Assert.assertEquals(actualHomeURL, expectedHomeURL);
    }

    public void enterProductNameToSearch(String product){
        //Home Page click on search bar and enter Nike or Apple product
        typeText(_searchBar, product);

        //Click on Search Button on Home Page
        clickOnElement(_searchButton);

        //Verify that user is on the searched product page
        String expectedPageURL = loadProp.getProperty("SearchProductPageURL")+product;
        String actualPageURL = driver.getCurrentUrl();
        Assert.assertEquals(actualPageURL,expectedPageURL);
    }

    public void verifyProductListedContainsProductNameRequested(){
        //Verify that all the product listed contains either Nike or Apple Check
        List<WebElement> productTitles = driver.findElements(_productTitles);
        for (WebElement e: productTitles){
            System.out.println(e.getText());
        }
    }

    public void clickOnDetailsButton(){
        //On Home Page click under News and nopCommerce new release
        clickOnElement(_detailsButton);
    }

    public void clickOnCategoryLink(String categoryName){
        clickOnElement(By.linkText(categoryName));
    }
}
