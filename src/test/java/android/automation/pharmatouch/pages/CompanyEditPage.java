package android.automation.pharmatouch.pages;

import android.automation.pharmatouch.utils.Properties;
import android.automation.pharmatouch.utils.logging.CompanyModel;
import io.appium.java_client.MobileElement;
import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidKeyCode;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;


/**
 * Created by massacre99 on 03.04.2018.
 */
public class CompanyEditPage extends BasePage {

    // company new edit locators button_create_agensy


    By createCompanyButton = By.id("button_create_agensy");
    By editCompanyButton = By.id("button_edit");
    By addCompanyVisit = By.id("button_add_to_visit");
    By createCompanyOkPopupButton = By.id("add_to_visit");
    By companyActionBar = By.xpath("//*[contains(@resource-id, 'action_bar_title')]");
    By createCompanyTitle = By.xpath(String.format("//*[@text='%s']", Properties.title_new_agensy));
    By editCompanyTitle = By.xpath(String.format("//*[@text='%s']", Properties.title_update_agensy));


    By companyName = By.xpath(String.format("//*[@text='%s']", Properties.text_agensy_name));
    By companyType = By.xpath(String.format("//*[@text='%s']", Properties.text_agensy_type));
    By companyCode = By.xpath(String.format("//*[@text='%s']", Properties.text_agensy_tax_code));
    By companyOwner = By.xpath(String.format("//*[@text='%s']", Properties.text_agensy_responcible));
    By companyCategory = By.xpath(String.format("//*[@text='%s']", Properties.text_agensy_category));



    By companyRegion = By.xpath(String.format("//*[@text='%s']", Properties.address_part_region));
    By companyRegionSuburb = By.xpath(String.format("//*[@text='%s']", Properties.text_agensy_suburb));
    By companyCity = By.xpath(String.format("//*[@text='%s']", Properties.address_part_city));
    By companyStreetType = By.xpath(String.format("//*[@text='%s']", Properties.address_part_street_type));
    By companyStreet = By.xpath(String.format("//*[@text='%s']", Properties.address_part_street));
    By companyBuilding = By.xpath(String.format("//*[@text='%s']", Properties.address_part_building));
    By companyPostCode = By.xpath(String.format("//*[@text='%s']", Properties.address_part_post_code));
    By companyAddInfo = By.xpath(String.format("//*[@text='%s']", Properties.address_part_adress_add_info));

    By companyPhone = By.xpath(String.format("//*[@text='%s']", Properties.text_agensy_phone));
    By companyPhoneAdd = By.xpath(String.format("//*[@text='%s']", Properties.text_agensy_add_phone));
    By companyEmail = By.xpath(String.format("//*[@text='%s']", Properties.text_agensy_email));
    By companySite = By.xpath(String.format("//*[@text='%s']", Properties.text_agensy_site));

    By companyArchiveReason = By.xpath(String.format("//*[@text='%s']", Properties.title_text_archivereason));
    By companyConnectedPlace = By.xpath(String.format("//*[@text='%s']", Properties.title_agensy_connected_places));


    public CompanyModel createNewCompany() {
        String name;
        String type;
        String city;
        String street;
        name = fakerEn.company().name();
        street = fakerEn.address().streetName();

        wait.until(ExpectedConditions.presenceOfElementLocated(companyButton));
        driver.findElement(companyButton).click();
        wait.until(ExpectedConditions.presenceOfElementLocated(companyActionBar));
        driver.findElement(plusViewButton).click();
        driver.findElement(createCompanyButton).click();
        wait.until(ExpectedConditions.presenceOfElementLocated(createCompanyOkPopupButton));
        driver.findElement(createCompanyOkPopupButton).click();

        driver.findElement(companyName).click();
        driver.getKeyboard().sendKeys("ыаыаыа");
//
//        compName.setValue("Русское название");


        driver.findElement(companyType).click();
        type = driver.findElement(getTextNameElement(2)).getText();
        driver.findElement(getTextNameElement(2)).click();
        driver.findElement(companyRegion).click();
        driver.findElement(getTextNameElement(2)).click();
        driver.findElement(companyCity).click();
        city = driver.findElement(getTextNameElement(1)).getText();
        driver.findElement(getTextNameElement(1)).click();
        driver.findElement(companyStreetType).click();
        driver.findElement(getTextNameElement(2)).click();

        driver.findElement(companyStreet).click();
        driver.getKeyboard().sendKeys("ыаыаыа");


        driver.findElement(createCompanyButton).click();

        // works only on UIAutomator2, else comment. TODO toast
//        Assert.assertEquals(Properties.text_message_add_new_company, getToastMessage());

        wait.until(ExpectedConditions.presenceOfElementLocated(editCompanyButton));
        exitToVisibleMenu();
        CompanyModel newCompany = new CompanyModel(name, street, city);
        newCompany.setType(type);

        return newCompany;
    }








    public CompanyEditPage(AndroidDriver driver) {
        super(driver);
    }
}
