package org.example;

import org.openqa.selenium.By;
import org.testng.Assert;

public class EmailAFriendResultPage extends Utils {

    LoadProp loadProp = new LoadProp();

    private By _resultText = By.className("result");

    public void verifyUserSentEmailSuccessfully (){
        //Verify the message "Your message has been sent."
        String actualMessage = driver.findElement(_resultText).getText();
        String expectedMessage = loadProp.getProperty("EmailAFriendSuccessMessage");
        Assert.assertEquals(actualMessage, expectedMessage, "Email was not sent successfully");
    }
}
