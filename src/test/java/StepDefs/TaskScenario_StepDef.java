package StepDefs;

import Pages.*;
import io.cucumber.java.PendingException;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class TaskScenario_StepDef {
    // 1. Pages
        HomePage        homePage_object;
        LoginPage       loginPage_Object;
        LabtopsPage     labtopsPage_object;
        SamrtWatchPage  samrtWatchPage_object;
        CartPage        cartPage_object;

    // 2. Constractor of definition pages
        public TaskScenario_StepDef() {
        homePage_object         = new HomePage(Hooks.driver);
        loginPage_Object        = new LoginPage(Hooks.driver);
        labtopsPage_object      = new LabtopsPage(Hooks.driver);
        samrtWatchPage_object   = new SamrtWatchPage(Hooks.driver);
        cartPage_object         = new CartPage(Hooks.driver);
    }

    // 3. Steps
        @Given("User Navigate To Cartlow Website")
        public void UserNavigateToCartlowWebsite () {
            homePage_object.navigateWebsite();
    }

        @When("User Login with email {string} and password {string}")
        public void userLoginWithEmailAndPassword(String email, String password) {
            homePage_object.clickLoginButton();
            loginPage_Object.enterEmailorNumber(email);
            loginPage_Object.clickSigninButton();
            loginPage_Object.enterPassword(password);
            loginPage_Object.clickSigninButton();
        }

        @And("User Opens Home Page and switches country from {string} to {string}")
        public void userOpensHomePageAndSwitchesCountryFromTo(String Current, String New) {
            homePage_object.openHomePage();
            homePage_object.changeCountry(Current,New);
        }

        @When("User Change Country From {string} to {string}")
        public void userChangeCountryFromTo(String Current, String New) {
            homePage_object.changeCountry(Current,New);
        }

        @When("User Opens Laptops Page and Select item Dell Latitude 7490 Then add to cart")
        public void userOpensLaptopsPageAndSelectItemDellLatitude7490ThenAddToCart() {
            homePage_object.clickLaptopButton();
            labtopsPage_object.selectDellLaptop7490();
            labtopsPage_object.clickAddToCart();
            labtopsPage_object.validateItemAddedMessageAndCounter();
            labtopsPage_object.validateCartNumber(1);
        }

        @And("User Opens the SmartWatches page and adds 2 Apple Watch Series 6 items to the cart")
        public void UserOpenstheSmartWatchespageandadds2AppleWatchSeries6itemstothecart() {
            labtopsPage_object.clickSmartWatchesButton();
            samrtWatchPage_object.selectAppleWatchSeries6();
            samrtWatchPage_object.selectAppleWatchOptions();
            samrtWatchPage_object.setQuantity(2);
            labtopsPage_object.clickAddToCart();
            labtopsPage_object.validateItemAddedMessageAndCounter();
            labtopsPage_object.validateCartNumber(3);
        }

    @And("User Opens cart and Remove laptop then Proceed to checkout")
    public void userOpensCartAndRemoveLaptopThenProceedToCheckout() {
        samrtWatchPage_object.clickViewCart();
        cartPage_object.clickRemoveFor("Dell Latitude 7490 Intel Core i7-8650U 14\" FHD Display, 16GB RAM 512GB SSD, Windows 10 Pro");
        cartPage_object.confirmRemove();
        cartPage_object.clickCheckout();
    }
}
