package by.teachmeskills.pages;

import by.teachmeskills.wrappers.*;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class NewContactsModalPage extends BasePage {
    @FindBy(xpath = "//button[text()='Save']")
    private WebElement saveButton;

    public NewContactsModalPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }

    public NewContactsModalPage fillInNewContactsModalPage(String accountFirstName, String accountMiddleName, String accountLastName, String accountName, String mailingStreet) {

        // new DropDownNewContact(driver, "Salutation").select(salutation);
        new InputNewContact(driver, "First Name").fillIn(accountFirstName);
        new InputNewContact(driver, "Middle Name").fillIn(accountMiddleName);
        new InputNewContact(driver, "Last Name").fillIn(accountLastName);
        new InputWithSearchNewContact(driver, "Account Name").fillIn(accountName);
        new TextBox(driver, "Mailing Street").fillInForContactsModal(mailingStreet);
        return this;
    }

    public NewContactsModalPage saveContact() {
        saveButton.click();
        return this;
    }
}