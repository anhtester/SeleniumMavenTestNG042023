package com.anhtester.Bai20_ThucHanhPOM.testcases;

import com.anhtester.Bai20_ThucHanhPOM.pages.DashboardPage;
import com.anhtester.Bai20_ThucHanhPOM.pages.LoginPage;
import com.anhtester.common.BaseTest;
import org.testng.annotations.Test;

public class LoginTest extends BaseTest {

    LoginPage loginPage;
    DashboardPage dashboardPage;

    @Test
    public void testLoginSuccess() {
        loginPage = new LoginPage(driver);
        dashboardPage = loginPage.loginCRM("admin@example.com", "123456");
        waitForPageLoaded();
        loginPage.verifyLoginSuccess();
        dashboardPage.logOut();
    }

    @Test
    public void testLoginWithEmailInvalid() {
        loginPage = new LoginPage(driver);
        dashboardPage = loginPage.loginCRM("admin123@example.com", "123456");
        waitForPageLoaded();
        loginPage.verifyLoginFail();
    }

    @Test
    public void testLoginWithPasswordInvalid() {
        loginPage = new LoginPage(driver);
        dashboardPage = loginPage.loginCRM("admin@example.com", "123");
        waitForPageLoaded();
        loginPage.verifyLoginFail();
    }
}
