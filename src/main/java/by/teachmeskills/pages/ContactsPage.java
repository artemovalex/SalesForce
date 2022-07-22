package by.teachmeskills.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class ContactsPage extends BasePage {
    @FindBy(xpath = "//div[@title='New']")
    private WebElement newButton;

    public ContactsPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }

    public ContactsPage open() {
        driver.get("https://tms22.lightning.force.com/lightning/o/Contact/list?filterName=Recent");
        By accountsLocator = By.xpath("//div[contains(@class,'slds-breadcrumb__item')]//span[text()='Contacts']");
        wait.until(ExpectedConditions.visibilityOfElementLocated(accountsLocator));
        return this;
    }

    public ContactsPage clickNewButton() {
        newButton.click();
        return this;
    }
}