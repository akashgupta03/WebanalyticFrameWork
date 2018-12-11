package com.cleartrip.basetest;

import com.cleartrip.setup.web.SeleniumDriverManager;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Parameters;

import java.util.concurrent.TimeUnit;

public class BaseTestWeb {
    public String baseUrl;
    public String browser;

    public WebDriver seDriver;

    @Parameters({"baseUrl", "browser"})
    @BeforeSuite(alwaysRun = true)
    public void setUp (String url, String browser) throws Exception {

        this.baseUrl = "http://" + url + "/";
        this.browser = browser;

        System.out.println("Starting test against: " + url);

        seDriver = SeleniumDriverManager.createBrowserInstance(browser, baseUrl);
        seDriver.manage().window().maximize();

        seDriver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
        seDriver.manage().timeouts().pageLoadTimeout(60, TimeUnit.SECONDS);

    }

    @AfterMethod(alwaysRun = true)
    public void partitionLine () {

        System.out.println("\n===========================");
    }

    @AfterSuite(alwaysRun = true)
    public void cleanup () {
        SeleniumDriverManager.killDriver();
    }

}
