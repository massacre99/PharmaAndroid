package android.automation.pharmatouch.pages;

import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

/**
 * Created by massacre99 on 20.04.2018.
 */
public class CompanyListPage extends BasePage {

    By companyListView = By.id("listViewClients"); //By.id("drag_layer");
    By planButton = By.xpath("(//*[@resource-id ='com.trinetix.pharmatouch:id/action_bar_button'])[1]");
    By sortButton = By.xpath("(//*[@resource-id ='com.trinetix.pharmatouch:id/action_bar_button'])[2]");
    By filterButton = By.xpath("(//*[@resource-id ='com.trinetix.pharmatouch:id/action_bar_button'])[3]");
    By editSearchField = By.id("editSearchField");
    By cancelSearchButton = By.id("imageButtonSearchCancelClickZone");
    By confirmSearchButton = By.id("imageButtonSearchClickZone");
    By companyList = By.id("linearLayout");
    By companyName = By.id("text_agensy_name");
    By companyAdress = By.id("text_agensy_address");


    public CompanyEditPage openNewCompanyEditPageFromPlusButton() {
        driver.findElement(plusViewButton).click();
        return new CompanyEditPage(driver);
    }

    public CompanyPage clickOnCompany(WebElement company) {
        company.click();
        return new CompanyPage(driver);
    }

    public TaskActionSwipePage planSwipeFromCompanyListPage() {
        driver.findElement(planButton).click();
        return new TaskActionSwipePage(driver);
    }

    public CompanyListPage(AndroidDriver driver) {
        super(driver);
    }

}
