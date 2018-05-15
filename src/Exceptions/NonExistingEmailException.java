package Exceptions;

public class NonExistingEmailException extends RuntimeException{
    private static final String Non_Existing_Email = "Nao existem mensagens trocadas com esse assunto.";

    public NonExistingEmailException() {
        super();
    }

    public String getErrorMsg() {
        return Non_Existing_Email;
    }
}
