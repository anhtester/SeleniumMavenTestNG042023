package com.anhtester.Bai19_NavigationPage.testcases;

import com.anhtester.Bai19_NavigationPage.pages.CustomerPage;
import com.anhtester.Bai19_NavigationPage.pages.DashboardPage;
import com.anhtester.Bai19_NavigationPage.pages.LoginPage;
import com.anhtester.common.BaseTest;
import org.testng.annotations.Test;

public class DashboardTest extends BaseTest {

    LoginPage loginPage;
    DashboardPage dashboardPage;
    CustomerPage customerPage;

    @Test
    public void testOpenCustomerPage(){
        //Login
        loginPage = new LoginPage(driver);
        dashboardPage = loginPage.loginCRM("admin@example.com", "123456"); //Xảy ra chuyển trang

        dashboardPage.clickMenuDashboard();

        //Click menu Customer
        customerPage = dashboardPage.clickMenuCustomers(); //Xảy ra chuyển trang

        //Chuyển sang trang Customer
        customerPage.clickButtonAddNew();
    }

}
