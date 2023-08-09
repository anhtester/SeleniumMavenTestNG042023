package com.anhtester.Bai10_Annotations;

import com.anhtester.common.BaseTest;
import org.openqa.selenium.By;
import org.testng.annotations.Test;

public class CheckCustomerAndProject extends BaseTest {

    //Mở Browser mỗi lần
    @Test(priority = 1)
    public void testCustomerAndProject() {
        //Login

        //Add Customer
        //new CustomerTest().testAddCustomer();//Test case
        new CustomerTest().testAddCustomerFlow();//Hàm thường - Gọi từ Pages class

        //Add Project

        //Search Project
    }

    //Mở Browser mỗi lần
    @Test(priority = 2)
    public void testProjectAndTask() {
        //Login

        //Add Task

        //Add Project

        //Search Project
    }
}
