package com.embibe.setup.web;

import com.embibe.page.base.MobProxy;
import io.github.bonigarcia.wdm.WebDriverManager;
import net.lightbody.bmp.BrowserMobProxyServer;
import org.apache.log4j.Logger;
import org.openqa.selenium.MutableCapabilities;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.ie.InternetExplorerOptions;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.util.HashMap;
import java.util.Map;

public class SeleniumDriverManager
{


    public static Logger LOG = Logger.getLogger(SeleniumDriverManager.class);
    public static WebDriver driver;
    public  static BrowserMobProxyServer proxy;

    public static WebDriver createBrowserInstance (String browser, String url) throws Exception {

        killDriver();

        if (driver != null) {
            LOG.debug("WebDriver is still running. No need to create a new instance.");
        } else {
            driver = createLocalDriver(browser);
            driver.get(url);
        }

        return driver;
    }

    public static void killDriver ()
    {
        if (driver != null)
        {
            LOG.info("Killing selenium driver session");
            driver.quit();

            try {
                LOG.debug("Called timer to wait for 3 seconds");
                Thread.sleep(3 * 1000);
            }
            catch (InterruptedException e)
            {
                LOG.error(e);
                e.printStackTrace();
            }

            if (driver != null) {
                LOG.error("Failed to close previous driver session. Force kill by user is recommended.");
                driver = null;
            }

        }
    }

    private static WebDriver createLocalDriver (String browser) {

        WebDriver driver = null;

        MobProxy proxy=new MobProxy();
        DesiredCapabilities cap = proxy.setUpDesiredCapbility();

        LOG.info("Creating " + browser + " driver");
        if (browser.equalsIgnoreCase("Firefox"))
        {
            WebDriverManager.firefoxdriver().setup();

            FirefoxOptions option = new FirefoxOptions();
            option.merge(cap);
            driver=new FirefoxDriver(option);

        } else if (browser.equalsIgnoreCase("IE"))
        {
            WebDriverManager.iedriver().setup();
            InternetExplorerOptions option = new InternetExplorerOptions();
            option.merge(cap);
            driver = new InternetExplorerDriver(cap);


        } else if (browser.equalsIgnoreCase("chrome")) {
            WebDriverManager.chromedriver().setup();


            ChromeOptions option = new ChromeOptions();
            option.merge(cap);
            driver=new ChromeDriver(option);
            //driver = new ChromeDriver((ChromeOptions) getOptions(ChromeOptions.class,cap));

        }

        LOG.info("Local webdriver created.");
        return driver;
    }




}
