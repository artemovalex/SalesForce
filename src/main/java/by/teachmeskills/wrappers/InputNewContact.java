package by.teachmeskills.wrappers;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class InputNewContact {

    WebDriver driver;
    String label;

    public InputNewContact(WebDriver driver, String label) {
        this.driver = driver;
        this.label = label;
    }

    public InputNewContact fillIn(String text) {
        By fullLocator = By.xpath(String.format("//label[text()='%s']//ancestor::div[contains(@class,'slds-form-element__row')]//input", label));
        driver.findElement(fullLocator).sendKeys(text);
        return this;
    }
}