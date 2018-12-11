package com.cleartrip.page.web;

import com.cleartrip.page.base.BasePageWeb;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;


public class ClartripSignInPage extends BasePageWeb {
    private WebDriverWait wait = new WebDriverWait(driver, 20);
    @FindBy(linkText = "Your trips")
    private WebElement YourTrip;
    @FindBy(id = "SignIn")
    private WebElement SignIn;
    @FindBy(id = "email")
    private WebElement username;
    @FindBy(id = "password")
    private WebElement pwd;
    @FindBy(id = "signInButton")
    private WebElement signInButton;
    @FindBy(id = "errors1")
    private WebElement errors1;
    private String errormessage = "There were errors in your submission";

    public ClartripSignInPage (WebDriver driver) {
        super(driver);
        // TODO Auto-generated constructor stub
    }

    public void YourTrip () {

        wait.until(ExpectedConditions.visibilityOf(YourTrip));
        YourTrip.click();

    }

    public void clickOnSignIn () {

        wait.until(ExpectedConditions.visibilityOf(SignIn));
        SignIn.click();

    }

    public void setUserName (String emailid) {

        wait.until(ExpectedConditions.visibilityOf(username));
        username.sendKeys(emailid);
        Assert.assertEquals(username.getAttribute("value"), emailid);


    }

    public void setPassword (String password) {


        wait.until(ExpectedConditions.visibilityOf(pwd));
        pwd.sendKeys(password);
        Assert.assertEquals(pwd.getAttribute("value"), password);

    }

    public void ComplateSignIn () {
        wait.until(ExpectedConditions.visibilityOf(signInButton));
        signInButton.click();
        ;
    }

    public boolean isYourTripDisplayed () {
        return YourTrip.isDisplayed() && YourTrip.isEnabled();
    }


    public boolean isSignInDisplayed () {
        return SignIn.isDisplayed() && SignIn.isEnabled();
    }

    public boolean isComplateSignInDisplayed () {
        return signInButton.isDisplayed() && signInButton.isEnabled();
    }

    public boolean iserrors1Displayed () {
        wait.until(ExpectedConditions.titleContains(errormessage));
        return errors1.isDisplayed();
    }

    public void errorgettext () {
        errors1.getText();
    }


}
