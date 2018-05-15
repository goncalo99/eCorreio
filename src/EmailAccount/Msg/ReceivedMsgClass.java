package EmailAccount.Msg;

import java.time.LocalDateTime;

public class ReceivedMsgClass extends MsgClass implements Received {
    public ReceivedMsgClass(String subject, String email, String text, LocalDateTime date) {
        super(subject, email, text, date);
    }

    @Override
    public String toString() {
        return getDate() + " | " + subjectPrefix + getSubject() + " | " + getEmail() + " | " + getText();
    }
}
