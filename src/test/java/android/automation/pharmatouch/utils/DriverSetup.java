package android.automation.pharmatouch.utils;


import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;

/**
 * Created by massacre99 on 27.03.2018.
 */
public class DriverSetup {

    public static AndroidDriver initDriver() throws MalformedURLException {
        DesiredCapabilities capabilities = new DesiredCapabilities();

        capabilities.setCapability("appium-version", "1.0");
        capabilities.setCapability("platformName", "Android");
        capabilities.setCapability("platformVersion", "7.1.1");
        capabilities.setCapability("deviceName", "Tablet");
        capabilities.setCapability("app", new File(DriverSetup.class.getResource("/PharmaTouch.apk").getFile()).getPath());
//        capabilities.setCapability("app", "D:\\AppiumDemo\\apps\\PharmaTouch.apk");
        capabilities.setCapability("apppackage", "com.trinetix.pharmatouch");
        capabilities.setCapability("appactivity", "com.trinetix.pharmatouch.StartActivity");
        capabilities.setCapability("appWaitActivity", "com.trinetix.pharmatouch.StartActivity, com.trinetix.pharmatouch.TabletMainScreenActivity");
        capabilities.setCapability("noReset", true); // Не переустанавливает приложение при вызове драйвера
        capabilities.setCapability("fullReset", false);

        return new AndroidDriver(new URL("http://127.0.0.1:4723/wd/hub"), capabilities);
    }
}
