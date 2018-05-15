package EmailAccount;

import java.time.LocalDateTime;

public interface EmailAccount {
    void sendMsg(LocalDateTime date, String subject, String email, String text);
}
