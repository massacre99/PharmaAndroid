package android.automation.pharmatouch.pages;

import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

/**
 * Created by massacre99 on 20.04.2018.
 */
public class ContactListPage extends BasePage {

    By contactListView = By.id("listViewClients"); //By.id("drag_layer");
    By planButton = By.xpath("(//*[@resource-id ='com.trinetix.pharmatouch:id/action_bar_button'])[1]");
    By sortButton = By.xpath("(//*[@resource-id ='com.trinetix.pharmatouch:id/action_bar_button'])[2]");
    By filterButton = By.xpath("(//*[@resource-id ='com.trinetix.pharmatouch:id/action_bar_button'])[3]");
    By editSearchField = By.id("editSearchField");
    By cancelSearchButton = By.id("imageButtonSearchCancelClickZone");
    By confirmSearchButton = By.id("imageButtonSearchClickZone");
    By contactList = By.id("layout_container");
    By contactName = By.id("text_name");
    By contactSpec = By.id("text_position");
    By contactCompany = By.id("text_place");
    By contactAdress = By.id("Text_address");

    public ContactEditPage openNewContactEditPageFromPlusButton() {
        driver.findElement(plusViewButton).click();
        return new ContactEditPage(driver);
    }

    public ContactPage clickOnContact(WebElement contact) {
        contact.click();
        return new ContactPage(driver);
    }

    public TaskActionSwipePage planSwipeFromContactListPage() {
        driver.findElement(planButton).click();
        return new TaskActionSwipePage(driver);
    }

    public ContactListPage(AndroidDriver driver) {
        super(driver);
    }
}
