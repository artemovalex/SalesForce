package by.teachmeskills;

import by.teachmeskills.pages.AccountsPage;
import by.teachmeskills.pages.LoginPage;
import by.teachmeskills.pages.NewAccountModal;
import com.github.javafaker.Faker;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.annotations.Test;

public class LoginTest extends BaseTest {

    @Test
    public void createAccountTest() {
        new LoginPage(driver).open()
                .fillInUserName("artemov_alex-mrsz@force.com")
                .fillInPassword("123456789Zz")
                .submitForm();

        By homesLocator = By.xpath("//one-app-nav-bar-item-root[@data-id=\"home\"]");
        wait.until(ExpectedConditions.attributeContains(homesLocator, "class", "navItem slds-context-bar__item slds-shrink-none slds-is-active"));

        new AccountsPage(driver).open()
                .clickNewButton();

        Faker faker = new Faker();
        String accountName = faker.company().name();

        new NewAccountModal(driver).fillInNewAccountModal(accountName, faker.internet().url(), accountName,
                        faker.phoneNumber().phoneNumber(), "Competitor", "Retail", faker.company().catchPhrase())
                .saveAccount();


        String alertsXpath = "//div[contains(@class, 'toastContainer')]//span[contains(@class, 'toastMessage')]";
        By alertsLocator = By.xpath(alertsXpath);
        wait.until(ExpectedConditions.visibilityOfElementLocated(alertsLocator));

        String message = driver.findElement(By.xpath(alertsXpath)).getText();
        Assert.assertEquals(message, "Account \"" + accountName + "\" was created.", "account is not created");
    }

}