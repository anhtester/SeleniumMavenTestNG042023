package com.anhtester.Bai20_ThucHanhPOM.testcases;

import com.anhtester.Bai20_ThucHanhPOM.pages.CustomerPage;
import com.anhtester.Bai20_ThucHanhPOM.pages.DashboardPage;
import com.anhtester.Bai20_ThucHanhPOM.pages.LoginPage;
import com.anhtester.common.BaseTest;
import com.anhtester.constants.ConfigData;
import org.testng.annotations.Test;

public class DashboardTest extends BaseTest {

    LoginPage loginPage;
    DashboardPage dashboardPage;
    CustomerPage customerPage;

    @Test
    public void testOpenCustomerPage(){
        //Login
        loginPage = new LoginPage(driver);
        dashboardPage = loginPage.loginCRM(ConfigData.EMAIL, ConfigData.PASSWORD);
        loginPage.verifyLoginSuccess();

        //Click menu Customer
        customerPage = dashboardPage.clickMenuCustomers();
        customerPage.verifyHeaderCustomerPage();

    }

    @Test
    public void testAdminRole(){
        loginPage = new LoginPage(driver);
        dashboardPage = loginPage.loginCRM("admin@example.com", "123456");
        loginPage.verifyLoginSuccess();
        dashboardPage.verifyMenuReportDisplay();
    }

    @Test
    public void testProjectRole(){
        loginPage = new LoginPage(driver);
        dashboardPage = loginPage.loginCRM("project@example.com", "123456");
        loginPage.verifyLoginSuccess();
        dashboardPage.verifyMenuReportNotDisplay();
    }

}
