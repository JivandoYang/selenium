package saucedemo.page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class CartPage {

    WebDriver driver;
    By title = By.className("title");
    By cart = By.cssSelector("[data-test='shopping-cart-link']");
    By button = By.id("continue-shopping");
    public CartPage(WebDriver driver) {
        this.driver = driver;
    }

    public void validateOnCartPage() {
        WebElement titleElement = driver.findElement(title);
        assertTrue(titleElement.isDisplayed());
        assertEquals("Your Cart", titleElement.getText());
    }

    public void clickCart() {
        driver.findElement(cart).click();
    }

    public void clickContinueShopping() {
        driver.findElement(button).click();
    }

}
