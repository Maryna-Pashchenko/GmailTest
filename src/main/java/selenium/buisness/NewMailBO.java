package selenium.buisness;

import selenium.model.MailData;
import selenium.model.User;
import selenium.pages.NewMailPage;

/**
 * Created by Maryna on 06.04.2017.
 */
public class NewMailBO {
    private NewMailPage newMailPage;
    private User user;

    public NewMailBO(User user) {
        newMailPage = new NewMailPage();
        this.user = user;
    }

    public void sendDataToFields() {
        newMailPage.sendKeysToReceiver(user.getMailData().getReceiver());
        newMailPage.sendKeysToSubject(user.getMailData().getSubject());
        newMailPage.sendKeysToMailText(user.getMailData().getMailText());
    }

    public void closeMail() {
        newMailPage.clickOnCloseButton();
    }

    public MailData getSavedData() {
        String savedReceiver = newMailPage.getSavedReceiver().getText();
        String savedSubject = newMailPage.getSavedSubject().getAttribute("value");
        String savedMailText = newMailPage.getMailText().getText();
        return new MailData(savedReceiver, savedSubject, savedMailText);
    }
}
