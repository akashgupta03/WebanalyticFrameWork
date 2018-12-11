package com.cleartrip.testcases;

import com.cleartrip.basetest.BaseTestWeb;
import com.cleartrip.page.web.ClartripSignInPage;
import org.testng.Assert;
import org.testng.annotations.Test;

public class CleartripSignInTest extends BaseTestWeb {

    @Test(priority = 0, description = "Invalid Login Scenario with wrong username and password.")
    public void invalidLoginTest_InvalidUserNameInvalidPassword () {

        ClartripSignInPage signInPage = new ClartripSignInPage(seDriver);

        Assert.assertTrue(signInPage.isYourTripDisplayed(), "Your trip button is display");
        signInPage.YourTrip();
        Assert.assertTrue(signInPage.isSignInDisplayed(), "SignIn button in home pasge is display");
        Assert.assertTrue(signInPage.isComplateSignInDisplayed(), "signin buttan is display");
        signInPage.clickOnSignIn();
        // entered wrong mailed message
        signInPage.setUserName("xyz.@gmail.com");
        // Enter wrong message
        signInPage.setPassword("xyz");
        signInPage.ComplateSignIn();

        Assert.assertTrue(signInPage.iserrors1Displayed(), "error message is displayed");
    }

    @Test(priority = 1, description = "Invalid Login Scenario with empty username and password.")
    public void shouldThrowAnErrorIfSignInDetailsAreMissing () {

        ClartripSignInPage signInPage = new ClartripSignInPage(seDriver);

        Assert.assertTrue(signInPage.isYourTripDisplayed(), "Your trip button is display");
        signInPage.YourTrip();
        Assert.assertTrue(signInPage.isSignInDisplayed(), "SignIn button in home pasge is display");
        Assert.assertTrue(signInPage.isComplateSignInDisplayed(), "signin buttan is display");
        signInPage.clickOnSignIn();
        // entered wrong mailed message
        signInPage.setUserName("");
        // Enter wrong message
        signInPage.setPassword("");
        signInPage.ComplateSignIn();

        Assert.assertTrue(signInPage.iserrors1Displayed(), "error message is displayed");
    }

}
