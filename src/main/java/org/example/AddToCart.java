package org.example;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

public class AddToCart extends Utils{

    private By _processor = By.id("product_attribute_1"); //locater
    private By _ram = By.id("product_attribute_2");
    private By _hDD320GB = By.id("product_attribute_3_6");
    private By _vistaPremium = By.id("product_attribute_4_9");
    private By _acrobatReader = By.id("product_attribute_5_11");
    private By _totalCommander = By.id("product_attribute_5_12");
    private By _computerAddToCart = By.id("add-to-cart-button-1");
    private By _shoppingCart = By.className("cart-label");
    private By _actualShoppingCartMessage = By.xpath("//h1[.='Shopping cart']");
    private By _actualBuildYourOwnComputerText = By.className("product-name");

    public void SelectCustomisedAndAddProductToCart(){

        // Select processor 2.2GHz
        Select processor = new Select(driver.findElement(_processor));
        processor.selectByValue("1");

        //Select RAM 2GB
        Select ram = new Select(driver.findElement(_ram));
        ram.selectByValue("3");

        //Select HDD 320GB
        clickOnElement(_hDD320GB);

        // Select OS Vista premium
        clickOnElement(_vistaPremium);

        // Select all software type - Microsoft office already selected
        clickOnElement(_acrobatReader); //Acrobat Reader
        clickOnElement(_totalCommander); //Total Commander

        // Add 'Build your computer' product to cart
        clickOnElement(_computerAddToCart);

        // Click shopping cart
        clickOnElement(_shoppingCart);

        // Expected Shopping cart text
        String expectedShoppingCart = "Shopping cart";

        // Actual Shopping cart text
        String  actualShoppingCart = getTexFromElement(_actualShoppingCartMessage);

        // Verify user can see shopping cart text
        Assert.assertEquals(actualShoppingCart,expectedShoppingCart,"Shopping cart not displayed");

        // Expected text of 'Build your own computer'
        String expectedBuildYourOwnComputer = "Build your own computer";

        // Actual text of 'Build your own computer'
        String actualBuildYourOwnComputer = getTexFromElement(_actualBuildYourOwnComputerText);

        // Verify user can see selected product name in shopping cart
        Assert.assertEquals(actualBuildYourOwnComputer,expectedBuildYourOwnComputer,"Build your computer not visible");

    }
}
