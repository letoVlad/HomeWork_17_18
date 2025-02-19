package org.example.homework_17;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class IngredientPageTest {
    private WebDriver driver;

    @BeforeEach
    void setUp() {
        System.setProperty("webdriver.chrome.driver", "D:\\backup\\chromedriver.exe");
        driver = new ChromeDriver();
        driver.get("http://localhost:8080/ingredient");
    }

    @Test
    void testIngredientListDisplayed() {
        List<WebElement> ingredients = driver.findElements(By.tagName("li"));
        assertFalse(ingredients.isEmpty(), "Список ингредиентов пустой");
    }

    @Test
    void testAddIngredientLinkExists() {
        WebElement addLink = driver.findElement(By.xpath("//a[@href='/ingredient/new']"));
        assertEquals("Добавить новый ингредиент", addLink.getText());
    }

    @AfterEach
    void tearDown() {
        driver.quit();
    }
}
