package com.anhtester.Bai20_ThucHanhPOM.pages;

import com.anhtester.constants.ConfigData;
import com.anhtester.keywords.WebUI;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.time.Duration;

public class LoginPage {
    //Khai báo driver cục bộ trong chính class này
    private WebDriver driver;
    private WebDriverWait wait;

    //Khai báo các element dạng đối tượng By (phương thức tìm kiếm)
    private By headerPage = By.xpath("//h1[normalize-space()='Login']");
    private By inputEmail = By.xpath("//input[@id='email']");
    private By inputPassword = By.xpath("//input[@id='password']");
    private By buttonLogin = By.xpath("//button[normalize-space()='Login']");
    private By errorMessage = By.xpath("//div[@id='alerts']");

    //Khai báo hàm xây dựng, để truyền driver từ bên ngoài vào chính class này sử dụng
    public LoginPage(WebDriver driver) {
        this.driver = driver;
        //driver = _driver;
        wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        new WebUI(driver); //Bắt buộc
    }

    private void setEmail(String email) {
        WebUI.setText(inputEmail, email);
    }

    private void setPassword(String password) {
        WebUI.setText(inputPassword,password);
    }

    private void clickLoginButton() {
        WebUI.clickElement(buttonLogin);
    }

    public void verifyLoginSuccess(){
        Assert.assertFalse(driver.getCurrentUrl().contains("authentication"), "FAIL. Vẫn đang ở trang Login");
    }

    public void verifyLoginFail(){
        Assert.assertTrue(driver.getCurrentUrl().contains("authentication"), "FAIL. Không còn ở trang Login");
        Assert.assertTrue(driver.findElement(errorMessage).isDisplayed(), "Error message NOT displays");
        Assert.assertEquals(WebUI.getElementText(errorMessage), "Invalid email or password", "Content of error massage NOT match.");
    }

    //Các hàm xử lý cho chính trang này
    public DashboardPage loginCRM(String email, String password) {
        WebUI.openURL(ConfigData.URL);
        WebUI.waitForPageLoaded();
        setEmail(email);
        setPassword(password);
        clickLoginButton();

        return new DashboardPage(driver);
    }
}
