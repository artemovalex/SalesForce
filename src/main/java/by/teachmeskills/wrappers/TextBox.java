package by.teachmeskills.wrappers;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class TextBox {

    WebDriver driver;
    String label;

    public TextBox(WebDriver driver, String label) {
        this.driver = driver;
        this.label = label;
    }

    public TextBox fillIn(String text) {
        By fullLocator = By.xpath(String.format("//span[text()='%s']//ancestor::div[contains(@class,'uiInput')]//textarea", label));
        driver.findElement(fullLocator).sendKeys(text);
        return this;
    }
    public TextBox fillInForContactsModal(String text) {
        By fullLocator = By.xpath(String.format("//label[text()='%s']//ancestor::div[contains(@class,'slds-form-element__row')]//textarea", label));
        driver.findElement(fullLocator).sendKeys(text);
        return this;
    }
}