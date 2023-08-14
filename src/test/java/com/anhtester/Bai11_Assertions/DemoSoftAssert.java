package com.anhtester.Bai11_Assertions;

import com.anhtester.common.BaseTest;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class DemoSoftAssert extends BaseTest {

//    SoftAssert softAssert = new SoftAssert();
//    @AfterClass
//    public void assertAllCases(){
//        softAssert.assertAll();
//    }

    @Test
    public void testLoginCRM() {
        driver.get("https://crm.anhtester.com/admin/authentication");

        //Khai báo đối tượng SoftAssert
        SoftAssert softAssert = new SoftAssert();

        //Assert cái header với cái text của nó
        String header = driver.findElement(By.xpath("//h1[normalize-space()='Login']")).getText();
        System.out.println(header);
        softAssert.assertEquals(header, "Login123", "Giá trị header sai."); //So sánh BẰNG

        boolean checkButtonLogin = driver.findElement(By.xpath("//button[normalize-space()='Login']")).isEnabled();
        softAssert.assertTrue(checkButtonLogin, "Nút Login không được bật");

        driver.findElement(By.xpath("//input[@id='email']")).sendKeys("admin@example.com");
        driver.findElement(By.xpath("//input[@id='password']")).sendKeys("123456");
        driver.findElement(By.xpath("//button[normalize-space()='Login']")).click();
        sleep(1);
        String menuName = driver.findElement(By.xpath("//span[normalize-space()='Customers']")).getText();
        softAssert.assertTrue(menuName.contains("Customer123"), "Giá trị Menu Name không chứa giá trị mong muốn: " + menuName); //So sánh CHỨA. Thông qua Java

        softAssert.assertAll(); //Tổng kết lại tất cả các trường hợp Fail
    }

    @Test
    public void testLoginCRM2() {
        driver.get("https://crm.anhtester.com/admin/authentication");

        //Khai báo đối tượng SoftAssert
        SoftAssert softAssert = new SoftAssert();

        //Assert cái header với cái text của nó
        String header = driver.findElement(By.xpath("//h1[normalize-space()='Login']")).getText();
        System.out.println(header);
        softAssert.assertEquals(header, "Login123", "Giá trị header sai."); //So sánh BẰNG

        boolean checkButtonLogin = driver.findElement(By.xpath("//button[normalize-space()='Login']")).isEnabled();
        softAssert.assertTrue(checkButtonLogin, "Nút Login không được bật");

        driver.findElement(By.xpath("//input[@id='email']")).sendKeys("admin@example.com");
        driver.findElement(By.xpath("//input[@id='password']")).sendKeys("123456");
        driver.findElement(By.xpath("//button[normalize-space()='Login']")).click();
        sleep(1);
        String menuName = driver.findElement(By.xpath("//span[normalize-space()='Customers']")).getText();
        softAssert.assertTrue(menuName.contains("Customer123"), "Giá trị Menu Name không chứa giá trị mong muốn: " + menuName); //So sánh CHỨA. Thông qua Java

        softAssert.assertAll(); //Tổng kết lại tất cả các trường hợp Fail
    }
}
