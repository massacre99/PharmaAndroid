package android.automation.pharmatouch.pages;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidKeyCode;

/**
 * Created by massacre99 on 20.04.2018.
 */
public class ContactPage extends CompanyContactPage {



    public ContactListPage exitToContactListPageWithArrowButton() {
        driver.findElement(arrowBackButton).click();
        return new ContactListPage(driver);
    }

    public ContactListPage exitToContactListPageWithAndroidKey() {
        driver.pressKeyCode(AndroidKeyCode.BACK);
        return new ContactListPage(driver);
    }

    public TaskActionEditPage createVisitFromContactPage() {
        driver.findElement(addCompanyContactVisit).click();
        return new TaskActionEditPage(driver);
    }

    public ContactEditPage editCompanyFromContactPage() {
        driver.findElement(editCompanyContactButton).click();
        return new ContactEditPage(driver);
    }


    public ContactPage(AndroidDriver driver) {
        super(driver);
    }
}
