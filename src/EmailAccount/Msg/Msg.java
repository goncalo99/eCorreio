package EmailAccount.Msg;

import java.time.LocalDateTime;

interface Msg extends Comparable<Msg> {
    String getSubject();

    String getEmail();

    String getText();

    LocalDateTime getDate();
}
