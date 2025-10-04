package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class CartPage {

    // 1. WebDriver
    WebDriver driver;

    // 2. construct
    public CartPage(WebDriver driver) {
        this.driver = driver;
    }

    // 3. Actions

    // Function Explicit wait
    public void explicitWait(By locator) {
        new WebDriverWait(driver, Duration.ofSeconds(10)).
                until(ExpectedConditions.elementToBeClickable(locator));
    }

    // Remove product
    public void clickRemoveFor(String productName) {
        By removeSpecific = By.xpath(
                "//p[contains(normalize-space(),'" + productName + "')]" +
                        "/ancestor::div[contains(@class,'main-A')]" +
                        "//span[contains(normalize-space(),'Remove')]"
        );
        explicitWait(removeSpecific);
        driver.findElement(removeSpecific).click();
    }

    // confirm Remove
    public void confirmRemove() {
        explicitWait(By.xpath("//button[normalize-space()='Agree']"));
        driver.findElement(By.xpath("//button[normalize-space()='Agree']")).click();
    }

    // Click on Checout Button
    public void clickCheckout() {
        explicitWait(By.xpath("//a[normalize-space()='Checkout']"));
        driver.findElement(By.xpath("//a[normalize-space()='Checkout']")).click();
    }

}
