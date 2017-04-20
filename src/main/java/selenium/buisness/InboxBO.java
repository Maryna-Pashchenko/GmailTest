package selenium.buisness;

import selenium.model.User;
import selenium.pages.InboxPage;

/**
 * Created by Maryna on 06.04.2017.
 */
public class InboxBO {
    private InboxPage inboxPage;
    private User user;

    public InboxBO( User user) {
        inboxPage = new InboxPage();
        this.user = user;
    }

    public void writeNewMail(){
      inboxPage.clickOnComposeButton();
    }
    public void openDrafts(){
        inboxPage.openDrafts();
    }
}
