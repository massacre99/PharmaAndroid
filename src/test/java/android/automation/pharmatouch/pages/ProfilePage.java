package android.automation.pharmatouch.pages;

import android.automation.pharmatouch.utils.Properties;
import io.appium.java_client.MobileDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidKeyCode;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;
import java.util.Random;

/**
 * Created by massacre99 on 27.03.2018.
 */
public class ProfilePage extends BasePage {

    // main menu
    int exit;
    int sync;
    By allMainMenu = By.xpath("(//*[contains(@resource-id,'main_container'))[*]");
    By profileButton = By.xpath(String.format("//*[contains(@resource-id,'main_container') and ./*[@text='%s']]", Properties.title_main_menu_button_visits));
    By companyButton = By.xpath(String.format("//*[contains(@resource-id,'main_container') and ./*[@text='%s']]", Properties.title_main_menu_button_institutions));
    By clientButton = By.xpath(String.format("//*[contains(@resource-id,'main_container') and ./*[@text='%s']]", Properties.title_main_menu_button_clients));
    By reportButton = By.xpath(String.format("//*[contains(@resource-id,'main_container') and ./*[@text='%s']]", Properties.title_main_menu_button_reports));
    By clmButton = By.xpath(String.format("//*[contains(@resource-id,'main_container') and ./*[@text='%s']]", Properties.title_main_menu_button_presentations));
    By exitButton = By.xpath(String.format("(//*[contains(@resource-id,'main_container'))[%s]",exit));
    By syncButton = By.xpath(String.format("(//*[contains(@resource-id,'main_container'))[%s]",sync));

    By nextDay = By.id("com.trinetix.pharmatouch:id/imageArowForward");
    By prevDay = By.id("com.trinetix.pharmatouch:id/imageArowBack");
    By nextMonth = By.id("com.trinetix.pharmatouch:id/image_next_month");
    By prevMonth = By.id("com.trinetix.pharmatouch:id/image_prev_month");
    By today = By.id("com.trinetix.pharmatouch:id/imageToday");
    // createVisitTask
    By addNewActivity = By.xpath("//android.view.View[@index='1']");
//    By createNewVisitTask = By.id(); TODO реализовать в VisitPage
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
    By copy = By.xpath("//android.widget.ImageView[@index='3']");
    By copyOnDayIndex = By.xpath("//android.widget.LinearLayout[@index='25']"); //TODO сделать GetDay и индекс + 2-3 дня от него
    By backButton = By.id("com.trinetix.pharmatouch:id/action_bar_image_button_back"); // TODO: Maybe OK for cut|delete?
    By checkbox = By.id("com.trinetix.pharmatouch:id/imageSelect"); //TODO: ??Maybe OK for cut, delete
    By copyDeleteSubmit = By.id("com.trinetix.pharmatouch:id/imageCopy"); // TODO: Maybe OK for delete?
    // perenos Activity
    By move = By.xpath("//android.widget.ImageView[@index='2']");
    By moveSubmit = By.id("com.trinetix.pharmatouch:id/imageMove");
    // delete
    By delete = By.xpath("//android.widget.ImageView[@index='1']");
    By organogram = By.xpath("//android.widget.ImageView[@index='0']");
    By cancelOrganogram = By.xpath("//android.widget.Button[@index='1']");
    // DayWeekMonthChoose
    By dayWeekMonthChoose = By.id("com.trinetix.pharmatouch:id/dashboardSpinner");
    By dayChoose = By.id("com.trinetix.pharmatouch:id/titleDay");
    By weekChoose = By.id("com.trinetix.pharmatouch:id/titleWeek");
    By monthChoose = By.id("com.trinetix.pharmatouch:id/titleMonth");
    Random random = new Random();

    public void findExitSyncLocators() {
        List<WebElement> allMenuItems = driver.findElements(allMainMenu);
        exit = allMenuItems.size() - 1;
        sync = allMenuItems.size();
    }

    public void createNewCompany() {
        wait.until(ExpectedConditions.presenceOfElementLocated(companyButton));
//        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[contains(@resource-id,'main_container') and ./*[@text='Учреждения']]")));
        driver.findElement(companyButton).click();
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[contains(@resource-id, 'action_bar_title')]")));
        driver.findElement(plusViewButton).click();
//        driver.findElement(By.xpath("//*[@class='android.view.View' and @enabled='true']")).click();
        driver.findElement(By.xpath("//*[@text='Создать учреждение']")).click();
        driver.findElement(By.xpath("//*[@text='Ок']")).click();
//        driver.findElement(By.xpath("//*[@text='Название']")).sendKeys("GTFU Pharm");
        MobileElement companyName = (MobileElement) driver.findElement(By.xpath("//*[@text='Название']"));
        companyName.setValue("Test Name Pharm");
        driver.pressKeyCode(AndroidKeyCode.BACK);
//        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@text='Тип учреждения']")));
        driver.findElement(By.xpath("//*[@text='Тип учреждения']")).click();
        driver.findElement(By.xpath("(//*[contains(@resource-id, 'textName')])[2]")).click();
        driver.findElement(By.xpath("//*[@text='Область']")).click();
        driver.findElement(By.xpath("(//*[contains(@resource-id, 'textName')])[2]")).click();
        driver.findElement(By.xpath("//*[@text='Город / Нас. пункт']")).click();
        driver.findElement(By.xpath("(//*[contains(@resource-id, 'textName')])[1]")).click();
        driver.findElement(By.xpath("//*[@text='Тип улицы']")).click();
        driver.findElement(By.xpath("(//*[contains(@resource-id, 'textName')])[2]")).click();
        MobileElement streetName = (MobileElement) driver.findElement(By.xpath("//*[@text='Улица']"));
        streetName.setValue("The Place Street");
//        driver.findElement(By.xpath("//*[@text='Улица']")).sendKeys("The Place");
        driver.pressKeyCode(AndroidKeyCode.BACK);
        driver.findElement(By.xpath("//*[@text='Создать учреждение']")).click();
//        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@text='Новое учреждение добавлено']")));
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[contains(@resource-id, 'button_edit')]")));
    }

    public void clickDaysMonth() {
        for (int i = 0; i < (random.nextInt(3) + 1) ; i++) {
            driver.findElement(nextDay).click();
        }
        System.out.println("click day+");
        for (int i1 = 0; i1 < (random.nextInt(3) + 1) ; i1++) {
            driver.findElement(prevDay).click();
        }
        System.out.println("click day -");
        for (int i2 = 0; i2 < (random.nextInt(3) + 1) ; i2++) {
            driver.findElement(nextMonth).click();
        }
        System.out.println("click month");
        for (int i3 = 0; i3 < (random.nextInt(3) + 1) ; i3++) {
            driver.findElement(prevMonth).click();
        }
        driver.findElement(today).click();

//        //TODO Добавить проверку на дата = сегодня


    }

    public  void openCompanyPage() {

    }

    public ProfilePage(AndroidDriver driver) {
        super(driver);
    }
}

