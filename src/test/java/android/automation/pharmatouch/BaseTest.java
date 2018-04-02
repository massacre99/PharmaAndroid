package android.automation.pharmatouch.utils;

import android.automation.pharmatouch.pages.LoginPage;
import android.automation.pharmatouch.pages.ProfilePage;
import io.appium.java_client.android.AndroidDriver;
import org.testng.annotations.BeforeClass;

import java.net.MalformedURLException;
import java.util.concurrent.TimeUnit;

/**
 * Created by massacre99 on 27.03.2018.
 */
public class BaseTest {
    protected AndroidDriver driver;
    protected ProfilePage profilePage;
    protected LoginPage loginPage;

    @BeforeClass
    public void setUp() throws MalformedURLException {
//    @Parameters({"selenium.grid"})
//    public void setUp(@Optional("") String gridUrl) throws MalformedURLException {
//        AndroidDriver tempDriver;
//        if (gridUrl.equals("")) {
//            tempDriver = DriverSetup.initDriver();
//        }
//        else {
//            tempDriver = DriverSetup.initDriver(gridUrl);
//        }

        driver = DriverSetup.initDriver();
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);

        profilePage = new ProfilePage(driver);

    }
}
