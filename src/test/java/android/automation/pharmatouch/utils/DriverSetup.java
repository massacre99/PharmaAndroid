package android.automation.pharmatouch.utils;


import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.AndroidMobileCapabilityType;
import io.appium.java_client.remote.MobileCapabilityType;
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


        /*
        capabilities.setCapability("appium-version", "1.0");
        capabilities.setCapability("platformName", "Android");
        capabilities.setCapability("platformVersion", "4.4.4");
        capabilities.setCapability("deviceName", "Galaxy Tab E");
        capabilities.setCapability("automationName", "uiautomator2"); //for android 7+
        capabilities.setCapability("automationName", "UIAutomator");
        capabilities.setCapability("app", new File(DriverSetup.class.getResource("/PharmaTouch.apk").getFile()).getPath());
        capabilities.setCapability("apppackage", "com.trinetix.pharmatouch");
        capabilities.setCapability("appactivity", "com.trinetix.pharmatouch.StartActivity");
        capabilities.setCapability("noReset", true); // Не переустанавливает приложение при вызове драйвера
        */

        capabilities.setCapability(MobileCapabilityType.APPIUM_VERSION, "1.0");
        capabilities.setCapability(MobileCapabilityType.PLATFORM_NAME,"Android");
        capabilities.setCapability(MobileCapabilityType.PLATFORM_VERSION, "4.4.4");
        capabilities.setCapability(MobileCapabilityType.DEVICE_NAME, "Galaxy Tab E");
        capabilities.setCapability(MobileCapabilityType.APP,
                new File(DriverSetup.class.getResource("/PharmaTouch.apk").getFile()).getPath());
//        capabilities.setCapability(MobileCapabilityType.AUTOMATION_NAME, "uiautomator2"); //for android 7+
//        capabilities.setCapability(MobileCapabilityType.AUTOMATION_NAME, "UIAutomator");
        capabilities.setCapability(AndroidMobileCapabilityType.APP_PACKAGE, "com.trinetix.pharmatouch");
        capabilities.setCapability(AndroidMobileCapabilityType.APP_ACTIVITY, ".StartActivity");
        capabilities.setCapability(MobileCapabilityType.NO_RESET, true);

//        capabilities.setCapability("appWaitActivity", "com.trinetix.pharmatouch.StartActivity, com.trinetix.pharmatouch.TabletMainScreenActivity");
//        capabilities.setCapability("fullReset", false);


        return new AndroidDriver(new URL("http://localhost:4723/wd/hub"), capabilities);
    }
}
