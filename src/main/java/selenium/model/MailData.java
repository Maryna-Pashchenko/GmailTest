package selenium.model;

/**
 * Created by Maryna on 06.04.2017.
 */
public class MailData {
    private String receiver;
    private String subject;
    private String mailText;
    public MailData(String receiver, String subject, String mailText){
        this.receiver=receiver;
        this.subject=subject;
        this.mailText=mailText;
    }

    public String getReceiver() {
        return receiver;
    }

    public String getSubject() {
        return subject;
    }

    public String getMailText() {
        return mailText;
    }
}
