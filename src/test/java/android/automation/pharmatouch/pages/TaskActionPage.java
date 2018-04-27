package android.automation.pharmatouch.pages;

import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.By;

/**
 * Created by massacre99 on 19.04.2018.
 */
public class TaskActionPage extends BasePage {

    By taskDatefromDatetill = By.id("textVisitName");
    By taskTextTaskState = By.id("textVisitState");
    By taskPlanCycle = By.xpath("//*[contains(@resource-id,'container_visit_plan')]//*[contains(@resource-id,'text_value')]");
    By clmContainer = By.id("clmContainer");
    By taskCompanyName = By.xpath("(//*[contains(@resource-id,'visitAgency')])[1]//*[contains(@resource-id,'text_value')]");
    By taskCompanyAdress = By.id("textVisitAgencyAddress");
    By taskCompanyType = By.xpath("//*[contains(@resource-id,'visitAgencyType')]//*[contains(@resource-id,'text_value')]");
    By taskContact = By.xpath("//*[contains(@resource-id,'visitClient')]//*[contains(@resource-id,'text_value')]");
    By taskContactSpec = By.xpath("//*[contains(@resource-id,'visitSpec')]//*[contains(@resource-id,'text_value')]");
    By taskResult = By.xpath("//*[contains(@resource-id,'resultLayout')]//*[contains(@resource-id,'text_value')]");
    By taskVisitType = By.xpath("//*[contains(@resource-id,'visitType')]//*[contains(@resource-id,'text_value')]");
    By taskCountyParty = By.xpath("//*[contains(@resource-id,'visitCountParty')]//*[contains(@resource-id,'text_value')]");

    By editTaskButton = By.id("buttonEditVisit");
    By deleteTaskButton = By.id("buttonDeleteVisit");
    By yesOkPopupButton = By.id("add_to_visit");
    By noPopupButton = By.id("edit");


    public TaskActionEditPage clickEditButtonToEditTask() {
        driver.findElement(editTaskButton).click();
        return new TaskActionEditPage(driver);
    }

    public CompanyPage deleteTaskCreatedFromCompanyPage() {
        driver.findElement(deleteTaskButton).click();
        waitForVisible(yesOkPopupButton);
        driver.findElement(yesOkPopupButton).click();
        return new CompanyPage(driver);
    }

    public ContactPage deleteTaskCreatedFromContactPage() {
        driver.findElement(deleteTaskButton).click();
        waitForVisible(yesOkPopupButton);
        driver.findElement(yesOkPopupButton).click();
        return new ContactPage(driver);
    }

    public ProfilePage deleteTaskCreatedFromProfilePage() {
        driver.findElement(deleteTaskButton).click();
        waitForVisible(yesOkPopupButton);
        driver.findElement(yesOkPopupButton).click();
        return new ProfilePage(driver);
    }






    public String getTaskDatefromDatetillText() {
        return driver.findElement(taskDatefromDatetill).getText();
    }

    public void deleteTask() {
        driver.findElement(deleteTaskButton).click();
        waitForVisible(yesOkPopupButton);
        driver.findElement(yesOkPopupButton).click();
    }


    public TaskActionPage(AndroidDriver driver) {
        super(driver);
    }
}
