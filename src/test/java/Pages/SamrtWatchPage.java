package Pages;

import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.time.Duration;

public class SamrtWatchPage {

    // 1. WebDriver
    WebDriver driver;

    // 2. construct
    public SamrtWatchPage(WebDriver driver) {
        this.driver = driver;
    }

    // 3. Actions

        // Function Explicit wait
        public void explicitWait(By locator) {
            new WebDriverWait(driver, Duration.ofSeconds(10)).
                    until(ExpectedConditions.elementToBeClickable(locator));
        }

        // Enter Product name in search Button
        public void searchProduct(String productName) {
            explicitWait(By.xpath("//input[@placeholder='Search products here']"));
            driver.findElement(By.xpath("//input[@placeholder='Search products here']")).sendKeys(productName + Keys.ENTER);
        }


        // Select the item: Apple Watch Series 6 (40mm, GPS + Cellular) Gold Aluminum Case with Pink Sand Sport Band
        public void selectAppleWatchSeries6() {
            By appleWatch = By.xpath("//a[contains(@href,'apple-watch-series-6-40mm-gps-cellular-gold-aluminum-case-with-pink-sand-sport-band')]");
            try {
                explicitWait(appleWatch);
                ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true); arguments[0].click();",
                        driver.findElement(appleWatch));

            } catch (TimeoutException e) {
                searchProduct("Apple Watch Series 6 (40mm, GPS + Cellular) Gold Aluminum Case with Pink Sand Sport Band");
                explicitWait(appleWatch);
                ((JavascriptExecutor) driver).executeScript("arguments[0].click();",
                        driver.findElement(appleWatch));
            }
        }

        // Select Apple Watch Options: Connectivity = GPS And Cellular, Color = Silver, Size = 44mm
        public void selectAppleWatchOptions() {
            // Locators
            By connectivity = By.xpath("//label[@title='GPS And Cellular']//input");
            By colorSilver = By.xpath("//label[@title='Silver']//input");
            By size44mm = By.xpath("//label[@title='44mm']//input");

            // Select Connectivity
            explicitWait(connectivity);
            ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true); arguments[0].click();",
                    driver.findElement(connectivity));

            // Select Color (Silver)
            explicitWait(colorSilver);
            ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true); arguments[0].click();",
                    driver.findElement(colorSilver));

            // Select Size (44mm)
            explicitWait(size44mm);
            ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true); arguments[0].click();",
                    driver.findElement(size44mm));

        }

        // Add 2 items to the cart.
        public void setQuantity(int targetQty) {
            By plusBtnLocator = By.xpath("//span[@aria-label='Increase Quantity']");
            By qtyTextLocator = By.xpath("//div[@class='flex items-center border border-navyBlue gap-x-4 rounded-xl px-7 py-3 max-md:py-3 max-sm:gap-x-3 max-sm:rounded-lg max-sm:px-4 max-sm:py-1.5']/p");

            int currentQty = Integer.parseInt(driver.findElement(qtyTextLocator).getText());

            while(currentQty < targetQty) {
                WebElement plusBtn = driver.findElement(plusBtnLocator);
                ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", plusBtn);
                ((JavascriptExecutor) driver).executeScript("arguments[0].click();", plusBtn);
                new WebDriverWait(driver, Duration.ofSeconds(5))
                        .until(ExpectedConditions.not(
                                ExpectedConditions.textToBe(qtyTextLocator, String.valueOf(currentQty))
                        ));
                currentQty = Integer.parseInt(driver.findElement(qtyTextLocator).getText());
            }
        }

        // click View Cart
        public void clickViewCart() {
            explicitWait(By.xpath("//a[@title='View Cart']"));
            driver.findElement(By.xpath("//a[@title='View Cart']")).click();
        }



}
