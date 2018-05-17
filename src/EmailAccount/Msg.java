package EmailAccount;

interface Msg extends Comparable<Msg> {
    String getEmail();
    String getSubject();
    String toStringWithoutText();

}
