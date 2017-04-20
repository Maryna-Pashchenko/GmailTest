package selenium.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import selenium.decorator.CustomFieldDecorator;
import selenium.elements.Button;
import selenium.elements.InputField;
import selenium.utils.DriverManager;

/**
 * Created by Maryna on 01.04.2017.
 */
//comment
public class NewMailPage {
    private WebDriver driver;
    @FindBy(name = "to")
    private InputField receiver;

    int k;
    @FindBy(name = "subjectbox")
    private InputField subject;

    @FindBy(name = "subject")
    private InputField savedSubject;

    @FindBy(xpath = ".//*[@class=\"oL aDm az9\"]/span")
    private InputField savedReceiver;

    @FindBy(css = ".Am.Al.editable.LW-avf")
    private InputField mailText;

    @FindBy(className = "Ha")
    Button close;


    public NewMailPage() {
        driver = DriverManager.getDriver();
        PageFactory.initElements(new CustomFieldDecorator(driver), this);
    }

    public void sendKeysToReceiver(String key) {
        receiver.sendKeys(key);
    }

    public void sendKeysToSubject(String key) {
        subject.sendKeys(key);
    }

    public void sendKeysToMailText(String key) {
        mailText.sendKeys(key);
    }

    public void clickOnCloseButton() {
        close.click();
    }


    public InputField getMailText() {
        return mailText;
    }

    public InputField getSavedSubject() {
        return savedSubject;
    }

    public InputField getSavedReceiver() {
        return savedReceiver;
    }

}
