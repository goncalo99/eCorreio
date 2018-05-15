package EmailAccount.Msg;

import java.time.LocalDateTime;

abstract class MsgClass implements Msg {
    private final String subject;
    private final String email;
    private final String text;
    private final LocalDateTime date;

    public MsgClass(String subject, String email, String text, LocalDateTime date) {
        this.subject = subject;
        this.email = email;
        this.date = date;
        this.text = text;
    }

    @Override
    public String getSubject() {
        return subject;
    }

    @Override
    public String getEmail() {
        return email;
    }

    @Override
    public String getText() {
        return text;
    }

    @Override
    public LocalDateTime getDate() {
        return date;
    }

    @Override
    public int compareTo(Msg other) {
        return this.email.compareTo(other.getEmail());
    }

    @Override
    public abstract String toString();
}
