package selenium.tests;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import selenium.buisness.DraftsBO;
import selenium.buisness.InboxBO;
import selenium.buisness.LoginBO;
import selenium.buisness.NewMailBO;
import selenium.model.MailData;
import selenium.model.User;
import selenium.utils.DriverManager;
import selenium.utils.PropertiesLoader;

import java.io.IOException;

import static junit.framework.Assert.assertEquals;
import static selenium.utils.Constants.LOG;
import static selenium.utils.Constants.URL;

/**
 * Created by Maryna on 01.04.2017.
 */
public class NewGmailTest {

    private PropertiesLoader propertiesLoader = null;

    @BeforeMethod
    public void setDriver() {
        DriverManager.getDriver();
    }

    @DataProvider(name = "test1", parallel = true)
    public Object[][] getUser() {
        User user;
        User user2;
        User user3;
        try {
            String path = "data.properties";
            propertiesLoader = new PropertiesLoader(path);
        } catch (IOException e) {
            e.printStackTrace();
        }
        user = propertiesLoader.readUser1();
        user2 = propertiesLoader.readUser2();
        user3 = propertiesLoader.readUser3();
        return new Object[][]{{user}, {user2}, {user3}};
    }


    @Test(dataProvider = "test1")
    public void testCorrectDraftSaving(User user) {
        DriverManager.getUrl(URL);
        LOG.info("Logging...");
        LoginBO loginBO = new LoginBO(user);
        loginBO.loginUser();
        LOG.info("Creating new mail...");
        InboxBO inboxBO = new InboxBO(user);
        inboxBO.writeNewMail();
        NewMailBO newMailBO = new NewMailBO(user);
        newMailBO.sendDataToFields();
        newMailBO.closeMail();
        inboxBO.openDrafts();
        DraftsBO draftsBO = new DraftsBO(user);
        draftsBO.openFirstDraft();
        LOG.info("Checking for correct saving...");
        MailData mailData = newMailBO.getSavedData();
        assertEquals(user.getMailData().getReceiver(), mailData.getReceiver());
        assertEquals(user.getMailData().getSubject(), mailData.getSubject());
        assertEquals(user.getMailData().getMailText(), mailData.getMailText());
    }

    @AfterMethod
    public void tearDown() {
        DriverManager.tearDown();
    }


}
