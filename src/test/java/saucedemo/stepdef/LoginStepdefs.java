package saucedemo.stepdef;

import io.cucumber.java.en.*;
import org.openqa.selenium.WebDriver;
import saucedemo.driver.DriverManager;
import saucedemo.page.LoginPage;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class LoginStepdefs {

    WebDriver driver;
    LoginPage loginPage;

    @Given("user berada di halaman login")
    public void userBeradaDiHalamanLogin() {
        driver = DriverManager.getDriver();
        if (driver == null) {
            throw new RuntimeException("Driver is NULL. Pastikan Hooks berjalan!");
        }
        loginPage = new LoginPage(driver);
        loginPage.openLoginPage();
    }

    @When("user memasukkan username {string}")
    public void userMemasukkanUsername(String username) {
        loginPage.inputUsername(username);
    }

    @And("user memasukkan password {string}")
    public void userMemasukkanPassword(String password) {
        loginPage.inputPassword(password);
    }

    @And("user klik tombol login")
    public void userKlikTombolLogin() {
        loginPage.clickLogin();
    }

    @Then("muncul pesan error")
    public void munculPesanError() {
        assertTrue(loginPage.isErrorDisplayed(), "Pesan error tidak muncul");
    }
}