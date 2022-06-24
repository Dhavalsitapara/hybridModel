package org.example;

import org.openqa.selenium.By;

public class ComputersPage extends Utils{

    private By _desktopButton = By.linkText("Desktops");

    public void desktopButton (){
        //Click on Desktops
        clickOnElement(_desktopButton);
    }
}
