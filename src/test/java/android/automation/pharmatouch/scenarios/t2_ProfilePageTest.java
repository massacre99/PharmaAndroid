package android.automation.pharmatouch.scenarios;

import android.automation.pharmatouch.utils.BaseTest;
import org.testng.annotations.Test;

/**
 * Created by massacre99 on 27.03.2018.
 */
public class t2_ProfilePageTest extends BaseTest {

    @Test(testName = "date at profile page")
    public void PA1() {
        profilePage.clickDaysMonth();

    }

    @Test //(dependsOnMethods = "PA3")
    public void PA2() {
        profilePage.swipeVisitAtWeek();
    }

    @Test(testName = "Add visit from + Button")
    public void PA3() {
        profilePage.addNewTask();
    }

    @Test
    public void PA5 () {
        profilePage.deleteRandomTask();

    }

    @Test
    public void test() {
//        profilePage.deleteRandomTask();
        //        companyEditPage.createNewCompany();
    }
}
