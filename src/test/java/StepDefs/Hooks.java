package StepDefs;

import io.cucumber.java.AfterAll;
import io.cucumber.java.BeforeAll;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;

public class Hooks {
    // 1. WebDriver
        public static WebDriver driver;
    // 2. Open Browser
        @BeforeAll
        public static void openBrowser (){
                driver =new EdgeDriver();
                driver.manage().window().maximize();
            }
    // 3. Close Browser
//        @AfterAll
//        public static void closeBrowser (){
//            driver.quit();
//        }
}
