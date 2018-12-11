package com.cleartrip.testcases;

import com.cleartrip.basetest.BaseTestWeb;
import com.cleartrip.page.web.FlightBookingPage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

public class FlightBookingTest extends BaseTestWeb {
    WebDriver driver = new ChromeDriver();

    @Test
    public void testThatResultsAppearForAOneWayJourney () {

        FlightBookingPage fg = new FlightBookingPage(seDriver);
        Assert.assertTrue(fg.isOneWayDisplayed(), "One way flight booking option is display");
        Assert.assertTrue(fg.isToCityDisplayed(), "To city flight option is display");
        Assert.assertTrue(fg.isFromeCityDisplayed(), "from city flight option is display");
        Assert.assertTrue(fg.isdatepickerDisplayed(), "For booking a flight date option is display");

        fg.clickOneWay();
        fg.clickFromWhere("Bangalore");

        // wait for the auto complete options to appear for the origin
        fg.originCity(0);

        fg.Tocity("delhi");

        // wait for the auto complete options to appear for the destination
        // select the first item from the destination auto complete list

        fg.DestinationCity(0);
        fg.selectDate();

        // all fields filled in. Now click on search
        fg.searchFlight();
        driver.findElement(By.id("SearchBtn")).click();

    }

}
