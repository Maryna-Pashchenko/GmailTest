package selenium.elements;

import org.openqa.selenium.WebElement;

/**
 * Created by Maryna on 01.04.2017.
 */
public class InputField extends Element {

    public InputField(WebElement webElement) {
        super(webElement);
    }

    public void sendKeys(String key) {
        webElement.sendKeys(key);
    }

    public void submit() {
        webElement.submit();
    }
}
