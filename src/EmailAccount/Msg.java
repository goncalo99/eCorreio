package EmailAccount;

interface Msg extends Comparable<Msg> {
    String getEmail();
    String toStringWithoutText();

}
