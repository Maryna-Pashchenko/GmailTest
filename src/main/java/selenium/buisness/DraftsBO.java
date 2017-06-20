package selenium.buisness;

import selenium.model.User;
import selenium.pages.DraftPage;

public class DraftsBO {
    private DraftPage draftPage;
    private User user;

    public DraftsBO(User user) {
        this.user = user;
        draftPage = new DraftPage();
    }

    public void openFirstDraft(){
        draftPage.clickOnFirstDraft();
    }
    public void func(){

    }
}
