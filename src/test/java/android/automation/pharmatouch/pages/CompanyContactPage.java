package android.automation.pharmatouch.pages;

import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.By;

/**
 * Created by massacre99 on 26.04.2018.
 */
abstract class CompanyContactPage extends BasePage{

    By editCompanyContactButton = By.id("button_edit");
    By addCompanyContactVisit = By.id("button_add_to_visit");

    public CompanyContactPage(AndroidDriver driver) {
        super(driver);
    }
}
