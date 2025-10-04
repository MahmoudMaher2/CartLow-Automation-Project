package Pages;

import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.time.Duration;

public class HomePage {
    // 1. WebDriver
        WebDriver driver;

    // 2. construct
        public HomePage(WebDriver driver) {
            this.driver = driver;
        }

    // 3. Actions

        // Function Explicit wait
        public void explicitWait (By locator){
            new WebDriverWait(driver, Duration.ofSeconds(10)).
                    until(ExpectedConditions.visibilityOfElementLocated(locator));
        }

        // Navigate CartLow Website
        public void navigateWebsite (){
           driver.navigate().to("https://cartlow.com/intl/en");
//            driver.navigate().to("https://cartlow.com/uae/en");
        }

        // Login Button
        public void clickLoginButton (){
            driver.findElement(By.xpath("(//span[@class='flex items-center gap-1 cursor-pointer ltr:font-medium rtl:font-semibold group-hover:text-primary'])[1]")).click();
            driver.findElement(By.xpath("(//a[@class='text-xs lg:text-sm cursor-pointer text-center flex items-center p-2 justify-center bg-transparent text-gray-500 border border-gray-300 hover:bg-accent hover:text-white transition-all w-full rounded-md'][normalize-space()='Sign In'])[1]")).click();
        }

        // Click on homepage (Logo)
        public void openHomePage (){
            explicitWait(By.xpath("//a[contains(@class,'navbar-brand')]"));
            driver.findElement(By.xpath("//a[contains(@class,'navbar-brand')]")).click();
        }

        // Change Country
        public void changeCountry (String countryOld , String countryNew){
            explicitWait(By.xpath("//button[normalize-space()='" + countryOld + "']"));
            driver.findElement(By.xpath("//button[normalize-space()='" + countryOld + "']")).click();
            explicitWait(By.xpath("//button[normalize-space()='" + countryNew + "']"));
            WebElement newCountry = driver.findElement(By.xpath("//button[normalize-space()='" + countryNew + "']"));
            try {
                newCountry.click();
            } catch (ElementClickInterceptedException e) {
                ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", newCountry);
                ((JavascriptExecutor) driver).executeScript("arguments[0].click();", newCountry);
            }
        }

        // Click On Laptop Tab
        public void clickLaptopButton (){
            explicitWait(By.xpath("//a[normalize-space()='Laptops']"));
            driver.findElement(By.xpath("//a[normalize-space()='Laptops']")).click();
        }


}
