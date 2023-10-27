package com.anhtester.Bai20_ThucHanhPOM.testcases;

import com.anhtester.Bai20_ThucHanhPOM.pages.DashboardPage;
import com.anhtester.Bai20_ThucHanhPOM.pages.LoginPage;
import com.anhtester.common.BaseTest;
import com.anhtester.keywords.WebUI;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class LoginTest extends BaseTest {

    LoginPage loginPage;
    DashboardPage dashboardPage;

    @Test
    @Parameters({"email", "password"})
    public void testLoginSuccess(String email, String password) {
        loginPage = new LoginPage(driver);
        dashboardPage = loginPage.loginCRM(email, password);
        waitForPageLoaded();
        loginPage.verifyLoginSuccess();
        WebUI.captureScreenImage("testLoginSuccess");
        dashboardPage.logOut();
    }

    @Test
    public void testLoginWithEmailInvalid() {
        loginPage = new LoginPage(driver);
        dashboardPage = loginPage.loginCRM("admin123@example.com", "123456");
        waitForPageLoaded();
        loginPage.verifyLoginFail();
        WebUI.captureScreenImage("testLoginWithEmailInvalid");
    }

    @Test
    public void testLoginWithPasswordInvalid() {
        loginPage = new LoginPage(driver);
        dashboardPage = loginPage.loginCRM("admin@example.com", "123");
        waitForPageLoaded();
        loginPage.verifyLoginFail();
        WebUI.captureScreenImage("testLoginWithPasswordInvalid");
    }
}
