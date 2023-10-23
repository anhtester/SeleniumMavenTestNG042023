package com.anhtester.Bai20_ThucHanhPOM.pages;

import com.anhtester.keywords.WebUI;
import com.anhtester.locators.LocatorCRM;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.asserts.SoftAssert;

import java.time.Duration;

public class CustomerPage {
    private WebDriver driver;

    private WebDriverWait wait;

    private String headerText = "Customers Summary";

    //Customers List
    private By headerCustomerPage = By.xpath("//span[normalize-space()='Customers Summary']");
    private By buttonAddNewCustomer = By.xpath("//a[normalize-space()='New Customer']");
    private By inputSearchCustomer = By.xpath("//div[@id='DataTables_Table_0_filter']//input[@type='search']");
    private By buttonImportCustomers = By.xpath("//a[normalize-space()='Import Customers']");
    private By buttonContacts = By.xpath("//a[contains(@href,'clients/all_contacts')]");
    private By headerCustomersPage = By.xpath("//span[normalize-space()='Customers Summary']");
    private By firstItemCustomerOnTable = By.xpath("//td[@class='sorting_1']/a");
    //Add New Customer
    private By inputCompanyName = By.xpath("//input[@id='company']");
    private By inputVatNumber = By.xpath("//input[@id='vat']");
    private By inputPhone = By.xpath("//input[@id='phonenumber']");
    private By inputWebsite = By.xpath("//input[@id='website']");
    private By dropdownGroups = By.xpath("//button[@data-id='groups_in[]']");
    private By inputSearchGroup = By.xpath("//div[@app-field-wrapper='groups_in[]']//input[@type='search']");
    private By dropdownCurrency = By.xpath("//button[@data-id='default_currency']");
    private By inputSearchCurrency = By.xpath("//div[@app-field-wrapper='default_currency']//input[@type='search']");
    private By dropdownLanguage = By.xpath("//button[@data-id='default_language']");
    private By optionVietnamese = By.xpath("//span[normalize-space()='Vietnamese']");
    private By inputAddress = By.xpath("//textarea[@id='address']");
    private By inputCity = By.xpath("//input[@id='city']");
    private By inputState = By.xpath("//input[@id='state']");
    private By inputZipCode = By.xpath("//input[@id='zip']");
    private By buttonCountry = By.xpath("//button[@data-id='country']");
    private By inputSearchCountry = By.xpath("//div[@app-field-wrapper='country']//input[@type='search']");
    private By buttonSaveAndCreateContact = By.xpath("//button[normalize-space()='Save and create contact'");
    private By buttonSaveCustomer = By.xpath("//div[@id='profile-save-section']//button[normalize-space()='Save']");

    public CustomerPage(WebDriver driver){
        this.driver = driver;
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        //new WebUI(driver); //Bắt buộc khởi tạo để truyền driver vào
    }

    public void verifyHeaderCustomerPage(){
        wait.until(ExpectedConditions.visibilityOfElementLocated(headerCustomerPage));
        Assert.assertTrue(driver.findElement(headerCustomerPage).isDisplayed(), "Header Customer page not display.");
        Assert.assertEquals(driver.findElement(headerCustomerPage).getText(), headerText, "Content of header customer page not match.");
    }

    public void clickButtonAddNew(){
        driver.findElement(buttonAddNewCustomer).click();
    }

    public void inputFormData(String COMPANY_NAME){
        WebUI.setText(inputCompanyName, COMPANY_NAME);
        WebUI.setText(inputVatNumber, "10");
        WebUI.setText(inputPhone, "123456");
        WebUI.setText(inputWebsite, "https://anhtester.com");
        WebUI.clickElement(dropdownGroups);
        WebUI.sleep(1);
        WebUI.setText(inputSearchGroup, "VIP");
        WebUI.sleep(1);
        driver.findElement(inputSearchGroup).sendKeys(Keys.ENTER);
        WebUI.clickElement(dropdownGroups);
        WebUI.setText(inputAddress, "O Mon");
        WebUI.setText(inputCity, "Can Tho");
        WebUI.setText(inputState, "Can Tho");
        WebUI.setText(inputZipCode, "94000");
        WebUI.clickElement(buttonCountry);
        WebUI.sleep(1);
        WebUI.setText(inputSearchCountry, "Vietnam");
        WebUI.sleep(1);
        driver.findElement(inputSearchCountry).sendKeys(Keys.ENTER);
        WebUI.clickElement(buttonSaveCustomer);
    }

    public void searchAndVerifyCustomer(String COMPANY_NAME){
        driver.findElement(By.xpath(LocatorCRM.menuCustomers)).click();
        driver.findElement(By.xpath(LocatorCRM.inputSearchCustomers)).sendKeys(COMPANY_NAME);
        WebUI.sleep(2);
        Assert.assertTrue(WebUI.checkElementExist(firstItemCustomerOnTable), "Không tìm thấy Customer.");
    }

    public void verifyCustomerDetail(String COMPANY_NAME){
        SoftAssert softAssert = new SoftAssert();
        driver.findElement(By.xpath(LocatorCRM.firstItemCustomerOnTable)).click();
        softAssert.assertEquals(driver.findElement(inputCompanyName).getAttribute("value"), COMPANY_NAME, "Giá trị Tên Company không đúng");
        softAssert.assertEquals(driver.findElement(inputVatNumber).getAttribute("value"), "10", "Giá trị VAT không đúng");
        softAssert.assertEquals(driver.findElement(inputPhone).getAttribute("value"), "123456", "Giá trị Phone không đúng");
        softAssert.assertEquals(driver.findElement(inputWebsite).getAttribute("value"), "https://anhtester.com", "Giá trị Website không đúng");

        softAssert.assertAll();
    }

}
