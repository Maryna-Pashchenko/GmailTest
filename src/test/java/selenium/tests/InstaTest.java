package selenium.tests;

import com.opencsv.CSVParser;
import com.opencsv.CSVWriter;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import selenium.CsvParser;
import selenium.model.User;
import selenium.utils.Constants;
import selenium.utils.DriverManager;

import java.util.ArrayList;
import java.util.List;

public class InstaTest {
    @BeforeMethod
    public void setDriver() {
        DriverManager.getDriver();
    }

    @Test
    public void testCorrectDraftSaving() {
        DriverManager.getUrl("https://www.instagram.com/p/Bn8_pU5AlHC/?taken-by=baldiyzfrendiy");
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
//        DriverManager.getDriver().findElement(By.cssSelector("#react-root > section > main > article > div.rgFsT > div:nth-child(2) > p > a")).click();
//        try {
//            Thread.sleep(5000);
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        }
        List<WebElement> elements = DriverManager.getDriver().findElements(By.xpath("//button[text() = 'Load more comments']"));
        int counter = 0;
        int loop = 400;
        List<String[]> data  = new ArrayList<String[]>();
        int size=0;
        while(elements.size()>0)
        {
            waitElement(elements.get(0));
            elements.get(0).click();
            counter++;
            Constants.LOG.info(counter);
//            try {
//                Thread.sleep(1500);
//            } catch (InterruptedException e) {
//                e.printStackTrace();
//            }
            if(counter > loop){
                List<WebElement> authors  = DriverManager.getDriver().findElements(By.xpath("//li//div/a[contains(@class, 'notranslate')]"));
                List<WebElement> comments = DriverManager.getDriver().findElements(By.xpath("//li//div/a[contains(@class, 'notranslate')]/following-sibling::span"));


                for (int i=1; i<authors.size(); i++){
//                    Constants.LOG.info(authors.get(i).getText() + "   " + comments.get(i).getText());
                    data.add(new String[]{String.valueOf(i), authors.get(i).getText(), comments.get(i).getText()});

                }
                CsvParser.writeToCsv(data);
                data.clear();
                Constants.LOG.info(authors.size());
                size+= authors.size()-1;
                loop+=loop;
            }
            elements = DriverManager.getDriver().findElements(By.xpath("//button[text() = 'Load more comments']"));

        }

        DriverManager.getDriver().findElement(By.xpath("//button[contains(text(), 'View all')]")).click();
//        DriverManager.getDriver().findElements(By.xpath("//button[text() = 'Load more comments']"));
        List<WebElement> authors  = DriverManager.getDriver().findElements(By.xpath("//li//div/a[contains(@class, 'notranslate')]"));
        List<WebElement> comments = DriverManager.getDriver().findElements(By.xpath("//li//div/a[contains(@class, 'notranslate')]/following-sibling::span"));



        Constants.LOG.info(comments.size());

    }

    public void waitElement(WebElement element) {
        WebDriverWait waitDriver = new WebDriverWait(DriverManager.getDriver(), 60);
        waitDriver.until(
                ExpectedConditions.elementToBeClickable(element));
    }

}
