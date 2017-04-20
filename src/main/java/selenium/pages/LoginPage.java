package selenium.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import selenium.decorator.CustomFieldDecorator;
import selenium.elements.InputField;
import selenium.utils.DriverManager;

/**
 * Created by Maryna on 01.04.2017.
 */
public class LoginPage {

    private WebDriver driver;

    @FindBy(name = "Email")
    private InputField email;

    @FindBy(name = "Passwd")
    private InputField passwd;


    public LoginPage() {
        driver = DriverManager.getDriver();
        PageFactory.initElements(new CustomFieldDecorator(driver), this);

    }

    public void sendKeysToEmail(String key) {
        email.sendKeys(key);
    }

    public void sendKeysToPasswd(String key) {
        passwd.sendKeys(key);
    }

    public void submitEmail() {
        email.submit();
    }

    public void submitPasswd() {
        passwd.submit();
    }

}
