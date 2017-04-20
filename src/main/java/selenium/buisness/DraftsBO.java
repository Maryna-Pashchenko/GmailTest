package selenium.buisness;

import selenium.model.User;
import selenium.pages.DraftPage;

/**
 * Created by Maryna on 06.04.2017.
 */
public class DraftsBO {
    private DraftPage draftPage;
    User user;

    public DraftsBO(User user) {
        this.user = user;
        draftPage = new DraftPage();
    }

    public void openFirstDraft(){
        draftPage.clickOnFirstDraft();
    }
}
