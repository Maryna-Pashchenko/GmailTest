package selenium.elements;

import org.openqa.selenium.WebElement;

/**
 * Created by Maryna on 01.04.2017.
 */
public class Element {
    protected WebElement webElement;

    Element(WebElement webElement) {
        this.webElement = webElement;
    }

    public String getAttribute(String attribute) {
        return webElement.getAttribute(attribute);
    }

    public void click() {
        webElement.click();
    }


    public String getText() {
        return webElement.getText();
    }

    public boolean isVisible() {
        return webElement.isDisplayed();
    }

}
