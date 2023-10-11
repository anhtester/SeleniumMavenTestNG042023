package com.anhtester.Bai19_NavigationPage.testcases;

import com.anhtester.Bai19_NavigationPage.pages.DashboardPage;
import com.anhtester.Bai19_NavigationPage.pages.LoginPage;
import com.anhtester.common.BaseTest;
import org.testng.annotations.Test;

public class LoginTest extends BaseTest {

    LoginPage loginPage;
    DashboardPage dashboardPage;

    @Test
    public void testLoginSuccess() {
        loginPage = new LoginPage(driver);

        dashboardPage = loginPage.loginCRM("admin@example.com", "123456"); //Xảy ra chuyển trang

        waitForPageLoaded(); //Khi chuyển trang mới dùng (load trang)
        loginPage.verifyLoginSuccess();

        //Logout từ trang Dashboard
        dashboardPage.logOut();
    }
}
