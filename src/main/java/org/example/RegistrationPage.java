package org.example;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.Select;

public class RegistrationPage extends Utils{
    LoadProp loadProp= new LoadProp();

    private By _gender = By.id("gender-male");
    private By _firstName = By.xpath("//input[@name='FirstName']");
    private By _lastName = By.id("LastName");
    private By _dateOfBirthField = By.name("DateOfBirthDay");
    private By _monthOfBirthField = By.name("DateOfBirthMonth");
    private By _yearOfBirthField = By.name("DateOfBirthYear");
    private By _email = By.id("Email");
    private By _password = By.name("Password");
    private By _confirmPassword = By.name("ConfirmPassword");
    private By _register = By.id("register-button");

    public void verifyUserIsOnRegistrationPage()
    {
        driverWaitsUrl(20,"https://demo.nopcommerce.com/register?returnUrl=%2F");
    }

    public void userRegistrationDetails(){

        //Select Gender Redio Button
//        driver.findElement(By.id("gender-male")).click();
        clickOnElement(_gender);

        // Fist name enter
//        driver.findElement(By.id("FirstName")).sendKeys("Dhaval");
        typeText(_firstName,loadProp.getProperty("FirstName"));

        // Last name enter
//        driver.findElement(By.id("LastName")).sendKeys("Sitapara");
        typeText(_lastName,loadProp.getProperty("LastName"));

        // Birthdate enter
//        Select birthDay = new Select(driver.findElement(By.name("DateOfBirthDay")));
//        birthDay.selectByIndex(05);
        selectFromDropDownIndexValue(_dateOfBirthField, Integer.parseInt(loadProp.getProperty("DateOfBirthday")));


        // Birthmonth enter
//        Select birthMonth = new Select(driver.findElement(By.name("DateOfBirthMonth")));
//        birthMonth.selectByValue("12");
        selectFromDropDownIndexValue(_monthOfBirthField, Integer.parseInt(loadProp.getProperty("MonthOfBirthday")));

        // Birthyear enter
//        Select birthYear = new Select(driver.findElement(By.name("DateOfBirthYear")));
//       birthYear.selectByValue("1994");
        selectFromDropDownVisibleText(_yearOfBirthField, loadProp.getProperty("YearOfBirthday"));


        // Email enter
//        driver.findElement(By.id("Email")).sendKeys("Dhaval" + randomDate() + "@gmail.com");
//        typeText(_email,"patel"+randomDate()+"@nopcommerce.com");
        typeText(_email,loadProp.getProperty("UserEmailField01")+randomDate()+loadProp.getProperty("UserEmailField02"));



        // Password enter
//        driver.findElement(By.id("Password")).sendKeys("Dhaval");
//        typeText(_password,"dhaval123");
        typeText(_password,loadProp.getProperty("UserPassword"));


        // Confirmed password enter
//        driver.findElement(By.id("ConfirmPassword")).sendKeys("Dhaval");
//       typeText(_confirmPassword,"dhaval123");
        typeText(_confirmPassword,loadProp.getProperty("UserPassword"));


    }
    public void clickOnRegistrationButton()
    {
        // Ragister Button
//        clickOnElement(By.id("register-button"));
        clickOnElement(_register);
    }
}
