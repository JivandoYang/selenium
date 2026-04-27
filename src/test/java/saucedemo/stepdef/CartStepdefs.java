package saucedemo.stepdef;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.WebDriver;
import saucedemo.driver.DriverManager;
import saucedemo.page.CartPage;

public class CartStepdefs {
    WebDriver driver;
    CartPage cartPage;

    @When("user menekan icon cart")
    public void userMenekanIconCart() {
        driver = DriverManager.getDriver();
        cartPage = new CartPage(driver);
        cartPage.clickCart();
    }

    @Then("user berada di halaman cart")
    public void userBeradaDiHalamanCart() {
        driver = DriverManager.getDriver();
        cartPage = new CartPage(driver);
        cartPage.validateOnCartPage();
    }

    @When("user menekan tombol continue shopping")
    public void userMenekanTombolContinueShopping() {
        cartPage.clickContinueShopping();
    }
}
