package saucedemo.stepdef;

import io.cucumber.java.PendingException;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.WebDriver;
import saucedemo.driver.DriverManager;
import saucedemo.page.InventoryPage;
import saucedemo.page.LoginPage;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class InventoryStepDef {

    WebDriver driver;
    InventoryPage inventoryPage;
    int beforeCount;

    @Then("user di inventory page")
    public void userDiInventoryPage() {
        driver = DriverManager.getDriver();
        inventoryPage = new InventoryPage(driver);
        inventoryPage.validateOnInventoryPage();
    }

    @Given("user login dengan username {string} dan password {string}")
    public void userLoginDenganUsernameDanPassword(String username, String password) {
        driver = DriverManager.getDriver();
        LoginPage loginPage = new LoginPage(driver);

        loginPage.openLoginPage();
        loginPage.inputUsername(username);
        loginPage.inputPassword(password);
        loginPage.clickLogin();

        inventoryPage = new InventoryPage(driver);
        inventoryPage.validateOnInventoryPage();
    }

    @When("user klik tombol tambah pada satu produk")
    public void userKlikTombolTambahPadaSatuProduk() {
        beforeCount = inventoryPage.getCartCount();
        inventoryPage.addProductToCart();
    }

    @Then("jumlah cart bertambah")
    public void jumlahCartBertambah() {
        int afterCount = inventoryPage.getCartCount();
        assertTrue(afterCount > beforeCount);
    }

    @When("user klik tombol hapus")
    public void userKlikTombolHapus() {
        beforeCount = inventoryPage.getCartCount();
        inventoryPage.removeProduct();
    }

    @Then("jumlah cart berkurang")
    public void jumlahCartBerkurang() {
        int afterCount = inventoryPage.getCartCount();
        assertTrue(afterCount < beforeCount);
    }

    @And("user sudah menambahkan 1 produk")
    public void userSudahTambahProduk() {
        driver = DriverManager.getDriver();
        inventoryPage = new InventoryPage(driver);
        inventoryPage.addProductToCart();
    }
}