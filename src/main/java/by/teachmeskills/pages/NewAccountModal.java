package by.teachmeskills.pages;

import by.teachmeskills.wrappers.DropDownNewAccount;
import by.teachmeskills.wrappers.InputNewAccount;
import by.teachmeskills.wrappers.InputWithSearchNewAccount;
import by.teachmeskills.wrappers.TextBox;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class NewAccountModal extends BasePage {

    @FindBy(xpath = "//button[@title='Save']")
    private WebElement saveButton;

    public NewAccountModal(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }

    public NewAccountModal fillInNewAccountModal(String accountName, String website, String parentAccount, String phone, String type, String industry, String description) {
        new InputWithSearchNewAccount(driver, "Account Name").fillIn(accountName);
        new InputNewAccount(driver, "Website").fillIn(website);
        new InputWithSearchNewAccount(driver, "Parent Account").fillIn(parentAccount);
        new InputNewAccount(driver, "Phone").fillIn(phone);
        new DropDownNewAccount(driver, "Type").select(type);
        new DropDownNewAccount(driver, "Industry").select(industry);
        new TextBox(driver, "Description").fillIn(description);
        return this;
    }

    public NewAccountModal saveAccount() {
        saveButton.click();
        return this;
    }
}
