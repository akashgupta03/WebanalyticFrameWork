package com.cleartrip.testcases;

import com.cleartrip.basetest.BaseTestWeb;
import com.cleartrip.page.web.HotalBookingPage;
import org.testng.Assert;
import org.testng.annotations.Test;


public class HotelBookingTest extends BaseTestWeb {
    @Test
    public void shouldBeAbleToSearchForHotels () {

        HotalBookingPage ht = new HotalBookingPage(seDriver);

        Assert.assertTrue(ht.isHotelLinkDisplayed(), "hotal link is display");
        Assert.assertTrue(ht.isLocalityTextBoxDisplayed(), "user able to choice hotal location");
        Assert.assertTrue(ht.isSearchButtonDisplayed(), "user able to search hotal in selected location");
        Assert.assertTrue(ht.isTravelerSelectionDisplayed(), "User able to select Travellers");

        ht.clickHotels1Link();
        ht.localityTextBox("Indiranagar, Bangalore");

        ht.searchHotal();

    }
}
