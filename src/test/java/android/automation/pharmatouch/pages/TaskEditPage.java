package android.automation.pharmatouch.pages;

import android.automation.pharmatouch.utils.Properties;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;

/**
 * Created by massacre99 on 10.04.2018.
 */
public class TaskEditPage extends BasePage {

    By newTaskTitle = By.id("visit_main_title_text");
    By createTaskButton = By.id("button_create_visit");
    By createVisitOkPopupButton = By.id("add_to_visit");

    By companyTask = By.xpath(String.format("//*[@text='%s']", Properties.text_client_institution_name));
    By contactTask = By.xpath(String.format("//*[@text='%s']", Properties.title_visit_client));
    By typeTask = By.xpath(String.format("//*[@text='%s']", Properties.title_visit_visittype));
    By datefromTask = By.xpath(String.format("//*[@text='%s']", Properties.title_visit_date_from));
    By datetillTask = By.xpath(String.format("//*[@text='%s']", Properties.title_visit_date_till));
    By supervisorTask = By.xpath(String.format("//*[@text='%s']", Properties.title_visit_supervisor));
    By memberTask = By.xpath(String.format("//*[@text='%s']", Properties.title_task_member));
    By supervisor1Task = By.xpath(String.format("//*[@text='%s']", Properties.title_visit_supervisor_1));
    By taskState = By.id("titleButtonVisitState");

    By editTaskButton = By.id("buttonEditVisit");
    By deleteTaskButton = By.id("buttonDeleteVisit");




    public void addNewVisit() {
        wait.until(ExpectedConditions.presenceOfElementLocated(newTaskTitle));
        driver.findElement(createTaskButton).click();
        driver.findElement(createVisitOkPopupButton).click();
        driver.findElement(companyTask).click();
        driver.findElement(getTextViewElement(2)).click();
        driver.findElement(createTaskButton).click();

//        // works only on UIAutomator2, else comment. TODO toast
//        Assert.assertEquals(Properties.text_message_add_new_visit, getToastMessage());
        wait.until(ExpectedConditions.presenceOfElementLocated(editTaskButton));
        exitToVisibleMenu();
    }














    public TaskEditPage(AndroidDriver driver) {
        super(driver);
    }


}
