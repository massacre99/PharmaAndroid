package android.automation.pharmatouch.scenarios;

import android.automation.pharmatouch.utils.BaseTest;
import org.testng.annotations.Test;

/**
 * Created by massacre99 on 27.03.2018.
 */
public class t2_ProfilePageTest extends BaseTest {

    @Test
    public void clickTest() {
//        profilePage.clickDaysMonth();
        profilePage.createNewCompany();
    }
}
