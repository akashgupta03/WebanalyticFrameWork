package com.embibe.page.web;

import com.embibe.page.base.BasePageWeb;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;


public class embibeSearchPage extends BasePageWeb
{
    private WebDriverWait wait = new WebDriverWait(driver, 20);
    @FindBy(xpath = "//input[@class='react-typeahead-input react-typeahead-usertext']")
    private WebElement SearchBtn;
    @FindBy(xpath = "//a[@class='practice-btn btn']")
    private WebElement StartPracticeBtn;
    @FindBy(xpath = "//a[@class='test-btn btn']")
    private WebElement TakeTestBtn;

    @FindBy(xpath = "//img[@class='logoImage img-responsive']")
    private  WebElement EmbibeTitle;

    public embibeSearchPage(WebDriver driver)
    {
        super(driver);
        // TODO Auto-generated constructor stub
    }

    public void searchexam (String Exam)
    {

        wait.until(ExpectedConditions.visibilityOf(SearchBtn));
        SearchBtn.sendKeys(Exam);

    }

    public void clickOnStartPracticeBtn () {

        wait.until(ExpectedConditions.visibilityOf(StartPracticeBtn));
        StartPracticeBtn.click();

    }



    public void clickOnTakeTestBtn () {
        wait.until(ExpectedConditions.visibilityOf(TakeTestBtn));
        TakeTestBtn.click();

    }

    public boolean EmbibePageTitleIsDisplay () {

        return EmbibeTitle.isDisplayed() ;
    }



}
