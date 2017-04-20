package selenium.buisness;

import selenium.model.User;
import selenium.pages.InboxPage;
import selenium.pages.LoginPage;

/**
 * Created by Maryna on 05.04.2017.
 */
public class LoginBO {

    private LoginPage loginPage;
    private User user;

    public LoginBO(User user) {
        loginPage = new LoginPage();
        this.user = user;
    }

    public InboxPage loginUser() {
        loginPage.sendKeysToEmail(user.getLogin());
        loginPage.submitEmail();
        loginPage.sendKeysToPasswd(user.getPasswd());
        loginPage.submitPasswd();
        return new InboxPage();
    }
//    public InboxPage loginUserSuccess(String email, String password) {
//        loginUser(email,password);
//        return new InboxPage(driver);
//    }
}
