package com.cleartrip.page.web;

import com.cleartrip.page.base.BasePageWeb;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.util.List;

public class FlightBookingPage extends BasePageWeb {

    WebDriverWait wait = new WebDriverWait(driver, 20);
    @FindBy(id = "OneWay")
    private WebElement OneWay;
    @FindBy(id = "FromTag")
    private WebElement FromeCity;
    @FindBy(id = "ui-id-1")
    private WebElement originDropDown;
    @FindBy(id = "toTag")
    private WebElement ToCity;
    @FindBy(id = "ui-id-2")
    private WebElement DestinationDropDown;
    @FindBy(xpath = "//*[@id='ui-datepicker-div']/div[1]/table/tbody/tr[3]/td[7]/a")
    private WebElement datepicker;
    @FindBy(id = "SearchBtn")
    private WebElement searchBtn;
    @FindBy(className = "searchSummary")
    private WebElement searchSummary;

    public FlightBookingPage (WebDriver driver) {
        super(driver);
        // TODO Auto-generated constructor stub
    }

    public void clickOneWay () {
        wait.until(ExpectedConditions.visibilityOf(OneWay));
        OneWay.click();
    }

    public void clickFromWhere (String city) {
        wait.until(ExpectedConditions.visibilityOf(FromeCity));
        FromeCity.clear();
        FromeCity.sendKeys(city);
        Assert.assertEquals(FromeCity.getAttribute("value"), city);
    }

    public void originCity (int cityIndex) {

        wait.until(ExpectedConditions.visibilityOf(DestinationDropDown));
        List <WebElement> list = originDropDown.findElements(By.tagName("li"));
        wait.until(ExpectedConditions.visibilityOfAllElements(list));

        list.get(cityIndex).click();

    }

    public void Tocity (String city) {
        wait.until(ExpectedConditions.visibilityOf(ToCity));
        ToCity.clear();
        ToCity.sendKeys(city);
        Assert.assertEquals(ToCity.getAttribute("value"), city);

    }

    public void DestinationCity (int cityIndex) {
        wait.until(ExpectedConditions.visibilityOf(DestinationDropDown));
        List <WebElement> list = DestinationDropDown.findElements(By.tagName("li"));
        wait.until(ExpectedConditions.visibilityOfAllElements(list));
        list.get(cityIndex).click();

    }

    public void selectDate () {
        wait.until(ExpectedConditions.visibilityOf(datepicker));
        datepicker.click();

    }

    public void searchFlight () {
        wait.until(ExpectedConditions.visibilityOf(searchBtn));
        searchBtn.click();
        wait.until(ExpectedConditions.visibilityOf(searchSummary));
    }

    public boolean isOneWayDisplayed () {
        return OneWay.isDisplayed() && OneWay.isEnabled();
    }

    public boolean isFromeCityDisplayed () {
        return FromeCity.isDisplayed() && FromeCity.isEnabled();
    }

    public boolean isToCityDisplayed () {
        return ToCity.isDisplayed() && ToCity.isEnabled();
    }

    public boolean isdatepickerDisplayed () {
        return datepicker.isDisplayed() && datepicker.isEnabled();
    }
}
