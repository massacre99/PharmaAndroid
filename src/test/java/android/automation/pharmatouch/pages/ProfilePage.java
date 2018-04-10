package android.automation.pharmatouch.pages;

import io.appium.java_client.MobileElement;
import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidKeyCode;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.Reporter;

import java.time.Duration;
import java.util.*;

/**
 * Created by massacre99 on 27.03.2018.
 */
public class ProfilePage extends BasePage {



    By nextDay = By.id("imageArowForward");
    By prevDay = By.id("imageArowBack");
    By nextMonth = By.id("image_next_month");
    By prevMonth = By.id("image_prev_month");
    By today = By.id("imageToday");
    By textHeadCalendar = By.id("textHeadCalendar");
    // createVisitTask
    By addNewActivity = By.xpath("//android.view.View[@index='1']");
//    By createNewVisitTask = By.id(); TODO реализовать в TaskEditPage
    // TODO реализовать если не выйдет найти элементы ActionBar по Xpath
 /*   public void tapOnActionBarElement(int index){
        List<WebElement> elements = driver.findElementByClass("PUT YOUR class name");
        elements.get(index).click();
    } */

    //TODO try this
//    driver.findElement(By.xpath("//android.widget.TextView[@index='0']")).click();
//    driver.findElement(By.xpath("//*[@class='android.widget.TextView' and @index='0']")).click();
//    driver.findElement(By.name("Sign In")).click();

    // copy Activity
    By copy = By.xpath("(//*[contains(@resource-id, 'action_bar_button')])[3]");
    By copyOnDayIndex = By.xpath("//android.widget.LinearLayout[@index='25']"); //TODO сделать GetDay и индекс + 2-3 дня от него
    By backCopyMoveButton = By.id("action_bar_image_button_back"); // TODO: Maybe OK for cut|delete?
    By checkbox = By.id("imageSelect"); //TODO: ??Maybe OK for cut, delete
    By copyDeleteSubmit = By.id("imageCopy"); // TODO: Maybe OK for delete?
    // perenos Activity
    By move = By.xpath("(//*[contains(@resource-id, 'action_bar_button')])[3]");
    By moveSubmit = By.id("imageMove");
    // delete
    By delete = By.xpath("(//*[contains(@resource-id, 'action_bar_button')])[2]");
    By organogram = By.xpath("//android.widget.ImageView[@index='0']");
    By cancelOrganogram = By.xpath("//android.widget.Button[@index='1']");

    // DayWeekMonthChoose
    By dayWeekMonthChoose = By.id("dashboardSpinner");
    By dayChoose = By.id("titleDay");
    By weekChoose = By.id("titleWeek");
    By monthChoose = By.id("titleMonth");

    // tasks

    By allTask = By.xpath("//*[contains(@resource-id, 'event_color_bg')]");



    public String getDateFormat() {
        return dateFormat.format(new Date());
    }

    public int getDay() {
        return calendar.get(Calendar.DAY_OF_MONTH);
    }





    public void clickDaysMonth() {
        for (int i = 0; i < (random.nextInt(3) + 1) ; i++) {
            driver.findElement(nextDay).click();
        }
        Reporter.log("Next Day Clicked");
        for (int i = 0; i < (random.nextInt(3) + 1) ; i++) {
            driver.findElement(prevDay).click();
        }
        Reporter.log("Previous Day Clicked");
        for (int i = 0; i < (random.nextInt(3) + 1) ; i++) {
            driver.findElement(nextMonth).click();
        }
        Reporter.log("Next Month Clicked");
        for (int i = 0; i < (random.nextInt(3) + 1) ; i++) {
            driver.findElement(prevMonth).click();
        }
        Reporter.log("Previous Month Clicked");

        clickCheckToday();


    }

    public void clickCheckToday() {

        driver.findElement(today).click();
//        System.out.println(driver.findElement(textHeadCalendar).getText());
//        System.out.println(getDateFormat());
        Assert.assertEquals(driver.findElement(textHeadCalendar).getText(), getDateFormat(),
                "Date are not equals, SMTH wrong!");
    }

    public void addNewVisit() {
        driver.findElement(plusViewButton).click();
        TaskEditPage task = new TaskEditPage(driver);
        task.addNewVisit();
    }

    public void swipeVisitAtWeek() {
        driver.findElement(dayWeekMonthChoose).click();
        driver.findElement(weekChoose).click();

        wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(allTask));

        List<WebElement> tasks = driver.findElements(getTaskTextLocators());

        WebElement task = tasks.get(2);
        String text = task.getText();

        new TouchAction(driver).press(task).waitAction(Duration.ofSeconds(25))
               .moveTo(350, 420).release().perform();

        tasks = driver.findElements(getTaskTextLocators());

        for (WebElement webElement : tasks) {
            if (webElement.getText().equals(text)) {
                webElement.click();

                driver.pressKeyCode(AndroidKeyCode.BACK); }
        }

        driver.findElement(dayWeekMonthChoose).click();
        driver.findElement(dayChoose).click();
        waitForVisible(profileButton);
    }


    /*
    public By getCopyMoveDateElement() {
        int newDay = getDay() + 1;
        return By.xpath(String.format("//*[contains(@resource-id, 'date') and @text='%s']", newDay));
    }
    */

    public  void openCompanyPage() {

    }

    public ProfilePage(AndroidDriver driver) {
        super(driver);
    }
}

