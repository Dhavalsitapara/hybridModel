package org.example;

import org.openqa.selenium.By;

public class AddToCartInDesktop extends Utils{

    private By _selectAndAddToCart = By.xpath("//div/div[1]/div/div[2]/div[3]/div[2]/button[@class=\"button-2 product-box-add-to-cart-button\"]");

    public void SelectAndAddToCart(){
        //Click on Add to cart for 'Build your own computer'
        clickOnElement(_selectAndAddToCart);

    }
}
