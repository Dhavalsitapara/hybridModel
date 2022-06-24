package org.example;

import org.openqa.selenium.By;
import org.testng.Assert;

public class RegistrationSuccesPage extends Utils{

    LoadProp loadProp = new LoadProp();

    private By _registrationSuccessfulText = By.className("result");
    private By _continueButton = By.className("register-continue-button");

    public void verifyUserRegisteredSuccessfully(){
        String actualMessage =driver.findElement(_registrationSuccessfulText).getText();
        String expectedMessage = loadProp.getProperty("RegisteredSuccessfullyMessage");
        Assert.assertEquals(actualMessage,expectedMessage,"Registration was failed");
    }

    public void clickOnContinueButton(){
        //Click on Continue Button
        clickOnElement(_continueButton);
    }
}
