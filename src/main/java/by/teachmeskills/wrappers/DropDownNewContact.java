package by.teachmeskills.wrappers;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class DropDownNewContact {
    WebDriver driver;
    String label;

    public DropDownNewContact(WebDriver driver, String label) {
        this.driver = driver;
        this.label = label;
    }
    public DropDownNewContact select(String option) {
        By fullLocator = By.xpath(String.format("//label[text()='%s']//ancestor::div[contains(@class,'slds-form-element__row')]//button", label));
        driver.findElement(fullLocator).click();
        driver.findElement(By.xpath(String.format("//div[contains(@class, 'visible')]//a[@name='%s']", option))).click();
        return this;
    }
}
