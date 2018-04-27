package android.automation.pharmatouch.pages;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidKeyCode;
import org.openqa.selenium.By;

/**
 * Created by massacre99 on 20.04.2018.
 */
public class ContactEditPage extends BasePage {

    By createContactOkPopupButton = By.id("add_to_visit");
    By createContactButton = By.id("button_create_client");





    public ContactPage exitToContactPageWithArrowButton() {
        driver.findElement(arrowBackButton).click();
        waitForVisible(createContactOkPopupButton);
        driver.findElement(createContactOkPopupButton).click();
        return new ContactPage(driver);
    }

    public ContactPage exitToContactPageWithAndroidKey() {
        driver.pressKeyCode(AndroidKeyCode.BACK);
        waitForVisible(createContactOkPopupButton);
        driver.findElement(createContactOkPopupButton).click();
        return new ContactPage(driver);
    }

    public ContactPage clickSaveButtonToSaveContact() {
        driver.findElement(createContactButton).click();
        return new ContactPage(driver);
    }

    public ContactListPage exitWhileCreateNewContactWithArrowButton() {
        driver.findElement(arrowBackButton).click();
        waitForVisible(createContactOkPopupButton);
        driver.findElement(createContactOkPopupButton).click();
        return new ContactListPage(driver);
    }

    public ContactListPage exitWhileCreateNewContactWithAndroidKey() {
        driver.pressKeyCode(AndroidKeyCode.BACK);
        waitForVisible(createContactOkPopupButton);
        driver.findElement(createContactOkPopupButton).click();
        return new ContactListPage(driver);
    }

    public ContactEditPage(AndroidDriver driver) {
        super(driver);
    }
}
