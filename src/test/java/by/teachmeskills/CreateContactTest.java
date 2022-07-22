package by.teachmeskills;

import by.teachmeskills.pages.*;
import com.github.javafaker.Faker;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class CreateContactTest extends BaseTest {

    String accountName;
    String contactName;

    @BeforeMethod
    public void login() {
        new LoginPage(driver).open()
                .fillInUserName("artemov_alex-mrsz@force.com")
                .fillInPassword("123456789Zz")
                .submitForm();

        By homesLocator = By.xpath("//one-app-nav-bar-item-root[@data-id=\"home\"]");
        wait.until(ExpectedConditions.attributeContains(homesLocator, "class", "navItem slds-context-bar__item slds-shrink-none slds-is-active"));

        new AccountsPage(driver).open()
                .clickNewButton();

        Faker faker = new Faker();
        accountName = faker.company().name();

        new NewAccountModal(driver).fillInNewAccountModal(accountName, faker.internet().url(), accountName,
                        faker.phoneNumber().phoneNumber(), "Competitor", "Retail", faker.company().catchPhrase())
                .saveAccount();
    }

    @Test
    public void createContactTest() {

        new ContactsPage(driver).open()
                .clickNewButton();
        Faker faker = new Faker();
        contactName = faker.company().name();

        new NewContactsModalPage(driver).fillInNewContactsModalPage(contactName, faker.company().name(), faker.company().name(), accountName, faker.company().catchPhrase())
                .saveContact();


        String namesXpathInAlerts = "//span[contains(@class,'toastMessage')]";
        By alertsLocator = By.xpath(namesXpathInAlerts);
        wait.until(ExpectedConditions.visibilityOfElementLocated(alertsLocator));

        String message = driver.findElement(By.xpath(namesXpathInAlerts)).getText();
        Assert.assertTrue(message.contains(contactName), "Contact is not created");
    }
}