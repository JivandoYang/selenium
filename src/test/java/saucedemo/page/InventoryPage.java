package saucedemo.page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class InventoryPage {

    WebDriver driver;
    By productTitle = By.xpath("//*[@id=\"item_4_title_link\"]/div");
    By addButton = By.cssSelector("[data-test='add-to-cart-sauce-labs-backpack']");
    By removeButton = By.cssSelector("[data-test='remove-sauce-labs-backpack']");
    By cart = By.cssSelector("[data-test='shopping-cart-link']");
    By cartBadge = By.className("shopping_cart_badge");

    public InventoryPage(WebDriver driver) {
        this.driver = driver;
    }

    public void validateOnInventoryPage() {
        WebElement productElement = driver.findElement(productTitle);
        assertTrue(productElement.isDisplayed());
        assertEquals("Sauce Labs Backpack", productElement.getText());
    }

    public void addProductToCart() {
        driver.findElement(addButton).click();
    }
    public void removeProduct() {
        driver.findElement(removeButton).click();
    }

    public int getCartCount() {
        try {
            return Integer.parseInt(driver.findElement(cartBadge).getText());
        } catch (Exception e) {
            return 0;
        }
    }
}
