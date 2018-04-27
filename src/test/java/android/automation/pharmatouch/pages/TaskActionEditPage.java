package android.automation.pharmatouch.pages;

import android.automation.pharmatouch.utils.Properties;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidKeyCode;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;

/**
 * Created by massacre99 on 10.04.2018.
 */
public class TaskActionEditPage extends BasePage {

    By createTaskActionButton = By.id("button_create_visit");
    By createTaskOkPopupButton = By.id("add_to_visit");

    By goToTaskPage = By.id("buttonToDay");
    By goToActionPage = By.id("buttonToWeek");

    By createTaskTitle = By.xpath(String.format("//*[contains(@resource-id, 'visit_main_title_text') and @text='%s']",
            Properties.title_new_visit));
    By editTaskTitle = By.xpath(String.format("//*[contains(@resource-id, 'visit_main_title_text') and @text='%s']",
            Properties.title_update_visit));

    By createActionTitle = By.xpath(String.format("//*[contains(@resource-id, 'task_main_title_text') and @text='%s']",
            Properties.title_new_task));
    By editActionTitle = By.xpath(String.format("//*[contains(@resource-id, 'task_main_title_text') and @text='%s']",
            Properties.title_update_task));



    By taskActionState = By.id("titleButtonVisitState");
    By taskCLM = By.id("spinnerPresentationMaterials");
    By taskActionCompany = By.id("companyDynamicLayout");
    By taskContact = By.id("spinnerClient");
    By taskContactInTask = By.id("spinnerContactInTask");
    By taskDatefrom = By.id("spinnerDateFromVisit");
    By taskDatetill = By.id("spinnerDateTillVisit");
    By taskType = By.id("spinnerVisitType");
    By taskSupervisor = By.id("spinnerSupervisor"); // может быть указан, как сотрудник или супервайзер
    By taskWatcher = By.id("watcherDinamicLayout");
    By taskActionBrands = By.id("spinnerBrends");
    By taskActionPromo = By.id("spinnerPromoMaterials");
    By taskControl = By.id("spinnerControl");
    By taskActionPhoto = By.id("spinnerPhoto");
    By taskPervostolnik = By.id("spinnerPervostolniki");
    By taskCampaign = By.id("campaignDynamicLayout");
    By taskBrandComment = By.id("spinnerBrendComment");
    By taskResult = By.id("editTextResult");

    By actionName = By.id("editTextTaskName");
    By actionType = By.id("spinnerTaskType");
    By actionDatefrom = By.id("spinnerDateFromTask");
    By actionDatetill = By.id("spinnerDateTillTask");
    By actionRegion = By.id("spinnerTaskRegion");
    By actionCity = By.id("spinnerTaskCity");
    By actionComment = By.id("editTextTaskComment");
    By actionMP = By.id("spinnerMP");





    // TODO добавить доп поля



    public ProfilePage exitToProfilePageWithArrowButton() {
        driver.findElement(arrowBackButton).click();
        waitForVisible(createTaskOkPopupButton);
        driver.findElement(createTaskOkPopupButton).click();
        return new ProfilePage(driver);
    }

    public ProfilePage exitToProfilePageWithAndroidKey() {
        driver.pressKeyCode(AndroidKeyCode.BACK);
        waitForVisible(createTaskOkPopupButton);
        driver.findElement(createTaskOkPopupButton).click();
        return new ProfilePage(driver);
    }

    public ContactPage exitToContactPageWithArrowButton() {
        driver.findElement(arrowBackButton).click();
        waitForVisible(createTaskOkPopupButton);
        driver.findElement(createTaskOkPopupButton).click();
        return new ContactPage(driver);
    }

    public ContactPage exitToContactPageWithAndroidKey() {
        driver.pressKeyCode(AndroidKeyCode.BACK);
        waitForVisible(createTaskOkPopupButton);
        driver.findElement(createTaskOkPopupButton).click();
        return new ContactPage(driver);
    }

    public CompanyPage exitToCompanyPageWithArrowButton() {
        driver.findElement(arrowBackButton).click();
        waitForVisible(createTaskOkPopupButton);
        driver.findElement(createTaskOkPopupButton).click();
        return new CompanyPage(driver);
    }

    public CompanyPage exitToCompanyPageWithAndroidKey() {
        driver.pressKeyCode(AndroidKeyCode.BACK);
        waitForVisible(createTaskOkPopupButton);
        driver.findElement(createTaskOkPopupButton).click();
        return new CompanyPage(driver);
    }

    public TaskActionPage clickSaveButtonToSaveTask() {
        driver.findElement(createTaskActionButton).click();
        return new TaskActionPage(driver);
    }


    public void fillNewVisit() {
        wait.until(ExpectedConditions.presenceOfElementLocated(createTaskTitle));
        driver.findElement(createTaskActionButton).click();
        driver.findElement(createTaskOkPopupButton).click();
        driver.findElement(taskActionCompany).click();
        waitForVisible(By.id("header_title_text"));
        driver.findElement(getTextViewElement(2)).click();
        driver.findElement(createTaskActionButton).click();

//        // works only on UIAutomator2, else comment. TODO toast
        Assert.assertEquals(Properties.text_message_add_new_visit, getToastMessage());
        wait.until(ExpectedConditions.presenceOfElementLocated(editTaskButton));
        exitToVisibleMenu();
    }














    public TaskActionEditPage(AndroidDriver driver) {
        super(driver);
    }


}
