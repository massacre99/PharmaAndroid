package android.automation.pharmatouch.pages;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidKeyCode;

/**
 * Created by massacre99 on 20.04.2018.
 */
public class CompanyPage extends CompanyContactPage {





    public CompanyListPage exitToCompanyListPageWithArrowButton() {
        driver.findElement(arrowBackButton).click();
        return new CompanyListPage(driver);
    }

    public CompanyListPage exitToCompanyListPageWithAndroidKey() {
        driver.pressKeyCode(AndroidKeyCode.BACK);
        return new CompanyListPage(driver);
    }

    public TaskActionEditPage createVisitFromCompanyPage() {
        driver.findElement(addCompanyContactVisit).click();
        return new TaskActionEditPage(driver);
    }

    public CompanyEditPage editCompanyFromCompanyPage() {
        driver.findElement(editCompanyContactButton).click();
        return new CompanyEditPage(driver);
    }

    public CompanyPage(AndroidDriver driver) {
        super(driver);
    }
}
