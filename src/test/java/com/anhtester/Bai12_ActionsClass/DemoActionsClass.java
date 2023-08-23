package com.anhtester.Bai12_ActionsClass;

import com.anhtester.common.BaseTest;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

public class DemoActionsClass extends BaseTest {
    @Test
    public void TestPressEnterKey() {
        driver.get("https://www.google.com/");
        WebElement element = driver.findElement(By.xpath("//textarea[@name='q']"));
        // Tạo đối tượng của Actions class và để driver vào
        Actions action = new Actions(driver);

        // Dùng action để gọi hàm sendkeys điền dữ liệu. Không dùng sendKeys của WebElement
        action.sendKeys(element, "Anh Tester").build().perform();
        sleep(2000);
        action.sendKeys(Keys.ENTER).build().perform();

        sleep(2000);
    }
}











