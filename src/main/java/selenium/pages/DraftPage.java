package selenium.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import selenium.decorator.CustomFieldDecorator;
import selenium.elements.LinkElement;
import selenium.utils.DriverManager;

/**
 * Created by Maryna on 01.04.2017.
 */
public class DraftPage {
    private WebDriver driver;

    @FindBy(xpath = "//div[@class='BltHke nH oy8Mbf']//table[@class = 'F cf zt']/tbody/*[1]")
    private LinkElement lastSavedDraft;

    public DraftPage() {
        driver = DriverManager.getDriver();
        PageFactory.initElements(new CustomFieldDecorator(driver), this);

    }

    public void clickOnFirstDraft(){
        lastSavedDraft.click();
    }
}
