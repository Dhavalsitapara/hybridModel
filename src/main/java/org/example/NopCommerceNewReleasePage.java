package org.example;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

import java.util.ArrayList;
import java.util.List;

public class NopCommerceNewReleasePage extends Utils {

    LoadProp loadProp = new LoadProp();

    private By _actualPageTitle = By.className("page-title");
    private By _titleField = By.id("AddNewComment_CommentTitle");
    private By _commentField = By.id("AddNewComment_CommentText");
    private By _addNewCommentButton = By.name("add-comment");
    private By _verifyCommentAddedMessage = By.className("result");
    private By _comments = By.xpath("//div[@class='comment-title']");

    public void verifyURl()
    {
        //Verify that user is on the nopcommerce new release page
        String expectedURL = loadProp.getProperty("NopCommerceNewReleasePageURL");
        String actualURL = driver.getCurrentUrl();
        Assert.assertEquals(actualURL, expectedURL);
    }
    public void verifyPageTitle()
    {
        //Verify the title of the page "nopCommerce new release!" (Assert Point - verify Title)
        String expectedPageTitle = loadProp.getProperty("NopCommerceNewReleasePageTitle");
        String actualPageTitle = getTexFromElement(_actualPageTitle);
        Assert.assertEquals(actualPageTitle,expectedPageTitle);
    }

    public void enterTitle()
    {
        //Enter Title
        typeText(_titleField,loadProp.getProperty("NopCommerceNewReleaseTitleField"));
    }

    public void enterComment()
    {
        //Enter Comment
        typeText(_commentField,loadProp.getProperty("NopCommerceNewReleaseCommentField"));
    }

    public void clickOnCommentButton()
    {
        //Click on New Comment Button
        clickOnElement(_addNewCommentButton);
    }
    public void verifyCommentAddedMessage()
    {
        //Verify comment added message "News comment is successfully added." (Assert Point - verify Message)
        String actualMessage = getTexFromElement(_verifyCommentAddedMessage);
        String expectedMessage = loadProp.getProperty("CommentAddedSuccessfullyMessage");
        Assert.assertEquals(actualMessage, expectedMessage, "Comment is not added successfully");
    }

    public void verifyCommentHasBeenAddedToTheCommentListAndListedLast()
    {
        //Verify that user's comment has been added to the comments list
        String title = loadProp.getProperty("NopCommerceNewReleaseTitleField");
        List<WebElement> comments = driver.findElements(_comments);
        List<String> listOfComments = new ArrayList<>();
        for (WebElement we:comments)
        {
            listOfComments.add(we.getText());
        }
        Assert.assertTrue(listOfComments.contains(title));
        String lastComment = listOfComments.get(listOfComments.size()-1);
        System.out.println(lastComment);
        Assert.assertEquals(lastComment, title, "Comments are not listed in correct order");

    }
}
