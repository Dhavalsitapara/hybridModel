package org.example;

import org.openqa.selenium.By;
import org.testng.Assert;

public class ShoppingCartPage  extends Utils {

    LoadProp loadProp =  new LoadProp();

    private By _buildYourOwnComputerProduct = By.className("product-name");

    public void buildYourOwnComputerInShoppingCart() {
        //Check if the product has been added to the basket by verifying product name "build your own computer"
        String actualMessage = driver.findElement(_buildYourOwnComputerProduct).getText();
        String expectedMessage = loadProp.getProperty("VerifyShoppingCartByProductAdded");
        Assert.assertEquals(actualMessage, expectedMessage, "Product is not added to the basket");
    }
}
