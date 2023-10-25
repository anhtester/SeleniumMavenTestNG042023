package com.anhtester.Bai20_ThucHanhPOM.testcases;

import com.anhtester.Bai20_ThucHanhPOM.pages.CustomerPage;
import com.anhtester.Bai20_ThucHanhPOM.pages.DashboardPage;
import com.anhtester.Bai20_ThucHanhPOM.pages.LoginPage;
import com.anhtester.common.BaseTest;
import com.anhtester.constants.ConfigData;
import org.testng.annotations.Test;

public class CustomerTest extends BaseTest {

    LoginPage loginPage;
    DashboardPage dashboardPage;
    CustomerPage customerPage;

    @Test
    public void testAddNewCustomer(){
        loginPage = new LoginPage(driver);
        dashboardPage = loginPage.loginCRM(ConfigData.EMAIL, ConfigData.PASSWORD);
        loginPage.verifyLoginSuccess();

        customerPage = dashboardPage.clickMenuCustomers();
        customerPage.verifyHeaderCustomerPage();

        customerPage.clickButtonAddNew();

        String CUSTOMER_NAME = "FPT Software A6";
        customerPage.inputFormData(CUSTOMER_NAME); //Add new and Save
        customerPage.searchAndVerifyCustomer(CUSTOMER_NAME); //Search and Verify on table
        customerPage.verifyCustomerDetail(CUSTOMER_NAME); //Verify Detail

    }
}
