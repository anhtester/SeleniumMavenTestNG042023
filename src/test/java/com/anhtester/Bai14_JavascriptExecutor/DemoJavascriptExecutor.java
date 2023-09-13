package com.anhtester.Bai14_JavascriptExecutor;

import com.anhtester.common.BaseTest;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

public class DemoJavascriptExecutor extends BaseTest {

    @Test
    public void testJavascriptExecutor01(){
        driver.get("https://cms.anhtester.com/");
        sleep(1);

        //By buttonCloseWelcomeDialog = By.xpath("//button[@data-key='website-popup']");
        //By menuBlogs = By.xpath("//a[normalize-space()='Blogs']");

        WebElement buttonCloseWelcomeDialog = driver.findElement(By.xpath("//button[@data-key='website-popup']"));
        WebElement menuBlogs = driver.findElement(By.xpath("//a[normalize-space()='Blogs']"));
        WebElement buttonViewAllCategories = driver.findElement(By.xpath("//a[normalize-space()='View All Categories']"));
        WebElement buttonApplyNow = driver.findElement(By.xpath("//a[normalize-space()='Apply Now']"));

        //buttonCloseWelcomeDialog.click();
        //menuBlogs.click();
        //buttonApplyNow.click();

        //Su dung Javascript Executor de thuc thi click menu Blogs
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].click();", menuBlogs);

    }

    @Test
    public void testJavascriptExecutor02(){
        driver.get("https://cms.anhtester.com/");
        sleep(1);

        WebElement buttonCloseWelcomeDialog = driver.findElement(By.xpath("//button[@data-key='website-popup']"));
        WebElement menuBlogs = driver.findElement(By.xpath("//a[normalize-space()='Blogs']"));
        WebElement buttonViewAllCategories = driver.findElement(By.xpath("//a[normalize-space()='View All Categories']"));
        WebElement buttonApplyNow = driver.findElement(By.xpath("//a[normalize-space()='Apply Now']"));

        buttonCloseWelcomeDialog.click();

        //Su dung Javascript Executor de thuc thi click menu Blogs
        JavascriptExecutor js = (JavascriptExecutor) driver;
        WebElement inputSearch = driver.findElement(By.xpath("//input[@id='search']"));

        //Set text on input
        js.executeScript("arguments[0].setAttribute('value','Qua Tet');", inputSearch);

        sleep(4);

    }

    @Test
    public void testJavascriptExecutor03(){
        driver.get("https://cms.anhtester.com/");
        sleep(1);

        WebElement buttonCloseWelcomeDialog = driver.findElement(By.xpath("//button[@data-key='website-popup']"));
        WebElement menuBlogs = driver.findElement(By.xpath("//a[normalize-space()='Blogs']"));
        WebElement buttonViewAllCategories = driver.findElement(By.xpath("//a[normalize-space()='View All Categories']"));
        WebElement buttonApplyNow = driver.findElement(By.xpath("//a[normalize-space()='Apply Now']"));

        sleep(1);
        //Su dung Javascript Executor de thuc thi click menu Blogs
        JavascriptExecutor js = (JavascriptExecutor) driver;
        //Cuộn chuột đến vị trí Top của phần tử
        js.executeScript("arguments[0].scrollIntoView(true);", buttonViewAllCategories);
        //Cuộn chuột đến vị trí Bottom của phần tử
        js.executeScript("window.scrollTo(0,500)");
        sleep(2);

        //Tô màu viền của Element
        js.executeScript("arguments[0].style.border='3px solid blue'", buttonCloseWelcomeDialog);
        sleep(2);
        buttonCloseWelcomeDialog.click();
        sleep(2);

        js.executeScript("arguments[0].scrollIntoView(false);", buttonViewAllCategories);
        js.executeScript("arguments[0].style.border='3px solid blue'", buttonViewAllCategories);
        sleep(2);

        buttonViewAllCategories.click();

        sleep(2);

    }

}
