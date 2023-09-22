package com.anhtester.Bai16_ThucHanhCRM;

import com.anhtester.common.BaseTest;
import com.anhtester.locators.LocatorCRM;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;

public class LoginTest extends BaseTest {

    @Test
    public void testLoginSuccess() {
        driver.get(InfoCRM.URL);
        waitForPageLoaded();
        setText(LocatorCRM.inputEmail, InfoCRM.EMAIL);
        setText(LocatorCRM.inputPassword, InfoCRM.PASSWORD);
        clickElement(LocatorCRM.buttonLogin);
        waitForPageLoaded();
        boolean checkURLNotAuthen = driver.getCurrentUrl().contains("authentication");
        Assert.assertFalse(checkURLNotAuthen);
        boolean checkURLContainsDashboard = driver.getCurrentUrl().contains("admin");
        Assert.assertTrue(checkURLContainsDashboard);
        Assert.assertTrue(driver.findElement(By.xpath(LocatorCRM.menuDashboard)).isDisplayed(), "Không đến được trang Dashboard.");
    }

    @Test
    public void testLoginWithEmailInvalid() {
        driver.get(InfoCRM.URL);
        waitForPageLoaded();
        setText(LocatorCRM.inputEmail, "admin123@example.com");
        setText(LocatorCRM.inputPassword, "123456");
        clickElement(LocatorCRM.buttonLogin);
        waitForPageLoaded();

        boolean checkURLNotAuthen = driver.getCurrentUrl().contains("authentication");
        Assert.assertTrue(checkURLNotAuthen);
        Assert.assertTrue(checkElementExist(LocatorCRM.alertMessage), "Fail. Alert message displayed.");
        Assert.assertEquals(getTextElement(LocatorCRM.alertMessage), "Invalid email or password");

        Assert.assertFalse(checkElementExist(LocatorCRM.menuDashboard), "Fail. Đến được trang Dashboard.");
        //Assert.assertTrue(driver.findElements(By.xpath(LocatorCRM.menuDashboard)).size() > 0, "Không đến được trang Dashboard.");
    }

    @Test
    public void testLoginWithPasswordInvalid() {
        driver.get(InfoCRM.URL);
        waitForPageLoaded();
        setText(LocatorCRM.inputEmail, "admin@example.com");
        setText(LocatorCRM.inputPassword, "123");
        clickElement(LocatorCRM.buttonLogin);
        waitForPageLoaded();

        //Hiện error message
        //Không đến được trang Dashboard
        //Vẫn còn ở lại trang login
        //URL chứa từ khoá authentication

        boolean checkURLNotAuthen = driver.getCurrentUrl().contains("authentication");
        Assert.assertTrue(checkURLNotAuthen);
        Assert.assertTrue(checkElementExist(LocatorCRM.alertMessage), "Fail. Alert message displayed.");
        Assert.assertEquals(getTextElement(LocatorCRM.alertMessage), "Invalid email or password");

        Assert.assertFalse(checkElementExist(LocatorCRM.menuDashboard), "Fail. Đến được trang Dashboard.");
        Assert.assertTrue(checkElementExist(LocatorCRM.headerLoginPage), "Fail. Không ở lại trang Login.");
    }

}
