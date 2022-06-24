package org.example;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class DesktopsPage extends Utils {

    private By _zToAOption = By.xpath("//select[@id=\"products-orderby\"]/option[3]");
    private By _productTitles = By.xpath("//h2[@class='product-title']/a");

    public void clickOnSortByZToAOption() {

        //Under sort by functionality, select "Name Z-A" option
        clickOnElement(_zToAOption);
    }
    public void verifyProductListedInZToAFormat(){

        //Verify that all the products are listed in Z-A format (Assert Point)
        ArrayList<String> beforeProductList = new ArrayList<String>();
        List<WebElement> productTitles = driver.findElements(_productTitles);

        //div[contains(@class,'product-grid')]//div[@class='item-box']//h2
        for (WebElement we:productTitles){
            beforeProductList.add(we.getText().substring(0, 1));
        }
        Collections.sort(beforeProductList, Collections.reverseOrder());
        System.out.println(beforeProductList);

        List<String> afterProductList = new ArrayList<String>();
        for (WebElement we:productTitles){
            afterProductList.add(we.getText().substring(0, 1));
        }
        System.out.println(afterProductList);
        Assert.assertEquals(afterProductList, beforeProductList, "Product is not listed in Z to A format");
        //Assert.assertTrue(afterProductList.equals(beforeProductList));
    }
}
