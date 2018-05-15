package EmailAccount;

import java.time.LocalDate;

public class MsgClass implements Msg {
    private final String subject;
    private final String email;
    private final String text;
    private final LocalDate date;

    public MsgClass(String subject, String email, String text, LocalDate date) {
        this.subject = subject;
        this.email = email;
        this.date = date;
        this.text = text;
    }

    @Override
    public String getEmail() {
        return email;
    }

    @Override
    public int compareTo(Msg other) {
        return this.email.compareTo(other.getEmail());
    }

    @Override
    public String toString(){
        return date + " | "  + subject + " | " + email + " | " + text;
    }

    public String toStringWithoutText(){
        return date + " | "  + subject + " | " + email;
    }
}
