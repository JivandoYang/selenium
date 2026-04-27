package saucedemo.stepdef;

import io.cucumber.java.PendingException;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.WebDriver;
import saucedemo.driver.DriverManager;
import saucedemo.page.CartPage;
import saucedemo.page.CheckoutPage;
import saucedemo.page.LoginPage;

import static org.junit.Assert.assertTrue;

public class CheckoutStepdefs {
    WebDriver driver;
    CheckoutPage checkoutPage;

    @When("user menekan tombol checkout")
    public void userMenekanTombolCheckout() {
        driver = DriverManager.getDriver();
        checkoutPage = new CheckoutPage(driver);
        checkoutPage.clickCheckout();
    }

    @Then("user berada di halaman checkout")
    public void userBeradaDiHalamanCheckout() {
        driver = DriverManager.getDriver();
        checkoutPage = new CheckoutPage(driver);
        checkoutPage.validateOnCheckoutPage();
    }

    @When("user memasukkan firstname {string}")
    public void userMemasukkanFirstname(String firstname) {
        checkoutPage.inputFirstname(firstname);
    }

    @And("user memasukkan lastname {string}")
    public void userMemasukkanLastname(String lastname) {
        checkoutPage.inputLastname(lastname);
    }

    @And("user memasukkan postalcode {string}")
    public void userMemasukkanPostalcode(String postalcode) {
        checkoutPage.inputPostalcode(postalcode);
    }

    @And("user klik tombol continue")
    public void userKlikTombolContinue() {
        checkoutPage.clickContinue();
    }

    @Then("user pergi ke halaman overview")
    public void userPergiKeHalamanOverview() {
        assertTrue(driver.getCurrentUrl().contains("checkout-step-two.html"));
    }

    @Then("sistem muncul pesan error")
    public void sistemMunculPesanError() {
        assertTrue(checkoutPage.isErrorDisplayed());
    }
}
