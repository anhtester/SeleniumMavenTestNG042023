package com.anhtester.Bai13_Alert_PopupWindow_Iframe;

import com.anhtester.common.BaseTest;
import org.openqa.selenium.By;
import org.testng.annotations.Test;

public class HandleIFrame extends BaseTest {

    @Test
    public void iFrame01() throws InterruptedException {

        driver.navigate().to("https://anhtester.com/contact");
        Thread.sleep(10000);
        System.out.println("iframe total: " + driver.findElements(By.tagName("iframe")).size());
        Thread.sleep(1000);
        //----Switch to content of Messenger--------
        driver.switchTo().frame(0); //IFrame đầu tiên
        System.out.println(driver.findElement(By.tagName("strong")).getText());

        //----Switch to icon of Messenger---------

        //1. Switch to Parent WindowHandle
        driver.switchTo().parentFrame(); //Trở về cái content chính (thông thuộc iframe nào cả)

        //2. Switch to iframe icon of Messenger
        driver.switchTo().frame(1);
        driver.findElement(By.tagName("svg")).click(); //Nhấn icon để ẩn messenger chat đi

        driver.switchTo().parentFrame();
        Thread.sleep(2000);
    }

    @Test
    public void testIFrameOnVNExpress(){
        driver.get("https://vnexpress.net/");
        sleep(6);
        driver.switchTo().frame(driver.findElement(By.xpath("//iframe[@id='google_ads_iframe_/27973503/Vnexpress/Desktop/Masthead/Home_0']")));
        int div = driver.findElements(By.xpath("(//div[contains(@id,'genecy_ifr_')])")).size();
        System.out.println(div);
        driver.findElement(By.xpath("(//div[contains(@id,'genecy_ifr_')])")).click();
        sleep(2);
    }

}
