package com.embibe.testcases;

import com.embibe.basetest.BaseTestWeb;
import com.embibe.page.web.embibeSearchPage;
import org.testng.Assert;
import org.testng.annotations.Test;

public class embibeSearchTest extends BaseTestWeb {

    @Test(priority = 0, description = "Enter the exam and in search field and search the exam  and try to practice the exam")
    public void searchexam_clickOnStartPracticeBtn ()
    {

        embibeSearchPage embibePage = new embibeSearchPage(seDriver);

        Assert.assertTrue(embibePage.EmbibePageTitleIsDisplay(), "Page title is display");
//entered the exam
      embibePage.searchexam("bank");

        embibePage.clickOnStartPracticeBtn();



    }



}
