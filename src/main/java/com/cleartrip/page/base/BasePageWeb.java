package com.cleartrip.page.base;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

import java.util.concurrent.TimeUnit;

public class BasePageWeb {

    protected WebDriver driver;

    public BasePageWeb (WebDriver driver) {
        this.driver = driver;
        this.initPage();
    }

    public void initPage () {
        PageFactory.initElements(this.driver, this);

    }

    public void pageLoadTimeOut (long time, TimeUnit timeunits) {
        this.driver.manage().timeouts().pageLoadTimeout(time, timeunits);

    }
}
