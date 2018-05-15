package Exceptions;

public class NonExistingSubjectException extends RuntimeException {
    private static final String Non_Existing_Subject = "Nao existem mensagens trocadas com esse assunto.";

    public NonExistingSubjectException() {
        super();
    }

    public String getErrorMsg() {
        return Non_Existing_Subject;
    }
}
