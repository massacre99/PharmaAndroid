package android.automation.pharmatouch.pages;

import android.automation.pharmatouch.utils.Properties;
import com.github.javafaker.Faker;
import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidKeyCode;
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.*;
import java.util.concurrent.TimeUnit;

/**
 * Created by massacre99 on 27.03.2018.
 */
abstract class BasePage {
    protected AndroidDriver driver;
    protected WebDriverWait wait;
    protected JavascriptExecutor javascriptExecutor;

    Random random = new Random();
    Locale locale = new Locale("ru");
    SimpleDateFormat dateFormat = new SimpleDateFormat("E, d.MM.yyyy", locale);
    Calendar calendar = Calendar.getInstance(locale);

    Faker fakerRu = new Faker(new Locale("ru", "ru"));
    Faker fakerUa = new Faker(new Locale("uk", "ua"));
    Faker fakerEn = new Faker(new Locale("en", "us"));


    // The same locators
    By plusViewButton = By.xpath("//*[@class='android.view.View' and @enabled='true']");


    // main menu
    int exit;
    int sync;
    By allMainMenu = By.xpath("(//*[contains(@resource-id,'main_container'))[*]");
    By profileButton = By.xpath(String.format("//*[contains(@resource-id,'main_container') and ./*[@text='%s']]", Properties.title_main_menu_button_visits));
    By companyButton = By.xpath(String.format("//*[contains(@resource-id,'main_container') and ./*[@text='%s']]", Properties.title_main_menu_button_institutions));
    By companyPageTitle = By.xpath(String.format("//*[contains(@resource-id, 'action_bar_title') and @text='%s']", Properties.title_main_menu_button_institutions));
    By contactButton = By.xpath(String.format("//*[contains(@resource-id,'main_container') and ./*[@text='%s']]", Properties.title_main_menu_button_clients));
    By contactPageTitle = By.xpath(String.format("//*[contains(@resource-id, 'action_bar_title') and @text='%s']", Properties.title_main_menu_button_clients));
    By reportButton = By.xpath(String.format("//*[contains(@resource-id,'main_container') and ./*[@text='%s']]", Properties.title_main_menu_button_reports));
    By reportPageTitle = By.xpath(String.format("//*[contains(@resource-id, 'action_bar_title') and @text='%s']", Properties.title_main_menu_button_reports));
    By clmButton = By.xpath(String.format("//*[contains(@resource-id,'main_container') and ./*[@text='%s']]", Properties.title_main_menu_button_presentations));
    By clmPageTitle = By.xpath(String.format("//*[contains(@resource-id, 'action_bar_title') and @text='%s']", Properties.title_main_menu_button_presentations));
    By exitButton = By.xpath(String.format("(//*[contains(@resource-id,'main_container'))[%s]",exit));
    By syncButton = By.xpath(String.format("(//*[contains(@resource-id,'main_container'))[%s]",sync));

    By editTaskButton = By.id("buttonEditVisit");
    By deleteTaskButton = By.id("buttonDeleteVisit");
    By yesOkPopupButton = By.id("add_to_visit");
    By noPopupButton = By.id("edit");

    By scrollViewDayWeek = By.id("drag_layer");



    public void goToProfilePage() {
        driver.findElement(profileButton).click();
        wait.until(ExpectedConditions.presenceOfElementLocated(By.id("imageArowForward")));
    }

    public void goToCompanyPage() {
        driver.findElement(companyButton).click();
        wait.until(ExpectedConditions.presenceOfElementLocated(companyPageTitle));
    }

    public void goToContactPage() {
        driver.findElement(contactButton).click();
        wait.until(ExpectedConditions.presenceOfElementLocated(contactPageTitle));
    }

    public void goToReportPage() {
        driver.findElement(reportButton).click();
        wait.until(ExpectedConditions.presenceOfElementLocated(reportPageTitle));
    }

    public void goToClmPage() {
        driver.findElement(clmButton).click();
        wait.until(ExpectedConditions.presenceOfElementLocated(clmPageTitle));
    }

    public void goToExitPage() {
        findExitSyncLocators();
        driver.findElement(exitButton).click();
        // todo шото там
    }

    public void sync() {
        findExitSyncLocators();
        driver.findElement(syncButton).click();
        // todo шото там
    }


    public void findExitSyncLocators() {
        List<WebElement> allMenuItems = driver.findElements(allMainMenu);
        exit = allMenuItems.size() - 1;
        sync = allMenuItems.size();
    }
    // выдача сообщения тоаста
    public String getToastMessage() {
        WebElement toastView = driver.findElement(By.xpath("//android.widget.Toast[1]"));
        String text = toastView.getAttribute("name");
        return text;
    }

    // выдача элемента дропбокса в компаниях, клиентах
    public By getTextNameElement(int value) {
        By textNameElement = By.xpath(String.format("(//*[contains(@resource-id, 'textName')])[%s]", value));
        return textNameElement;
    }

    // выдача компании + адреса в дропбоксе визита
    public By getTextViewElement(int value) {
        By textViewElement = By.xpath(String.format("(//*[contains(@resource-id, 'textView')])[%s]", value));
        return textViewElement;
    }

    // выдача таска
    public By getTaskElement(int value) {
        By taskElement = By.xpath(String.format("(//*[contains(@resource-id, 'event_color_bg')])[%s]", value));
        return taskElement;
    }


    // выдача текста, который находится на таске
    public By getTaskTextLocators() {
        By taskText = By.id("text_event_name");
        return taskText;
    }


    // выход до видимости меню
    public void exitToVisibleMenu() {
        driver.pressKeyCode(AndroidKeyCode.BACK);
        waitForVisible(profileButton);
    }



    public BasePage(AndroidDriver driver) {
        this.driver = driver;
        wait = new WebDriverWait(driver,10);
        javascriptExecutor = (JavascriptExecutor) driver;

    }

    public void waitForClickable(By locator, int waitTime) {
        WebDriverWait wait = new WebDriverWait(driver, waitTime);
        for (int attempt = 0; attempt < waitTime; attempt++) {
            try {
                driver.findElement(locator);
                break;
            } catch (Exception e) {
                driver.manage().timeouts().implicitlyWait(1, TimeUnit.SECONDS);
            }
        }
        wait.until(ExpectedConditions.elementToBeClickable(locator));
    }

    public void waitForVisible(final By locator, int waitTime) {
        WebDriverWait wait = new WebDriverWait(driver, waitTime);
        for (int attempt = 0; attempt < waitTime; attempt++) {
            try {
                driver.findElement(locator);
                break;
            } catch (Exception e) {
                driver.manage().timeouts().implicitlyWait(1, TimeUnit.SECONDS);
            }
        }
        wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
    }

    public void waitForVisible(By locator) {
        wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
    }



    public void test() {
        Dimension size = driver.findElement(scrollViewDayWeek).getSize();
        int startX = size.width / 2;
        int startY = size.height;
        int endY = size.height / 3;
        List<WebElement> elements1 = driver.findElements(By.xpath("//*[contains(@resource-id, 'event_color_bg')]"));
        while (elements1.size() == 0)
        { // TODO можно добавить быстрее/медленнее, в зависимости
            new TouchAction(driver).press(startX, startY).waitAction(Duration.ofMillis(500)).
                    moveTo(startX, endY).release().perform();
            elements1 = driver.findElements(By.xpath("//*[contains(@resource-id, 'event_color_bg')]"));
        }
    }


    public void scrollPageUp() {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        HashMap<String, Double> swipeObject = new HashMap<String, Double>();
        swipeObject.put("startX", 0.50);
        swipeObject.put("startY", 0.95);
        swipeObject.put("endX", 0.50);
        swipeObject.put("endY", 0.01);
        swipeObject.put("duration", 3.0);
        js.executeScript("mobile: swipe", swipeObject);
    }


    public void swipeLeftToRight() {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        HashMap<String, Double> swipeObject = new HashMap<String, Double>();
        swipeObject.put("startX", 0.01);
        swipeObject.put("startY", 0.5);
        swipeObject.put("endX", 0.9);
        swipeObject.put("endY", 0.6);
        swipeObject.put("duration", 3.0);
        js.executeScript("mobile: swipe", swipeObject);
    }

    public void swipeRightToLeft() {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        HashMap<String, Double> swipeObject = new HashMap<String, Double>();
        swipeObject.put("startX", 0.9);
        swipeObject.put("startY", 0.5);
        swipeObject.put("endX", 0.01);
        swipeObject.put("endY", 0.5);
        swipeObject.put("duration", 3.0);
        js.executeScript("mobile: swipe", swipeObject);
    }

    public void swipeFirstCarouselFromRightToLeft() {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        HashMap<String, Double> swipeObject = new HashMap<String, Double>();
        swipeObject.put("startX", 0.9);
        swipeObject.put("startY", 0.2);
        swipeObject.put("endX", 0.01);
        swipeObject.put("endY", 0.2);
        swipeObject.put("duration", 3.0);
        js.executeScript("mobile: swipe", swipeObject);
    }

    public void performTapAction(WebElement elementToTap) {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        HashMap<String, Double> tapObject = new HashMap<String, Double>();
        tapObject.put("x", (double) 360); // in pixels from left
        tapObject.put("y", (double) 170); // in pixels from top
        tapObject.put("element", Double.valueOf(((RemoteWebElement) elementToTap).getId()));
        js.executeScript("mobile: tap", tapObject);
    }
}

