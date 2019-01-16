package com.embibe.basetest;

import com.embibe.page.base.MobProxy;
import com.embibe.setup.web.SeleniumDriverManager;
import com.utils.ReadHraFile;
import de.sstoehr.harreader.HarReaderException;
import net.lightbody.bmp.BrowserMobProxyServer;
import net.lightbody.bmp.core.har.Har;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Parameters;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.concurrent.TimeUnit;

public class BaseTestWeb extends MobProxy
{
    public String baseUrl;
    public String browser;

    public WebDriver seDriver;



    @Parameters({"baseUrl", "browser"})
    @BeforeSuite(alwaysRun = true)
    public void setUp (String url, String browser) throws Exception
    {

        this.baseUrl = "http://" + url + "/";
        this.browser = browser;

        System.out.println("Starting test against: " + url);

        seDriver = SeleniumDriverManager.createBrowserInstance(browser, baseUrl);
        seDriver.manage().window().maximize();

        seDriver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
        seDriver.manage().timeouts().pageLoadTimeout(60, TimeUnit.SECONDS);
        seDriver.navigate().refresh();

    }

    @AfterMethod(alwaysRun = true)
    public void partitionLine () {

        System.out.println("\n===========================");
    }

    @AfterSuite(alwaysRun = true)
    public void cleanup () throws IOException, HarReaderException {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.'000Z'", Locale.ENGLISH);
        Date date = new Date();
        String fileName = simpleDateFormat.format(date);

        Har har = proxy.getHar();
      //  har.getLog().getEntries().stream().forEach(entry -> entry.get);
        File file = new File("./ProxyHarFile/"+fileName+".har");
        try {
            har.writeTo(file);
        }
        catch (Exception e)
        {
            System.out.println(e.toString());
            System.out.println("could not file"+file);
        }
        ReadHraFile readHrafile=new ReadHraFile();
        readHrafile.ConvertHatToJson(fileName);

        SeleniumDriverManager.killDriver();
        seDriver.quit();
    }

}
