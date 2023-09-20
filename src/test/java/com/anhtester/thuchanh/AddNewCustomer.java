package com.anhtester.thuchanh;

import com.anhtester.common.BaseTest;
import com.anhtester.keywords.ActionKeywords;
import com.anhtester.locators.LocatorCRM;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import java.time.Duration;

public class AddNewCustomer extends BaseTest {

    String COMPANY_NAME = "Selenium Java 04/2023 A6";

    public void loginCRM() {
        driver.get("https://crm.anhtester.com/admin/authentication");
        Assert.assertTrue(driver.findElement(By.xpath(LocatorCRM.headerLoginPage)).isDisplayed(), "Header không tồn tại, không phải trang Login");
//        driver.findElement(By.xpath(LocatorCRM.inputEmail)).sendKeys("admin@example.com");
//        driver.findElement(By.xpath(LocatorCRM.inputPassword)).sendKeys("123456");
//        driver.findElement(By.xpath(LocatorCRM.buttonLogin)).click();
        setText(LocatorCRM.inputEmail, "admin@example.com");
        setText(LocatorCRM.inputPassword, "123456");
        clickElement(LocatorCRM.buttonLogin);
        sleep(1);
        Assert.assertTrue(driver.findElement(By.xpath(LocatorCRM.menuDashboard)).isDisplayed(), "Không đến được trang Dashboard.");
    }

    @Test(priority = 1)
    public void testAddNewCustomer() {

        //Khởi tạo đối tượng class cho ActionKeywords để nhận giá trị driver
        new ActionKeywords(driver);

        loginCRM();

        driver.findElement(By.xpath(LocatorCRM.menuCustomers)).click();
        Assert.assertTrue(driver.findElement(By.xpath(LocatorCRM.headerCustomersPage)).isDisplayed(), "Không đến được trang Customer.");
        Assert.assertEquals(driver.findElement(By.xpath(LocatorCRM.headerCustomersPage)).getText(), "Customers Summary", "Tên header Customer page không đúng.");
        sleep(1);
        driver.findElement(By.xpath(LocatorCRM.buttonAddNewCustomer)).click();

        //Add New Customer
        driver.findElement(By.xpath(LocatorCRM.inputCompanyName)).sendKeys(COMPANY_NAME);
        driver.findElement(By.xpath(LocatorCRM.inputVatNumber)).sendKeys("10");
        driver.findElement(By.xpath(LocatorCRM.inputPhone)).sendKeys("123456");
        driver.findElement(By.xpath(LocatorCRM.inputWebsite)).sendKeys("https://anhtester.com");
        driver.findElement(By.xpath(LocatorCRM.dropdownGroups)).click();
        sleep(1);
        driver.findElement(By.xpath(LocatorCRM.inputSearchGroup)).sendKeys("VIP");
        sleep(1);
        driver.findElement(By.xpath(LocatorCRM.inputSearchGroup)).sendKeys(Keys.ENTER);
        driver.findElement(By.xpath(LocatorCRM.dropdownGroups)).click();
        driver.findElement(By.xpath(LocatorCRM.inputAddress)).sendKeys("O Mon");
        driver.findElement(By.xpath(LocatorCRM.inputCity)).sendKeys("Can Tho");
        driver.findElement(By.xpath(LocatorCRM.inputState)).sendKeys("Can Tho");
        driver.findElement(By.xpath(LocatorCRM.inputZipCode)).sendKeys("94000");
        driver.findElement(By.xpath(LocatorCRM.buttonCountry)).click();
        sleep(1);
        driver.findElement(By.xpath(LocatorCRM.inputSearchCountry)).sendKeys("Vietnam");
        sleep(1);
        driver.findElement(By.xpath(LocatorCRM.inputSearchCountry)).sendKeys(Keys.ENTER);
        driver.findElement(By.xpath(LocatorCRM.buttonSaveCustomer)).click(); //Lưu FORM add new
        sleep(3);
        //Search lại Customer vừa Add New
        driver.findElement(By.xpath(LocatorCRM.menuCustomers)).click();
        driver.findElement(By.xpath(LocatorCRM.inputSearchCustomers)).sendKeys(COMPANY_NAME);
        sleep(2);
        Assert.assertTrue(driver.findElement(By.xpath(LocatorCRM.firstItemCustomerOnTable)).isDisplayed(), "Không tìm thấy Customer.");

        //Kiểm tra giá trị sau khi Add New
        SoftAssert softAssert = new SoftAssert();
        driver.findElement(By.xpath(LocatorCRM.firstItemCustomerOnTable)).click();
        softAssert.assertEquals(driver.findElement(By.xpath(LocatorCRM.inputCompanyName)).getAttribute("value"), COMPANY_NAME, "Giá trị Tên Company không đúng");
        softAssert.assertEquals(driver.findElement(By.xpath(LocatorCRM.inputVatNumber)).getAttribute("value"), "100", "Giá trị VAT không đúng");
        softAssert.assertEquals(driver.findElement(By.xpath(LocatorCRM.inputPhone)).getAttribute("value"), "123456789", "Giá trị Phone không đúng");
        softAssert.assertEquals(driver.findElement(By.xpath(LocatorCRM.inputWebsite)).getAttribute("value"), "https://anhtester.com", "Giá trị Website không đúng");

        softAssert.assertAll();

    }

    @Test(priority = 2)
    public void testAddNewContactForCustomer() {
        loginCRM();
        driver.findElement(By.xpath(LocatorCRM.menuCustomers)).click();
        Assert.assertTrue(driver.findElement(By.xpath(LocatorCRM.headerCustomersPage)).isDisplayed(), "Không đến được trang Customer.");
        Assert.assertEquals(driver.findElement(By.xpath(LocatorCRM.headerCustomersPage)).getText(), "Customers Summary", "Tên header Customer page không đúng.");
        sleep(1);
        //Search lại Customer vừa Add New
        driver.findElement(By.xpath(LocatorCRM.menuCustomers)).click();
        sleep(1);
        driver.findElement(By.xpath(LocatorCRM.inputSearchCustomers)).sendKeys(COMPANY_NAME);
        sleep(2);
        Assert.assertTrue(driver.findElement(By.xpath(LocatorCRM.firstItemCustomerOnTable)).isDisplayed(), "Không tìm thấy Customer.");
        driver.findElement(By.xpath(LocatorCRM.firstItemCustomerOnTable)).click();
        driver.findElement(By.xpath(LocatorCRM.menuContacts)).click();
        sleep(1);
        Assert.assertTrue(driver.findElement(By.xpath(LocatorCRM.headerContactPage)).isDisplayed(), "Không tìm thấy trang Contact.");
        driver.findElement(By.xpath(LocatorCRM.buttonAddNewContact)).click();
        sleep(2);
        Assert.assertTrue(driver.findElement(By.xpath(LocatorCRM.headerAddNewContactDialog)).isDisplayed(), "Không tìm thấy dialog Add New Contact.");
        sleep(1);
        //Upload file for Profile image
        driver.findElement(By.xpath(LocatorCRM.inputProfileImage)).sendKeys(System.getProperty("user.dir") + "\\src\\test\\resources\\datatest\\profile_contact.png");
        sleep(2);
    }
}
