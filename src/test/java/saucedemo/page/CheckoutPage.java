package saucedemo.page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class CheckoutPage {

    WebDriver driver;
    By title = By.className("title");
    By checkoutButton = By.cssSelector("[data-test='checkout']");
    By continueButton = By.id("continue");
    By firstNameField = By.id("first-name");
    By lastNameField = By.id("last-name");
    By postalCodeField = By.id("postal-code");
    By errorMessage = By.cssSelector("h3[data-test='error']");

    public CheckoutPage(WebDriver driver) {
        this.driver = driver;
    }

    public void validateOnCheckoutPage() {
        WebElement titleElement = driver.findElement(title);
        assertTrue(titleElement.isDisplayed());
        assertEquals("Checkout: Your Information", titleElement.getText());
    }

    public void clickCheckout() {
        driver.findElement(checkoutButton).click();
    }

    public void clickContinue() {
        driver.findElement(continueButton).click();
    }

    public void inputFirstname(String firstname) {
        driver.findElement(firstNameField).sendKeys(firstname);
    }

    public void inputLastname(String lastname) {
        driver.findElement(lastNameField).sendKeys(lastname);
    }

    public void inputPostalcode(String postalcode) {
        driver.findElement(postalCodeField).sendKeys(postalcode);
    }

    public boolean isErrorDisplayed() {
        return driver.findElement(errorMessage).isDisplayed();
    }
}