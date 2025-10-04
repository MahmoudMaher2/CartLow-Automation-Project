package Pages;

import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.time.Duration;
import java.util.List;
import java.util.NoSuchElementException;

public class LabtopsPage {
    // 1. WebDriver
    WebDriver driver;

    // 2. construct
    public LabtopsPage(WebDriver driver) {
        this.driver = driver;
    }

    // 3. Actions

        // Function Explicit wait
        public void explicitWait(By locator) {
            new WebDriverWait(driver, Duration.ofSeconds(10)).
                    until(ExpectedConditions.visibilityOfElementLocated(locator));
        }

        // Enter Product name in search Button
        public void searchProduct(String productName) {
            explicitWait(By.xpath("//input[@placeholder='Search products here']"));
            driver.findElement(By.xpath("//input[@placeholder='Search products here']")).sendKeys(productName + Keys.ENTER);
        }

        // Select the item: Dell Latitude 7490 Intel Core i7-8650U 14" FHD Display, 16GB RAM, 512GB SSD, Windows 10 Pro
        public void selectDellLaptop7490() {
            By dell = By.xpath("//a[contains(@href,'dell-latitude-7490-intel-core-i7-8650u-14-fhd-display-16gb-ram-512gb-ssd-windows-10-pro')]");
            try {
                explicitWait(dell);
                driver.findElement(dell).click();
            } catch (TimeoutException e) {
                searchProduct("Dell Latitude 7490 Intel Core i7-8650U 14\" FHD Display, 16GB RAM, 512GB SSD, Windows 10 Pro");
                explicitWait(dell);
                driver.findElement(dell).click();
            }
        }

        // Click Add To Cart
        public void clickAddToCart() {
            By addToCartLocator = By.xpath("//button[normalize-space()='Add To Cart']");
            explicitWait(addToCartLocator);
            WebElement addToCartBtn = driver.findElement(addToCartLocator);
            ((JavascriptExecutor) driver).executeScript("arguments[0].click();", addToCartBtn);
        }

        // Validate Add to Cart Message
        public void validateItemAddedMessageAndCounter() {
            explicitWait(By.xpath("//p[contains(text(),'Item Added Successfully')]"));
            // make Sure the message appear
            Assert.assertTrue(driver.findElement(By.xpath("//p[contains(text(),'Item Added Successfully')]")).isDisplayed());
            // make Sure the message is  "Item Added Successfully"
            Assert.assertTrue(driver.findElement(By.xpath("//p[contains(text(),'Item Added Successfully')]"))
                    .getText().contains("Item Added Successfully"));
        }

        // make Sure the cart numbers
            public void validateCartNumber (int expectedCount){
                Assert.assertEquals(
                        driver.findElement(By.xpath("//span[@class='absolute -top-4 rounded-[44px] bg-navyBlue px-2 py-1.5 text-xs font-semibold leading-[9px] text-white ltr:left-5 max-md:ltr:left-4 rtl:right-5 max-md:rtl:right-4']")).getText(),
                        String.valueOf(expectedCount));
            }

        // Click On Smartwatches Tab
        public void clickSmartWatchesButton (){
            explicitWait(By.xpath("//a[@href='/smartwatches']"));
            driver.findElement(By.xpath("//a[@href='/smartwatches']")).click();
        }

}