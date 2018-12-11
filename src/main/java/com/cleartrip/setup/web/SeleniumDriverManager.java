package com.cleartrip.setup.web;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.safari.SafariDriver;

public class SeleniumDriverManager {

    public static Logger LOG = Logger.getLogger(SeleniumDriverManager.class);
    public static WebDriver driver;

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

    public static void killDriver () {
        if (driver != null) {
            LOG.info("Killing selenium driver session");
            driver.quit();

            try {
                LOG.debug("Called timer to wait for 3 seconds");
                Thread.sleep(3 * 1000);
            } catch (InterruptedException e) {
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

        LOG.info("Creating " + browser + " driver");
        if (browser.equalsIgnoreCase("Firefox")) {
            System.setProperty("webdriver.gecko.driver", "./geckodriver");

        } else if (browser.equalsIgnoreCase("IE")) {
            System.setProperty("webdriver.ie.driver", "./IEdriverServer.exe");
            driver = new InternetExplorerDriver();
        } else if (browser.equalsIgnoreCase("Safari")) {
            driver = new SafariDriver();
        } else if (browser.equalsIgnoreCase("chrome")) {
            System.setProperty("webdriver.chrome.driver", "./chromedriver_linux");
            driver = new ChromeDriver();
        }

        LOG.info("Local webdriver created.");
        return driver;
    }
}
