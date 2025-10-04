package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.support.ui.ExpectedConditions;


import java.time.Duration;

public class LoginPage {
    // 1. WebDriver
        WebDriver driver;

    // 2. construct
        public LoginPage(WebDriver driver) {
            this.driver = driver;
        }

    // 3. Actions

        // Function Explicit wait
        public void explicitWait (By locator){
            new WebDriverWait(driver,Duration.ofSeconds(5)).
                    until(ExpectedConditions.visibilityOfElementLocated(locator));
        }

        // Enter Email or Phone Number
        public void enterEmailorNumber (String email){
            explicitWait(By.id("identifier"));
            driver.findElement(By.id("identifier")).sendKeys(email);
        }

    // click continue / sign in button
        public void clickSigninButton () {
            driver.findElement(By.xpath("//button[@type='submit']")).click();
        }

        // enter password
        public void enterPassword (String password) {
            explicitWait(By.id("password"));
            driver.findElement(By.id("password")).sendKeys(password);
        }





}
