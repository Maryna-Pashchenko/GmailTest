package selenium.utils;

import selenium.model.MailData;
import selenium.model.User;

import java.io.IOException;
import java.util.Properties;

/**
 * Created by Maryna on 05.04.2017.
 */
public class PropertiesLoader {
    private Properties properties;

    public PropertiesLoader(String path) throws IOException {
        properties = new Properties();
        properties.load(getClass().getClassLoader().getResourceAsStream(path));
    }

    public User readUser1() {
        User user = new User();
        user.setLoginPasswd(properties.getProperty("login"), properties.getProperty("passwd"));
        user.setMailData(new MailData(properties.getProperty("receiver"), properties.getProperty("subject"),
                properties.getProperty("mailText")));
     return user;
    }
    public User readUser2() {
        User user = new User();
        user.setLoginPasswd(properties.getProperty("login2"), properties.getProperty("passwd2"));
        user.setMailData(new MailData(properties.getProperty("receiver2"), properties.getProperty("subject2"),
                properties.getProperty("mailText2")));
        return user;
    }
    public User readUser3() {
        User user = new User();
        user.setLoginPasswd(properties.getProperty("login3"), properties.getProperty("passwd3"));
        user.setMailData(new MailData(properties.getProperty("receiver3"), properties.getProperty("subject3"),
                properties.getProperty("mailText3")));
        return user;
    }
}
