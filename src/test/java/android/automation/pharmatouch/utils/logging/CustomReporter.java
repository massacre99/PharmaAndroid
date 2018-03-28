package android.automation.pharmatouch.utils.logging;

/**
 * Created by massacre99 on 27.03.2018.
 */

import org.testng.Reporter;

import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

/**
 * Custom reporting wrapper for TestNG.
 */
public class CustomReporter {
    private CustomReporter() {
    }

    /**
     * Logs action step that will be highlighted in test execution report.
     */
    public static void logAction(String message) {
        Reporter.log(String.format("[%-12s] ACTION: %s", LocalTime.now().format(DateTimeFormatter.ISO_LOCAL_TIME), message));
    }

    /**
     * Logs simple step.
     */
    public static void log(String message) {
        Reporter.log(String.format("[%-12s] %s", LocalTime.now().format(DateTimeFormatter.ISO_LOCAL_TIME), message));
    }
}
