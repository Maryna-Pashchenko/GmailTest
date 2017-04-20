package selenium.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import selenium.decorator.CustomFieldDecorator;
import selenium.elements.Button;
import selenium.elements.LinkElement;
import selenium.utils.DriverManager;

/**
 * Created by Maryna on 01.04.2017.
 */
public class InboxPage {
    private WebDriver driver;


    @FindBy(css="div[class='T-I J-J5-Ji T-I-KE L3']")
    private Button compose;


    @FindBy(xpath = ".//a[starts-with(@title, 'Drafts')]")
    private LinkElement drafts;

    public InboxPage() {
        driver = DriverManager.getDriver();
        PageFactory.initElements(new CustomFieldDecorator(driver), this);
    }

    public DraftPage openDrafts(){
        drafts.click();
        return new DraftPage();
    }

    public void clickOnComposeButton(){
        compose.click();
    }

}
