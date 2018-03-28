package android.automation.pharmatouch.pages;

import android.automation.pharmatouch.utils.Properties;
import io.appium.java_client.MobileDriver;
import io.appium.java_client.TouchAction;
import org.openqa.selenium.By;
import org.testng.Assert;

/**
 * Created by massacre99 on 27.03.2018.
 */
public class LoginPage extends BasePage {
    By login = By.id("editTextLogin");
    By password = By.id("editTextPassword");
    By login_Button = By.id("button_create_client");
    By existingUser_login = By.id("button_create_client");
    By remindPass = By.id("remindPasswordTextView");
    By buttonOkOnIncorrect = By.id("com.trinetix.pharmatouch:id/add_to_visit");


    public LoginPage(MobileDriver driver) {
        super(driver);
    }

    public LoginPage invalidLogin() throws InterruptedException {
        waitForVisible(login, 3);
        enterLoginPass(Properties.LOGIN_FALSE, Properties.PASS_FALSE);
        Assert.assertTrue(driver.findElement(By.className("android.widget.TextView"))
                .getText().equalsIgnoreCase("Name or password is not correct"));
        driver.findElement(buttonOkOnIncorrect).click();
        clearLoginPass();
        return new LoginPage(driver);
    }

    public void enterLoginPass(String log,String pass) {
        driver.findElement(login).click();
        driver.findElement(login).sendKeys(log);
        driver.findElement(password).click();
        driver.findElement(password).sendKeys(pass);
        driver.findElement(login_Button).click();
    }

    public void clearLoginPass() {
        TouchAction action = new TouchAction((MobileDriver) driver);
        action.longPress(driver.findElement(login)).perform();
        driver.findElement(login).clear();
        action.longPress(driver.findElement(password)).perform();
        driver.findElement(password).clear();
    }

    public void validLogin() {
        waitForVisible(login, 3);
        enterLoginPass(Properties.LOGIN_TRUE, Properties.PASS_TRUE);
//        waitForVisibilityOf(By.className("android.widget.LinearLayout"));
//        waitForClickabilityOf(By.className("android.widget.LinearLayout"));
        waitForVisible(By.id("com.trinetix.pharmatouch:id/button_text"), 300);

//        driver.manage().timeouts().implicitlyWait(5, TimeUnit.MINUTES);
//        (new WebDriverWait(driver, 300)).until(ExpectedConditions.visibilityOf(driver.findElement(By.className("android.widget.LinearLayout"))))
        ;
//        (new WebDriverWait(driver, 300)).until(waitForVisibilityOf(By.className("android.widget.LinearLayout")));
        Assert.assertTrue(driver.findElement(By.id("com.trinetix.pharmatouch:id/button_text")).getText().equalsIgnoreCase("Profile"));
//        return new LoginPage(driver);
    }
}
