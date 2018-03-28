package android.automation.pharmatouch.scenarios;


import android.automation.pharmatouch.utils.BaseTest;
import org.testng.annotations.Test;

/**
 * Created by massacre99 on 27.03.2018.
 */
public class t1_LoginPageTest extends BaseTest {

    @Test
    public void falseLogin() throws InterruptedException {
        loginPage.invalidLogin();
    }

    @Test
    public void trueLogin() {
        loginPage.validLogin();
    }
}
