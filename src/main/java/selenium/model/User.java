package selenium.model;

/**
 * Created by Maryna on 06.04.2017.
 */
public class User {
    private String login;
    private String passwd;
    private MailData mailData;

    public User() {
    }

   public User(User user) {
        this.login = user.getLogin();
        this.passwd = user.getPasswd();
        this.mailData=user.mailData;
    }

    public User(String login, String passwd, MailData mailData) {
        this.login = login;
        this.passwd = passwd;
        this.mailData = mailData;
    }

    public void setLoginPasswd(String login, String passwd) {
        this.login = login;
        this.passwd = passwd;
    }

    public String getLogin() {
        return login;
    }

    public String getPasswd() {
        return passwd;
    }

    public void setMailData(MailData mailData) {
        this.mailData = mailData;
    }

    public MailData getMailData() {
        return mailData;
    }
}
