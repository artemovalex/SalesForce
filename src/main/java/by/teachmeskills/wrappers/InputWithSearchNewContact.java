package by.teachmeskills.wrappers;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class InputWithSearchNewContact {
    WebDriver driver;
    String label;

    public InputWithSearchNewContact(WebDriver driver, String label) {
        this.driver = driver;
        this.label = label;
    }

    public InputWithSearchNewContact fillIn(String text) {
        By fullLocator = By.xpath(String.format("//label[text()='%s']//following::div[contains(@class,'slds-form-element__control')]//input", label));
        driver.findElement(fullLocator).click();

        By accountNameLocator = By.xpath(String.format("//span[text()='%s']//ancestor::li[@class=\"slds-listbox__item\"]", text));
        driver.findElement(accountNameLocator).click();

        return this;
    }
}