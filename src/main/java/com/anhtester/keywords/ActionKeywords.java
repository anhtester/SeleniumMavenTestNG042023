package com.anhtester.keywords;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ActionKeywords {
    private static WebDriver driver;

    public ActionKeywords(WebDriver driver) {
        this.driver = driver;
    }

    public static void clickElement(String locator){
        driver.findElement(By.xpath(locator)).click();
    }

    public static void setText(String locator, String text){
        driver.findElement(By.xpath(locator)).sendKeys(text);
    }
}
