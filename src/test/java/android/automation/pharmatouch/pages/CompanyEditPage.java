package android.automation.pharmatouch.pages;

import android.automation.pharmatouch.utils.Properties;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidKeyCode;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


/**
 * Created by massacre99 on 03.04.2018.
 */
public class CompanyEditPage extends BasePage {


/* OLD SEARCH BY NAME
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

    By companyArchiveReason = By.xpath(String.format("//*[@text='%s']", Properties.title_text_archivereason));
    By companyConnectedPlace = By.xpath(String.format("//*[@text='%s']", Properties.title_agensy_connected_places));
    */

    // company new edit locators button_create_agensy

    By companyTextFieldTitle = By.id("textViewEditTextTitle"); // тайтлы текстовых редактируемых полей
    By companyTextFieldText = By.id("editTextCustomView"); //текст в редактируемых полях
    By companyDropboxFieldTitle = By.id("textViewTitle"); // тайтлы в дропбоксовых полях
    By companyDropboxFieldText = By.id("layoutForInflateViews"); // тайтлы в дропбоксовых полях


    By createCompanyOkPopupButton = By.id("add_to_visit");
    By createCompanyButton = By.id("button_create_agensy");


    By createCompanyTitle = By.xpath(String.format("//*[contains(@resource-id, 'client_main_title_text') and @text='%s']",
            Properties.title_new_agensy));
    By editCompanyTitle = By.xpath(String.format("//*[contains(@resource-id, 'client_main_title_text') and @text='%s']",
            Properties.title_update_agensy));

    By companyName = By.id("editTextAgensyName");
    By companyType = By.id("spinnerAgensyType");
    By companyCode = By.id("editTextAgensyTaxCode");
    By companyOwner = By.id("spinnerAgensyResponcible");
    By companyCategory = By.xpath(String.format("//*[@text='%s']", Properties.text_agensy_category)); // TODO написать норм локатор


    By companyRegion = By.id("spinnerAgensyRegion");
    By companyRegionSuburb = By.id("spinnerAgensySuburb");
    By companyCity = By.id("spinnerAgensyCity");
    By companyStreetType = By.id("spinnerAgensyStreetType");
    By companyStreet = By.id("editTextAgensyStreet");
    By companyBuilding = By.id("editTextAgensyBuilding");
    By companyPostCode = By.id("editTextAgensyPostCode");
    By companyAddInfo = By.id("editTextAgensyAddInfo");

    By companyPhone = By.id("editTextAgensyPhone1");
    By companyPhoneAdd = By.id("editTextAgensyPhone2");
    By companyEmail = By.id("editTextAgensyEmail");
    By companySite = By.id("editTextAgensyWeb");

    By companyArchiveReason = By.id("spinnerArchiveReason");
    By companyConnectedPlace = By.id("prescrDinamicLayout");



    public CompanyPage exitToCompanyPageWithArrowButton() {
        driver.findElement(arrowBackButton).click();
        waitForVisible(createCompanyOkPopupButton);
        driver.findElement(createCompanyOkPopupButton).click();
        return new CompanyPage(driver);
    }

    public CompanyPage exitToCompanyPageWithAndroidKey() {
        driver.pressKeyCode(AndroidKeyCode.BACK);
        waitForVisible(createCompanyOkPopupButton);
        driver.findElement(createCompanyOkPopupButton).click();
        return new CompanyPage(driver);
    }

    public CompanyPage clickSaveButtonToSaveCompany() {
        driver.findElement(createCompanyButton).click();
        return new CompanyPage(driver);
    }

    public CompanyListPage exitWhileCreateNewCompanyWithArrowButton() {
        driver.findElement(arrowBackButton).click();
        waitForVisible(createCompanyOkPopupButton);
        driver.findElement(createCompanyOkPopupButton).click();
        return new CompanyListPage(driver);
    }

    public CompanyListPage exitWhileCreateNewCompanyWithAndroidKey() {
        driver.pressKeyCode(AndroidKeyCode.BACK);
        waitForVisible(createCompanyOkPopupButton);
        driver.findElement(createCompanyOkPopupButton).click();
        return new CompanyListPage(driver);
    }





    public void createNewCompany() {

        goToCompanyPage();
        driver.findElement(plusViewButton).click();
        wait.until(ExpectedConditions.presenceOfElementLocated(createCompanyTitle));
        driver.findElement(createCompanyButton).click();
        wait.until(ExpectedConditions.presenceOfElementLocated(createCompanyOkPopupButton));
        driver.findElement(createCompanyOkPopupButton).click();
        driver.findElement(companyName).click();
        driver.getKeyboard().sendKeys(fakerRu.company().name());
        driver.findElement(companyType).click();
        driver.findElement(getTextNameElement(2)).getText();
        driver.findElement(getTextNameElement(2)).click();
        driver.findElement(companyRegion).click();
        driver.findElement(getTextNameElement(2)).click();
        driver.findElement(companyCity).click();
        driver.findElement(getTextNameElement(1)).getText();
        driver.findElement(getTextNameElement(1)).click();
        driver.findElement(companyStreetType).click();
        driver.findElement(getTextNameElement(2)).click();
        driver.findElement(companyStreet).click();
        driver.getKeyboard().sendKeys(fakerRu.address().streetName());

        getCompanyDetailInMap();

        driver.findElement(createCompanyButton).click();
        // works only on UIAutomator2, else comment. TODO toast
        Assert.assertEquals(Properties.text_message_add_new_company, getToastMessage());

        wait.until(ExpectedConditions.presenceOfElementLocated(editCompanyContactButton));
        exitToVisibleMenu();
    }

    public void getCompanyDetailInMap() {

        Map<String, String> companyDetails = new HashMap<>();

        List<WebElement> textFieldTitle = driver.findElements(companyTextFieldTitle);
        List<WebElement> textFieldText = driver.findElements(companyTextFieldText);
        List<WebElement> textDropboxTitle = driver.findElements(companyDropboxFieldTitle);
        List<String> textDropboxText = new ArrayList<>();

        Assert.assertTrue(textFieldTitle.size() == textFieldText.size(), "Size not same");

        for (int i = 0; i < textFieldTitle.size(); i++) {
            companyDetails.put(textFieldTitle.get(i).getText(), textFieldText.get(i).getText());
        }


        for (int i = 1; i <= textDropboxTitle.size() ; i++) {

            try {
                textDropboxText.add(driver.findElement(getDropBoxFieldTextElement(i)).getText());
            } catch (NoSuchElementException e) {
                textDropboxText.add("");
            }
        }

        Assert.assertTrue(textDropboxTitle.size() == textDropboxText.size(), "Size not same");

        for (int i = 0; i < textDropboxTitle.size() ; i++) {
            companyDetails.put(textDropboxTitle.get(i).getText(), textDropboxText.get(i));
        }

        for (Map.Entry<String, String> stringStringEntry : companyDetails.entrySet()) {
            System.out.println(stringStringEntry.getKey() + " : " + stringStringEntry.getValue());
        }
    }

    public By getDropBoxFieldTextElement(int value) {
        By DropBoxFieldTextElement = By.xpath(String.format("(//*[contains(@resource-id, 'layoutForInflateViews')])[%s]//*[contains(@resource-id, 'textViewValue')]", value));
        return DropBoxFieldTextElement;
    }

    public CompanyEditPage(AndroidDriver driver) {
        super(driver);
    }
}
