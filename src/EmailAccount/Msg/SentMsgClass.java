package EmailAccount.Msg;

import java.time.LocalDateTime;

public class SentMsgClass extends MsgClass implements Sent {
    public SentMsgClass(String subject, String email, String text, LocalDateTime date) {
        super(subject, email, text, date);
    }

    @Override
    public String toString() {
        return getDate() + " | " + getSubject() + " | " + getEmail() + " | " + getText();
    }
}
