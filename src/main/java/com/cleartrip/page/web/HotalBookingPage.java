package com.cleartrip.page.web;

import com.cleartrip.page.base.BasePageWeb;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

public class HotalBookingPage extends BasePageWeb {
    WebDriverWait wait = new WebDriverWait(driver, 20);
    @FindBy(linkText = "Hotels")
    private WebElement hotelLink;
    @FindBy(id = "Tags")
    private WebElement localityTextBox;
    @FindBy(id = "SearchHotelsButton")
    private WebElement searchButton;
    @FindBy(id = "travellersOnhome")
    private WebElement travellerSelection;

    public HotalBookingPage (WebDriver driver) {
        super(driver);

    }

    /**
     * Click on Hotels Link.
     *
     * @return the hotel class instance.
     */
    public HotalBookingPage clickHotels1Link () {
        wait.until(ExpectedConditions.visibilityOf(hotelLink));
        hotelLink.click();
        return this;
    }

    public void localityTextBox (String hotelLocation) {
        wait.until(ExpectedConditions.visibilityOf(localityTextBox));
        localityTextBox.sendKeys(hotelLocation);
        Assert.assertEquals(localityTextBox.getAttribute("value"), hotelLocation);
    }

    public void searchHotal () {
        wait.until(ExpectedConditions.visibilityOf(travellerSelection));

        new Select(travellerSelection).selectByVisibleText("1 room, 2 adults");
        searchButton.click();

    }


    public boolean isHotelLinkDisplayed () {
        return hotelLink.isDisplayed() && hotelLink.isEnabled();
    }

    public boolean isLocalityTextBoxDisplayed () {
        return localityTextBox.isDisplayed() && localityTextBox.isEnabled();
    }

    public boolean isSearchButtonDisplayed () {
        return searchButton.isDisplayed() && searchButton.isEnabled();
    }

    public boolean isTravelerSelectionDisplayed () {

        return travellerSelection.isDisplayed() && travellerSelection.isEnabled();
    }
}
